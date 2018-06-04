package com.example.openidpoc.config;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.example.openidpoc.constant.Gender;
import com.example.openidpoc.entity.User;
import com.example.openidpoc.service.UserService;


public class OAuth2ClientAuthenticationProcessingFilterImpl extends OAuth2ClientAuthenticationProcessingFilter {
    @Autowired
    private UserService userService;

    public OAuth2ClientAuthenticationProcessingFilterImpl(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        //saveOrUpdateUser();
    }

    private void saveOrUpdateUser(){

        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication)getContext().getAuthentication();
        Map<String, String> detail = ((Map<String, String>)oAuth2Authentication.getUserAuthentication().getDetails());
        User  user =  User.builder().externalId(detail.get("sub")).email(detail.get("email")).firstName(detail.get("name")).lastName(detail.get("family_name")).givenName(detail.get("given_name")).profile(detail.get("profile")).avatar(detail.get("picture")).gender(Gender.getGender(detail.get("gender"))).build();
        User existingUser = userService.finByEmail(user.getEmail());
        if (Objects.nonNull(existingUser)){
            BeanUtils.copyProperties(existingUser, user, "email");
        }
        userService.createOrUpdate(user);
    }

}
