package com.hackaton.bbva.service.impl;

import com.hackaton.bbva.dao.GenericDAO;
import com.hackaton.bbva.handler.ModelNotFoundException;
import com.hackaton.bbva.model.constants.GlobalConstants;
import com.hackaton.bbva.model.entity.ConfigQuerys;
import com.hackaton.bbva.model.response.Row;
import com.hackaton.bbva.repository.ConfigQuerysRepository;
import com.hackaton.bbva.service.GenericService;
import com.hackaton.bbva.util.RestClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final ConfigQuerysRepository configQuerysRepository;
    private final GenericDAO genericDAO;

    public GenericServiceImpl(ConfigQuerysRepository configQuerysRepository, GenericDAO genericDAO) {
        this.configQuerysRepository = configQuerysRepository;
        this.genericDAO = genericDAO;
    }

    @Override
    public List<Row> getAll(String code, Map<String, Object> filters, boolean byParams) throws ModelNotFoundException {
        Optional<ConfigQuerys> optionalConfigQuerys = configQuerysRepository.findConfigQuerysByCode(code);
        if (optionalConfigQuerys.isPresent()) {
            ConfigQuerys configQuerys = optionalConfigQuerys.get();
            return genericDAO.getAll(configQuerys, filters, byParams);
        } else {
            throw new ModelNotFoundException(String.format(GlobalConstants.CONFIG_QUERY_NOT_FOUND_CODE, code));
        }
    }

    @Override
    public Single<Row> getOne(String code) throws ModelNotFoundException {
        return Single.create(singleSubscriber -> {
            Optional<ConfigQuerys> optionalConfigQuerys = configQuerysRepository.findConfigQuerysByCode(code);
            if (!optionalConfigQuerys.isPresent()) {
                singleSubscriber.onError(new ModelNotFoundException(String.format(GlobalConstants.CONFIG_QUERY_NOT_FOUND_CODE, code)));
            } else {
                ConfigQuerys configQuerys = optionalConfigQuerys.get();
                singleSubscriber.onSuccess(genericDAO.getOne(configQuerys.getQuery()));
            }
        });
    }

    @Override
    public Single<Object> executeGenericService(String code, Map<String, Object> data, Map<String, Object> params) throws Exception {
        return Single.create(singleSubscriber -> {
            try {
                RestClient client = new RestClient();
                // Peticion
                Object response = client.requestByAlias(jdbcTemplate, code)
                        //.addQueryParams(params)
                        .addBody(data)
                        .withResponseError(true)
                        .execute(new TypeToken<>() {});
                if (response != null) {
                    Gson gson = new Gson();
                    if (response instanceof ArrayList) {
                        singleSubscriber.onSuccess(response);
                    } else {
                        Row row = gson.fromJson(gson.toJson(response), Row.class);
                        if (row.getString("message") != null) {
                            singleSubscriber.onError(new Exception(GlobalConstants.CONFIG_API_ERROR));
                        } else {
                            singleSubscriber.onSuccess(response);
                        }
                    }
                } else {
                    singleSubscriber.onError(new Exception(GlobalConstants.CONFIG_API_ERROR));
                }
            } catch (Exception e) {
                singleSubscriber.onError(new Exception(GlobalConstants.CONFIG_API_ERROR));
            }
        });
    }

    @Override
    public Single<Object> executeGenericService(String code, Map<String, Object> params) throws Exception {
        Double latitud = Double.parseDouble(params.get("latitud").toString());
        Double longitud = Double.parseDouble(params.get("longitud").toString());
        params.put("latitud", latitud);
        params.put("longitud", longitud);
        return executeGenericService(code, params, null);
    }
}
