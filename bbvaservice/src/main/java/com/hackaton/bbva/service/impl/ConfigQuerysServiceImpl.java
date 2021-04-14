package com.hackaton.bbva.service.impl;

import com.hackaton.bbva.handler.ModelNotFoundException;
import com.hackaton.bbva.model.constants.GlobalConstants;
import com.hackaton.bbva.model.entity.ConfigQuerys;
import com.hackaton.bbva.model.request.ConfigQuerysRq;
import com.hackaton.bbva.repository.ConfigQuerysRepository;
import com.hackaton.bbva.service.ConfigQuerysService;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfigQuerysServiceImpl implements ConfigQuerysService {

    private final ConfigQuerysRepository configQuerysRepository;

    public ConfigQuerysServiceImpl(ConfigQuerysRepository configQuerysRepository) {
        this.configQuerysRepository = configQuerysRepository;
    }

    @Override
    public Single<ConfigQuerys> get(Long id) throws ModelNotFoundException {
        return Single.create(singleSubscriber -> {
            Optional<ConfigQuerys> exchangeOptional = configQuerysRepository.findById(id);
            if (!exchangeOptional.isPresent()) {
                singleSubscriber.onError(new ModelNotFoundException(String.format(GlobalConstants.CONFIG_QUERY_NOT_FOUND, id)));
            } else {
                singleSubscriber.onSuccess(exchangeOptional.get());
            }
        });
    }

    @Override
    public Single<ConfigQuerys> save(ConfigQuerysRq model) throws Exception {
        return Single.create(singleSubscriber -> {
            ConfigQuerys configQuerys = configQuerysRepository.save(toConfigQuery(model));
            if (configQuerys.getIdConfigQuerys() == null) {
                singleSubscriber.onError(new Exception(GlobalConstants.CONFIG_QUERY_SAVE_FAILED));
            } else {
                singleSubscriber.onSuccess(configQuerys);
            }
        });
    }

    @Override
    public Single<ConfigQuerys> update(Long id, ConfigQuerysRq model) throws ModelNotFoundException {
        return Single.create(singleSubscriber -> {
            Optional<ConfigQuerys> exchangeOptional = configQuerysRepository.findById(id);
            if (!exchangeOptional.isPresent()) {
                singleSubscriber.onError(new ModelNotFoundException(String.format(GlobalConstants.CONFIG_QUERY_NOT_FOUND, id)));
            } else {
                ConfigQuerys configQuerys = toConfigQuery(model);
                configQuerys.setIdConfigQuerys(id);
                singleSubscriber.onSuccess(configQuerysRepository.save(configQuerys));
            }
        });
    }

    @Override
    public Completable delete(Long id) throws ModelNotFoundException {
        return Completable.create(completableEmitter -> {
            Optional<ConfigQuerys> exchangeOptional = configQuerysRepository.findById(id);
            if (!exchangeOptional.isPresent()) {
                completableEmitter.onError(new ModelNotFoundException(String.format(GlobalConstants.CONFIG_QUERY_NOT_FOUND, id)));
            } else {
                configQuerysRepository.deleteById(id);
                completableEmitter.onComplete();
            }
        });
    }

    private ConfigQuerys toConfigQuery(ConfigQuerysRq model) {
        ConfigQuerys exchange = new ConfigQuerys();
        BeanUtils.copyProperties(model, exchange);
        return exchange;
    }
}