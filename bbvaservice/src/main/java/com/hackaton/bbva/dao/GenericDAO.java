package com.hackaton.bbva.dao;

import com.hackaton.bbva.model.entity.ConfigQuerys;
import com.hackaton.bbva.model.response.Row;

import java.util.List;
import java.util.Map;

public interface GenericDAO {
    List<Row> getAll(ConfigQuerys configQuerys, Map<String, Object> filters, boolean byParmas);

    Row getOne(String query);
}
