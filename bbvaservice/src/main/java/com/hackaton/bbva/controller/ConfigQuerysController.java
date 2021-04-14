package com.hackaton.bbva.controller;

import com.hackaton.bbva.handler.ModelNotFoundException;
import com.hackaton.bbva.model.entity.ConfigQuerys;
import com.hackaton.bbva.model.request.ConfigQuerysRq;
import com.hackaton.bbva.model.response.BaseResponse;
import com.hackaton.bbva.service.ConfigQuerysService;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/public/configquerys")
public class ConfigQuerysController {

    private final ConfigQuerysService configQuerysService;

    public ConfigQuerysController(ConfigQuerysService configQuerysService) {
        this.configQuerysService = configQuerysService;
    }

    @GetMapping("/{id}")
    public Single<ResponseEntity<BaseResponse<ConfigQuerys>>> get(@PathVariable Long id) throws ModelNotFoundException {
        return configQuerysService.get(id)
                .subscribeOn(Schedulers.io())
                .map(data -> ResponseEntity.ok(BaseResponse.successWithData(data)));
    }

    @PostMapping
    public Single<ResponseEntity<BaseResponse<ConfigQuerys>>> save(@RequestBody ConfigQuerysRq model) throws Exception {
        return configQuerysService.save(model)
                .subscribeOn(Schedulers.io())
                .map(data -> ResponseEntity.ok(BaseResponse.successWithData(data)));
    }

    @PutMapping("/{id}")
    public Single<ResponseEntity<BaseResponse>> update(@PathVariable Long id, @RequestBody ConfigQuerysRq model) throws ModelNotFoundException {
        return configQuerysService.update(id, model)
                .subscribeOn(Schedulers.io())
                .map(data -> ResponseEntity.ok(BaseResponse.successWithData(data)));
    }

    @DeleteMapping("/{id}")
    public Single<ResponseEntity<BaseResponse>> delete(@PathVariable Long id) throws ModelNotFoundException {
        return configQuerysService.delete(id)
                .subscribeOn(Schedulers.io())
                .toSingle(() -> ResponseEntity.ok(BaseResponse.successNoData()));
    }
}