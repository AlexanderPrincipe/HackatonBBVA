package com.hackaton.bbva.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CONFIG_QUERYS")
@Getter
@Setter
public class ConfigQuerys {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONFIG_QUERYS")
    @SequenceGenerator(name="SQ_CONFIG_QUERYS", sequenceName = "SQ_CONFIG_QUERYS", allocationSize = 1)
    private Long idConfigQuerys;
    private String code;
    private String query;
    private String filter;
}