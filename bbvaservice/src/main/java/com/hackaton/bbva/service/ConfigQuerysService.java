package com.hackaton.bbva.service;

import com.hackaton.bbva.handler.ModelNotFoundException;
import com.hackaton.bbva.model.entity.ConfigQuerys;
import com.hackaton.bbva.model.request.ConfigQuerysRq;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface ConfigQuerysService {
    Single<ConfigQuerys> get(Long id) throws ModelNotFoundException;

    Single<ConfigQuerys> save(ConfigQuerysRq model) throws Exception;

    Single<ConfigQuerys> update(Long id, ConfigQuerysRq model) throws ModelNotFoundException;

    Completable delete(Long id) throws ModelNotFoundException;
}
