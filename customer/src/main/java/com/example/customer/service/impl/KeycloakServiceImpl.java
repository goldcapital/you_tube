package com.example.customer.service.impl;

import com.example.customer.config.AuthProperties;
import com.example.customer.dto.request.CustomerChangePasswordRequest;
import com.example.customer.exp.CustomerNotFoundException;
import com.example.customer.service.KeycloakService;
import com.example.customer.util.ConversionUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;

import static com.example.customer.exp.ErrorMessage.USERNAME_NOT_FOUND;
import static java.lang.String.format;
@Slf4j
@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {
    private final  Keycloak keycloak;
    private final AuthProperties authProperties;

    @Override
    public Object changePassword(CustomerChangePasswordRequest request) {
        var user = getKeycloakUser(request.username());
        ConversionUtils.changePassword(user, request);
        try{

            mainResource().get(user.getId()).update(user);
        } catch (RuntimeException ex) {
           // log.warn("Error while updating user in Keycloak", ex);
            throw new BadRequestException("Failed to update user in Keycloak: " + ex.getMessage());
        }
        return user;

    }

    private UserRepresentation getKeycloakUser(String username) {
        var users = mainResource().search(username, true);
        if (users == null || users.isEmpty()) {
         log.warn(USERNAME_NOT_FOUND, username);
            throw new CustomerNotFoundException(format(USERNAME_NOT_FOUND, username));
        }
        if (users.size() > 1) {
            log.warn("More than one Keycloak user found with username/username: {}", username);
        }


        return users.get(0);

    }

    private UsersResource mainResource() {
        return keycloak.realm(authProperties.getRealm()).users();
    }
}
