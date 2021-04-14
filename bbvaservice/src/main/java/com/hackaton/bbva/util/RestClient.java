package com.hackaton.bbva.util;

import com.hackaton.bbva.model.constants.RequestMethod;
import com.hackaton.bbva.model.response.Row;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * AUTHOR: VD
 * REST CLIENT: JDK 8
 */
public class RestClient {

    private static final Logger logger = LoggerFactory.getLogger(RestClient.class);

    private HttpURLConnection con;
    private final Map<String, Object> headers;
    private final Map<String, Object> params;
    private final List<Object> pathParams;
    private String body;
    private RequestMethod method;
    private String URL;
    private final Gson gson;
    private boolean withResponseError;

    public RestClient() {
        gson = new Gson();
        headers = new HashMap<>();
        params = new HashMap<>();
        pathParams = new ArrayList<>();
        this.body = "";
        this.withResponseError = false;
    }

    public RestClient request(String URL) {
        this.URL = URL;
        return this;
    }

    public RestClient request(String URL, RequestMethod method) {
        this.URL = URL;
        this.method = method;
        return this;
    }

    public RestClient requestByAlias(JdbcTemplate jdbcTemplate, String code) throws Exception {
        String sql = "SELECT * FROM OPENCOVID.TBL_CONFIG_APIS WHERE UPPER(TRIM(CODE)) = '" + code.trim().toUpperCase() + "'";
        List<Map<String, Object>> responseMap = jdbcTemplate.queryForList(sql);
        List<Row> response = GlobalUtil.toListRow(responseMap);
        // ASIGNAMOS LA URL
        this.URL = response.get(0).getString("url");
        // ASIGNAMOS EL TIPO DE PETICIÓN
        this.method = RequestMethod.valueOf(response.get(0).getString("method"));
        // ASIGNAMOS EL TOKEN
        String token = response.get(0).getString("header");
        if (token != null && !token.isEmpty()) {
            this.headers.put("Authorization", token);
        }
        return this;
    }

    public RestClient addHeaders(Map<String, Object> headers) {
        this.headers.putAll(headers);
        return this;
    }

    public RestClient addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public RestClient addQueryParams(Map<String, Object> params) {
        this.params.putAll(params);
        return this;
    }

    public RestClient addQueryParam(String key, String value) {
        this.params.put(key, value);
        return this;
    }

    public RestClient addPathParams(List<Object> pathParams) {
        if (pathParams != null && !pathParams.isEmpty())
            this.pathParams.addAll(pathParams);
        return this;
    }

    public RestClient addPathParam(Object value) {
        this.pathParams.add(value);
        return this;
    }

    public RestClient addBody(Object data) {
        if (method != RequestMethod.GET && method != RequestMethod.DELETE && data != null)
            this.body = gson.toJson(data);
        return this;
    }

    public RestClient withResponseError(boolean withResponseError) {
        this.withResponseError = withResponseError;
        return this;
    }

    public RestClient setMethod(RequestMethod method) throws Exception {
        try {
            this.method = method;
            if (con != null) {
                if (this.method != null) con.setRequestMethod(method.name());
                else con.setRequestMethod(RequestMethod.GET.name());
                if (method == RequestMethod.POST || method == RequestMethod.PUT || method == RequestMethod.PATCH) {
                    con.setDoOutput(true);
                }
            }
            return this;
        } catch (ProtocolException e) {
            throw new ProtocolException(String.format("El método %s no es soportado", method.name()));
        }
    }

    public RestClient setURL(String URL) {
        this.URL = URL;
        return this;
    }

    private void openURL(boolean ping) throws Exception {
        try {
            if (URL == null || URL.isEmpty())
                throw new Exception("Falta especificar la URL");
            logger.info("OPEN URL");
            URL obj = new URL(URL);
            con = (HttpURLConnection) obj.openConnection();
            logger.info("END OPEN URL");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            if (this.method != null) con.setRequestMethod(method.name());
            else con.setRequestMethod(RequestMethod.GET.name());
            if (ping) {
                logger.info("setConnectTimeout 3000");
                con.setConnectTimeout(3000);
                logger.info("setReadTimeout 3000");
                con.setReadTimeout(3000);
                logger.info("endTimeouts");
            }
        } catch (ProtocolException e) {
            throw new ProtocolException(String.format("El método %s no es soportado", method.name()));
        }
    }

    private void setHeaders() {
        if (!headers.isEmpty())
            headers.entrySet().stream()
                    .filter(p -> p.getValue() != null && !p.getValue().toString().isEmpty())
                    .forEach(p -> con.setRequestProperty(p.getKey(), p.getValue().toString()));
    }

    private String getQueryString() {
        return params.entrySet().stream()
                .filter(p -> p.getValue() != null && !p.getValue().toString().isEmpty())
                .map(p -> String.format("%s=%s", p.getKey(), GlobalUtil.encodeURL(p.getValue().toString())))
                .collect(Collectors.joining("&"));
    }

    public <T> T execute(Class<T> clazz) throws Exception {
        return execute(clazz, null);
    }

    public <T> T execute(TypeToken<T> typeToken) throws Exception {
        return execute(null, typeToken);
    }

    private <T> T execute(Class<T> clazz, TypeToken<T> typeToken) throws Exception {
        // PATH VARIABLES
        if (!pathParams.isEmpty())
            for (int i = 0; i < pathParams.size(); i++) {
                Object value = pathParams.get(i);
                URL = URL.replace(String.format("/param%d", i + 1), value == null ? "/" : "/" + value.toString());
            }

        if (!params.isEmpty())
            URL = String.format("%s?%s", URL, getQueryString());
        openURL(false);
        setMethod(method);

        // ENVIAR HEADER
        setHeaders();

        // ENVIAR BODY
        if (!body.isEmpty()) {
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = body.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
        }

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // RECUPERAR RESPONSE
            StringBuilder response = new StringBuilder();
            String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();

            // TRANSFORMAMOS EL RESPONSE
            try {
                if (clazz == null)
                    return gson.fromJson(response.toString(), typeToken.getType());
                else
                    return gson.fromJson(response.toString(), clazz);
            } catch (Exception e) {
                return (T) new Row("response", response.toString());
            }
        } else {
            logger.error("{} request not worked", method.name());
            if (withResponseError) {
                // RECUPERAR RESPONSE
                StringBuilder responseError = new StringBuilder();
                String inputLine;
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                while ((inputLine = in.readLine()) != null)
                    responseError.append(inputLine);
                in.close();

                // TRANSFORMAMOS EL RESPONSE
                try {
                    if (clazz == null)
                        return gson.fromJson(responseError.toString(), typeToken.getType());
                    else
                        return gson.fromJson(responseError.toString(), clazz);
                } catch (Exception e) {
                    return (T) new Row("response", responseError.toString());
                }
            }
            return null;
        }
    }

    public HttpURLConnection ping() throws Exception {
        if (!params.isEmpty())
            URL = String.format("%s?%s", URL, getQueryString());
        openURL(true);
        setMethod(method);

        // ENVIAR HEADER
        setHeaders();

        // ENVIAR BODY
        if (!body.isEmpty()) {
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = body.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
        }
        return con;
    }
}