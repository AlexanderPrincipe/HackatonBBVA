package com.hackaton.bbva.service;

import com.hackaton.bbva.model.entity.ConfigQuerys;
import com.hackaton.bbva.model.entity.Interests;
import com.hackaton.bbva.model.response.BaseResponse;
import io.reactivex.rxjava3.core.Single;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InterestsService {

    Single<List<Interests>>  getInterests();
}