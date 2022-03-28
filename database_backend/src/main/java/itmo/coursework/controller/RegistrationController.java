package itmo.coursework.controller;

import itmo.coursework.config.security.Role;
import itmo.coursework.config.security.RolesPropertiesKt;
import itmo.coursework.model.NewUser;
import itmo.coursework.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/databases")
@EnableAutoConfiguration
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/signup")
    public @ResponseBody
    ResponseEntity registerUser(@RequestBody NewUser newUser) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(registrationService.registerNewUser(newUser));
    }

    @GetMapping("/permissions")
    public @ResponseBody
    ResponseEntity tst() {
        var role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get().getAuthority();
        var permissions = RolesPropertiesKt.getRolesToPermissionsMap().get(Role.valueOf(role));

        return ResponseEntity.status(HttpStatus.OK).body(permissions);
    }
}
