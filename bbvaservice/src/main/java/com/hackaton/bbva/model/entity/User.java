package com.hackaton.bbva.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SEG_USER")
@Getter
@Setter
public class User {

   @JsonIgnore
   @Id
   @Column(name = "ID")
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;

   @Column(name = "DNI", length = 50, unique = true)
   @Size(min = 4, max = 50)
   private String dni;

   @JsonIgnore
   @Column(name = "USERNAME", length = 50, unique = true)
   @Size(min = 4, max = 50)
   private String username;

   @JsonIgnore
   @Column(name = "PASSWORD", length = 100)
   @Size(min = 4, max = 100)
   private String password;

   @Column(name = "FIRSTNAME", length = 50)
   @Size(min = 4, max = 50)
   private String firstname;

   @Column(name = "LASTNAME", length = 50)
   @Size(min = 4, max = 50)
   private String lastname;

   @Column(name = "EMAIL", length = 50)
   @Size(min = 4, max = 50)
   private String email;

   @Column(name = "AGE", length = 10)
   @Size(min = 4, max = 100)
   private Integer age;

   @Column(name = "PHONE", length = 10)
   @Size(min = 4, max = 100)
   private Integer phone;

   @Column(name = "GENDER", length = 10)
   @Size(min = 4, max = 10)
   private String gender;

   @Column(name = "PROFILE", length = 200)
   @Size(min = 4, max = 200)
   private String profile;

   @JsonIgnore
   @Column(name = "TOKEN_ACCESS")
   private String token_access;

   @JsonIgnore
   @Column(name = "ACTIVATED")
   private boolean activated;

   @JsonIgnore
   @Column(name = "EXPERIENCE")
   private Integer Experience;

   @JsonIgnore
   @Column(name = "INCOME")
   private Integer income;

   @JsonIgnore
   @Column(name = "FAMILY")
   private Integer family;

   @JsonIgnore
   @Column(name = "CCAVG")
   private Integer ccavg;

   @JsonIgnore
   @Column(name = "MORTGAGE")
   private Integer mortgage;

   @JsonIgnore
   @Column(name = "SECURITIES")
   private Integer securities ;

   @JsonIgnore
   @Column(name = "ACCOUNT")
   private Integer account ;

   @JsonIgnore
   @Column(name = "CD_ACCOUNT")
   private Integer cd_account;

   @JsonIgnore
   @Column(name = "ONLINE")
   private Integer online;

   @JsonIgnore
   @Column(name = "CREDITCARD")
   private Integer creditCard;

   @JsonIgnore
   @Column(name = "EDUCATION_2")
   private Integer education_2;

   @JsonIgnore
   @Column(name = "EDUCATION_3")
   private Integer education_3;

   @ManyToMany
   @JoinTable(
      name = "SEG_USER_AUTHORITY",
      joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
      inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_NAME", referencedColumnName = "NAME")})
   @BatchSize(size = 20)
   private Set<Authority> authorities = new HashSet<>();

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id.equals(user.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}