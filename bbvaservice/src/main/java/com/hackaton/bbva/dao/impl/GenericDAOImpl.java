package com.hackaton.bbva.dao.impl;

import com.hackaton.bbva.dao.GenericDAO;
import com.hackaton.bbva.model.constants.GlobalConstants;
import com.hackaton.bbva.model.entity.ConfigQuerys;
import com.hackaton.bbva.model.response.Row;
import com.hackaton.bbva.util.GlobalUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GenericDAOImpl implements GenericDAO {

    private final JdbcTemplate jdbcTemplate;

    public GenericDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Row> getAll(ConfigQuerys configQuerys, Map<String, Object> filters, boolean byParmas) {
        // OBTENEMOS LA CONFIGURACION DE LOS FILTROS
        Row configFilters = GlobalUtil.jsonToRow(configQuerys.getFilter());

        String query;
        if (!byParmas) {
            // CONSTRUIMOS LAS CONDICIONES EN LAS QUERYS
            StringBuilder sqlAnd = GlobalUtil.buildConditions(filters, configFilters);

            if (!sqlAnd.isEmpty())
                query = configQuerys.getQuery()
                        .replace(GlobalConstants.WHERE, GlobalConstants.WHERE_TRUE + sqlAnd.toString());
            else
                query = configQuerys.getQuery()
                        .replace(GlobalConstants.WHERE, GlobalConstants.WHERE_TRUE);
        } else {
            query = GlobalUtil.replaceValuesInFilters(configQuerys.getQuery(), filters);
        }
        List<Map<String, Object>> dataMap = jdbcTemplate.queryForList(query);
        return GlobalUtil.toListRow(dataMap);
    }

    @Override
    public Row getOne(String query) {
        return jdbcTemplate.queryForObject(query, Row.class);
    }
}