package com.hackaton.bbva.service.impl;

import com.hackaton.bbva.handler.ModelNotFoundException;
import com.hackaton.bbva.model.constants.GlobalConstants;
import com.hackaton.bbva.model.entity.ConfigQuerys;
import com.hackaton.bbva.model.entity.Interests;
import com.hackaton.bbva.repository.InterestsRepository;
import com.hackaton.bbva.service.InterestsService;
import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InterestsServiceImpl implements InterestsService {

    private final InterestsRepository interestsRepository;

    public InterestsServiceImpl(InterestsRepository interestsRepository) {
        this.interestsRepository = interestsRepository;
    }

    @Override
    public Single<List<Interests>> getInterests() {
        return Single.create(singleSubscriber -> {
            Optional<List<Interests>> exchangeOptional = Optional.of(interestsRepository.findAll());
            if (!exchangeOptional.isPresent()) {
                singleSubscriber.onError(new ModelNotFoundException(String.format("Sin datos registrados")));
            } else {
                singleSubscriber.onSuccess(exchangeOptional.get());
            }
        });
    }
}