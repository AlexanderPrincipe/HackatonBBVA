package com.hackaton.bbva.service;

import com.hackaton.bbva.handler.ModelNotFoundException;
import com.hackaton.bbva.model.response.Row;
import io.reactivex.rxjava3.core.Single;

import java.util.List;
import java.util.Map;

public interface GenericService {
    List<Row> getAll(String code, Map<String, Object> filters, boolean byParams) throws ModelNotFoundException;

    Single<Row> getOne(String code);

    Single<Object> executeGenericService(String code, Map<String, Object> data, Map<String, Object> params) throws Exception;

    Single<Object> executeGenericService(String code, Map<String, Object> params) throws Exception;
}
