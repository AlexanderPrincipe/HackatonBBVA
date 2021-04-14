package com.hackaton.bbva.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SEG_USER_INTERESTS")
public class UserInterests implements Serializable {

    @JsonIgnore
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

//    @OneToMany
//    @JoinTable(
//            name = "SEG_USER",
//            joinColumns = {@JoinColumn(name = "ID", referencedColumnName = "ID_USER")})
//    @BatchSize(size = 20)
//    private User user;
//
//    @OneToMany
//    @JoinTable(
//            name = "SEG_INTERESTS",
//            joinColumns = {@JoinColumn(name = "ID", referencedColumnName = "ID_INTERESTS")})
//    @BatchSize(size = 20)
//    private Interests interests;

    @Column(name = "IS_CLIENT", length = 1)
    @NotNull
    @Size(min = 0, max = 1)
    private Integer is_client;

    @Column(name = "MARITAL_STATUS", length = 1)
    @NotNull
    @Size(min = 0, max = 1)
    private Integer marital_status;

    @Column(name = "NUMBER_RELATIVES", length = 1)
    @NotNull
    @Size(min = 0, max = 1)
    private Integer number_relatives;

    @Column(name = "EDUCATION", length = 150)
    @NotNull
    @Size(min = 0, max = 150)
    private String education;

    @Column(name = "FREQUENCY_BUYS", length = 21)
    @NotNull
    @Size(min = 0, max = 21)
    private Integer frequency_buys;

    @Column(name = "MORTGAGE", length = 1)
    @NotNull
    @Size(min = 0, max = 1)
    private Integer mortgage;

    @Column(name = "EXPENSES", length = 100000)
    @NotNull
    @Size(min = 0, max = 100000)
    private float expenses;

    @Column(name = "SAVING", length = 10000000)
    @NotNull
    @Size(min = 0, max = 10000000)
    private float saving;

}
