package com.example.test.configuration;

import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

@AllArgsConstructor
public class AudienceValidator implements OAuth2TokenValidator<Jwt> {

    private String audience;

    public OAuth2TokenValidatorResult validate(Jwt jwt){
        OAuth2Error error = new OAuth2Error("invalid_token","The required audience is invalid",null);
        if(jwt.getAudience().contains(audience)){
            return OAuth2TokenValidatorResult.success();
        }else {
            return OAuth2TokenValidatorResult.failure(error);
        }
    }


}
