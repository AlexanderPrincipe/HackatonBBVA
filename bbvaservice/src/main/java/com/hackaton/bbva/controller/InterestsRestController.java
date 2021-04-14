package com.hackaton.bbva.controller;

import com.hackaton.bbva.handler.ModelNotFoundException;
import com.hackaton.bbva.model.entity.ConfigQuerys;
import com.hackaton.bbva.model.entity.Interests;
import com.hackaton.bbva.model.entity.User;
import com.hackaton.bbva.model.request.UserRq;
import com.hackaton.bbva.model.response.BaseResponse;
import com.hackaton.bbva.service.InterestsService;
import com.hackaton.bbva.service.UserService;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/public/interests")
public class InterestsRestController {

    private final InterestsService interestsService;

    public InterestsRestController(InterestsService interestsService) {
        this.interestsService = interestsService;
    }

    @GetMapping("")
    public Single<ResponseEntity<BaseResponse<List<Interests>>>> getAllInterests() throws ModelNotFoundException {
        return interestsService.getInterests()
                .subscribeOn(Schedulers.io())
                .map(data -> ResponseEntity.ok(BaseResponse.successWithData(data)));
    }
}