package ru.vudovenko.oauth2.spring.testoauth2.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Тестовый контроллер
 */
@Log4j2
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('admin')")
    public String delete(@PathVariable("id") String id,
                         @AuthenticationPrincipal Jwt jwt) {

        log.info("jwt.getSubject() = {}", jwt.getSubject());
        log.info("id delete = {}", id);
        return "delete work";
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('admin')")
    public String add() {
        return "add work";
    }

    @GetMapping("/view")
    @PreAuthorize("hasRole('user')")
    public String view() {
        return "view work";
    }
}
