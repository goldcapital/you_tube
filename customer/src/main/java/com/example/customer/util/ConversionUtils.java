package com.example.customer.util;

import com.example.customer.dto.request.CustomerChangePasswordRequest;
import lombok.experimental.UtilityClass;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

@UtilityClass
public class ConversionUtils {
    public  static void changePassword(UserRepresentation userRepresentation, CustomerChangePasswordRequest request) {
        if (request.password()!=null){
            var credential = new CredentialRepresentation();
            credential.setValue(request.password());
            credential.setTemporary(false);
            credential.setType(CredentialRepresentation.PASSWORD);
            userRepresentation.setCredentials(List.of(credential));

        }
    }
}
