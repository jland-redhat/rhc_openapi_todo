package com.redhat.todo.api;

import com.redhat.todo.repository.TodoRepository;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.IDToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

@Controller
@RequestMapping("${openapi.todo.base-path:/v1}")
public class OpenApiController {

    @Autowired
    TodoRepository todoRepository;

    private final NativeWebRequest request;

    @Autowired
    public OpenApiController(NativeWebRequest request) {
        this.request = request;
    }

    @RequestMapping(value = "/user/details",
            method = RequestMethod.GET)
    public ResponseEntity<IDToken> getUserDetails() {
        return ResponseEntity.ok(getKeycloakSecurityContext().getIdToken());
    }


    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName(), NativeWebRequest.SCOPE_REQUEST);
    }
}
