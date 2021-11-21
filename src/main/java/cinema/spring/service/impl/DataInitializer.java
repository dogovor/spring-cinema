package cinema.spring.service.impl;

import java.util.Set;
import javax.annotation.PostConstruct;
import cinema.spring.model.Role;
import cinema.spring.model.RoleName;
import cinema.spring.model.User;
import cinema.spring.service.RoleService;
import cinema.spring.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(RoleName.USER);
        roleService.add(userRole);
        User admin = new User();
        admin.setEmail("admin@email.ua");
        admin.setPassword("admin");
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);
        User user = new User();
        user.setEmail("user@email.ua");
        user.setPassword("user");
        user.setRoles(Set.of(userRole));
        userService.add(user);
    }
}
