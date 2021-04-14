package com.hackaton.bbva.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigQuerysRq {
    private String code;
    private String query;
    private String filter;
}