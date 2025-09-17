package com.chandramani.eCommerce.data;

import com.chandramani.eCommerce.model.Role;
import com.chandramani.eCommerce.model.User;
import com.chandramani.eCommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Transactional
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;
    private final com.chandramani.eCommerce.data.RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Set<String> defaultRoles = Set.of("ROLE_ADMIN", "ROLE_USER");

        // Step 1: Create roles first to avoid Optional.get() errors
        createDefaultRoleIfNotExists(defaultRoles);

        // Step 2: Create default users and admins
        createDefaultUserIfNotExits();
        createDefaultAdminIfNotExists();
    }

    private void createDefaultUserIfNotExits() {
        Role userRole = getRoleOrThrow("ROLE_USER");

        for (int i = 1; i <= 5; i++) {
            String defaultEmail = "user" + i + "@email.com";
            if (userRepository.existsByEmail(defaultEmail)) {
                continue;
            }

            User user = new User();
            user.setFirstName("The User");
            user.setLastName("User" + i);
            user.setEmail(defaultEmail);
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(userRole));

            userRepository.save(user);
            System.out.println("Default user " + i + " created successfully.");
        }
    }

    public void createDefaultAdminIfNotExists() {
        Role adminRole = getRoleOrThrow("ROLE_ADMIN");

        for (int i = 1; i <= 2; i++) {
            String defaultEmail = "admin" + i + "@email.com";
            if (userRepository.existsByEmail(defaultEmail)) {
                continue;
            }

            User user = new User();
            user.setFirstName("Admin");
            user.setLastName("Admin" + i);
            user.setEmail(defaultEmail);
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(adminRole));

            userRepository.save(user);
            System.out.println("Default admin " + i + " created successfully.");
        }
    }

    private void createDefaultRoleIfNotExists(Set<String> roles) {
        roles.stream()
                .filter(role -> roleRepository.findByName(role).isEmpty())
                .map(Role::new)
                .forEach(roleRepository::save);
    }

    // Utility method to fetch role or throw error
    private Role getRoleOrThrow(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
    }
}
