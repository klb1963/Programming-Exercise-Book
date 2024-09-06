package de.ait_tr.g_36_shop.controller;

import de.ait_tr.g_36_shop.domain.entity.User;
import de.ait_tr.g_36_shop.exception_handling.Response;
import de.ait_tr.g_36_shop.service.interfaces.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register") // это endpoint
public class RegistrationController {

    // внедряем UserService
    private final UserService service;

    public RegistrationController(UserService service) {
        this.service = service;
    }

    // методом POST посылать user (name, password, email )
    @PostMapping
    public Response register(@RequestBody User user) {
        service.register(user);
        return new Response("Registration complete. Please check your email.");
    }

}
