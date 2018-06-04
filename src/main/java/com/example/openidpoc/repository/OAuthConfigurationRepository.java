package com.example.openidpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.openidpoc.entity.OAuthConfiguration;

@Repository
public interface OAuthConfigurationRepository extends JpaRepository<OAuthConfiguration, Long> {
}
