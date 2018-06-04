package com.example.openidpoc.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import com.example.openidpoc.constant.Gender;

@Entity
@Table(name="users")
@Setter
@Getter
@Builder
public class User extends   AbstractAuditableEntity {
    private String externalId;
    private String email;
    private String firstName;
    private String lastName;
    private String givenName;
    private String profile;
    private String avatar;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
