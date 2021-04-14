package com.hackaton.bbva.model.request;

import com.hackaton.bbva.model.entity.Interests;
import com.hackaton.bbva.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRq {
    private User user;
    private List<Interests> interestsList;
}