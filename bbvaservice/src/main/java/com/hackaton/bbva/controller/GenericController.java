package com.hackaton.bbva.controller;

import com.hackaton.bbva.handler.ModelNotFoundException;
import com.hackaton.bbva.model.response.BaseResponse;
import com.hackaton.bbva.model.response.GeneralResponse;
import com.hackaton.bbva.model.response.Row;
import com.hackaton.bbva.service.GenericService;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/public/generic")
public class GenericController {

    @Autowired
    private GenericService genericService;

    @GetMapping("/list/{code}")
    public ResponseEntity<GeneralResponse<List<Row>>> getAll(@PathVariable String code,
                                                             @RequestParam Map<String, Object> filters) throws ModelNotFoundException {
        GeneralResponse<List<Row>> response = new GeneralResponse<>();
        response.setData(genericService.getAll(code, filters, false));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/listByParams/{code}")
    public ResponseEntity<GeneralResponse<List<Row>>> getAllByParams(@PathVariable String code,
                                                             @RequestParam Map<String, Object> filters) throws ModelNotFoundException {
        GeneralResponse<List<Row>> response = new GeneralResponse<>();
        response.setData(genericService.getAll(code, filters, true));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/single/{code}")
    public Single<ResponseEntity<BaseResponse<Row>>> getOne(@PathVariable String code) throws ModelNotFoundException {
        return genericService.getOne(code)
                .subscribeOn(Schedulers.io())
                .map(data -> ResponseEntity.ok(BaseResponse.successWithData(data)));
    }

    // APIS INTERMEDIARIAS
    @PostMapping("/{code}")
    public Single<ResponseEntity<BaseResponse<Object>>> genericPOST(@PathVariable String code,
                                                                    @RequestBody(required = false) Map<String, Object> body,
                                                                    @RequestParam(required = false) Map<String, Object> params) throws Exception {
        return genericService.executeGenericService(code, body, params)
                .subscribeOn(Schedulers.io())
                .map(data -> ResponseEntity.ok(BaseResponse.successWithData(data)));
    }

    @PutMapping("/{code}")
    public Single<ResponseEntity<BaseResponse<Object>>> genericPUT(@PathVariable String code,
                                                                   @RequestBody(required = false) Map<String, Object> body,
                                                                   @RequestParam(required = false) Map<String, Object> params) throws Exception {
        return genericService.executeGenericService(code, body, params)
                .subscribeOn(Schedulers.io())
                .map(data -> ResponseEntity.ok(BaseResponse.successWithData(data)));
    }

    @GetMapping("/{code}")
    public Single<ResponseEntity<BaseResponse<Object>>> genericGET(@PathVariable String code,
                                                                   @RequestParam(required = false) Map<String, Object> params) throws Exception {
        return genericService.executeGenericService(code, params)
                .subscribeOn(Schedulers.io())
                .map(data -> ResponseEntity.ok(BaseResponse.successWithData(data)));
    }

    @DeleteMapping("/{code}")
    public Single<ResponseEntity<BaseResponse<Object>>> genericDELETE(@PathVariable String code,
                                                                      @RequestParam(required = false) Map<String, Object> params) throws Exception {
        return genericService.executeGenericService(code, params)
                .subscribeOn(Schedulers.io())
                .map(data -> ResponseEntity.ok(BaseResponse.successWithData(data)));
    }
}
