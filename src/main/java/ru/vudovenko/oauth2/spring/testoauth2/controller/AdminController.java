package ru.vudovenko.oauth2.spring.testoauth2.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        log.info("jwt.getClaim(\"email\") = " + jwt.getClaim("email"));
        log.info("id delete = {}", id);
        return "delete work";
    }

    @GetMapping("/add")
    public String add() {
        return "add work";
    }

}
