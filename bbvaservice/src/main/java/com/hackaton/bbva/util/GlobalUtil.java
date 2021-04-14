package com.hackaton.bbva.util;

import com.hackaton.bbva.model.constants.EnumFieldOperators;
import com.hackaton.bbva.model.constants.EnumFieldTypes;
import com.hackaton.bbva.model.constants.GlobalConstants;
import com.hackaton.bbva.model.response.Row;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GlobalUtil {

    private static final Logger logger = LoggerFactory.getLogger(GlobalUtil.class);

    public static String stackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Row jsonToRow(String json) {
        Row row = null;
        if (json != null && !json.isBlank()) {
            Gson gson = new Gson();
            row = gson.fromJson(json, Row.class);
        }
        return row;
    }

    public static StringBuilder buildConditions(Map<String, Object> filters, Row config) {
        StringBuilder ands = new StringBuilder();
        Gson gson = new Gson();
        filters.forEach((k, v) -> {
            if (v != null && !v.toString().isBlank()) {
                if (config.get(k) != null) {
                    Row configFilter = jsonToRow(gson.toJson(config.get(k)));
                    EnumFieldTypes fieldType = EnumFieldTypes.valueOf(configFilter.getString("type").toUpperCase());
                    EnumFieldOperators fieldOperator = EnumFieldOperators.valueOf(configFilter.getString("operator").toUpperCase());
                    ands.append(buildCondition(fieldType, fieldOperator, configFilter.getString("field"), v.toString()));
                }
            }
        });
        return ands;
    }

    public static String replaceValuesInFilters(String query, Map<String, Object> filters) {
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().toString().isBlank()) {
                query = query
                        .replace(String.format(GlobalConstants.META, entry.getKey().toUpperCase()), entry.getValue().toString().toUpperCase());
            }
        }
        return query;
    }

    public static String buildCondition(EnumFieldTypes fieldType, EnumFieldOperators fieldOperator, String field, String value) {
        String condition = "";
        if (fieldOperator == EnumFieldOperators.IN || fieldOperator == EnumFieldOperators.NOT_IN) {
            List<String> values = Arrays.asList(value.split(GlobalConstants.DELIMITER));
            if (fieldType == EnumFieldTypes.NUMBER) {
                condition = GlobalConstants.AND_MULTIPLE
                        .replace(GlobalConstants.META_COLUMN, field)
                        .replace(GlobalConstants.META_OPERATOR, fieldOperator.getOperator())
                        .replace(GlobalConstants.META_VALUE, String.join(",", values));
            } else if (fieldType == EnumFieldTypes.TEXT || fieldType == EnumFieldTypes.DATE) {
                condition = GlobalConstants.AND_MULTIPLE
                        .replace(GlobalConstants.META_COLUMN, field)
                        .replace(GlobalConstants.META_OPERATOR, fieldOperator.getOperator())
                        .replace(GlobalConstants.META_VALUE, values.stream()
                                .map(v -> GlobalConstants.VALUE_TEXT
                                        .replace(GlobalConstants.META_VALUE, v.trim().toUpperCase()))
                                .collect(Collectors.joining(",")));
            }
        } else if (fieldOperator == EnumFieldOperators.LIKE || fieldOperator == EnumFieldOperators.NOT_LIKE) {
            if (fieldType == EnumFieldTypes.TEXT) {
                condition = GlobalConstants.AND_TEXT
                        .replace(GlobalConstants.META_COLUMN, field)
                        .replace(GlobalConstants.META_OPERATOR, fieldOperator.getOperator())
                        .replace(GlobalConstants.META_VALUE, GlobalConstants.VALUE_TEXT_LIKE
                                .replace(GlobalConstants.META_VALUE, value.trim().toUpperCase()));
            }
        } else {
            if (fieldType == EnumFieldTypes.NUMBER) {
                condition = GlobalConstants.AND
                        .replace(GlobalConstants.META_COLUMN, field)
                        .replace(GlobalConstants.META_OPERATOR, fieldOperator.getOperator())
                        .replace(GlobalConstants.META_VALUE, GlobalConstants.VALUE
                                .replace(GlobalConstants.META_VALUE, value));
            } else if (fieldType == EnumFieldTypes.TEXT || fieldType == EnumFieldTypes.DATE) {
                condition = GlobalConstants.AND_TEXT
                        .replace(GlobalConstants.META_COLUMN, field)
                        .replace(GlobalConstants.META_OPERATOR, fieldOperator.getOperator())
                        .replace(GlobalConstants.META_VALUE, GlobalConstants.VALUE_TEXT
                                .replace(GlobalConstants.META_VALUE, value.trim().toUpperCase()));
            }
        }
        return condition;
    }

    public static String encodeURL(String value) {
        String newValue = null;
        try {
            newValue = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            logger.error("Error al codificar URL");
        }
        return newValue;
    }

    public static String decodeURL(String value) {
        String newValue = null;
        try {
            newValue = URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            logger.error("Error al decodificar URL");
        }
        return newValue;
    }

    public static List<Row> toListRow(List<Map<String, Object>> data) {
        List<Row> rows = new ArrayList<>();
        for (Map<String, Object> map : data) {
            rows.add(toRow(map));
        }
        return rows;
    }

    public static Row toRow(Map<String, Object> data) {
        Row row = new Row();
        for (String key : data.keySet())
            row.put(key.toLowerCase(), data.get(key));
        return row;
    }
}