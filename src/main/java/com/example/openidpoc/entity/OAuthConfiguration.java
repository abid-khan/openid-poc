package com.example.openidpoc.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_configurations")
public class OAuthConfiguration extends  AbstractAuditableEntity {
    private String partnerId;
    private String oauthKey;
    private String oauthSecret;
    private String oauthTokenUri;
    private String oauthAuthorizationUri;
    private String oauthScheme;
    private String oauthScope;
    private String oauthUserInfoUri;
    private String preferTokenInfo;
}
