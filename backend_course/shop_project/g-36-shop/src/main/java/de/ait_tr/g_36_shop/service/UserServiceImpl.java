package de.ait_tr.g_36_shop.service;

import de.ait_tr.g_36_shop.domain.entity.Role;
import de.ait_tr.g_36_shop.domain.entity.User;
import de.ait_tr.g_36_shop.repository.UserRepository;
import de.ait_tr.g_36_shop.service.interfaces.EmailService;
import de.ait_tr.g_36_shop.service.interfaces.RoleService;
import de.ait_tr.g_36_shop.service.interfaces.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    // подключаем необходимые классы и их объекты (DI)
    private final UserRepository repository; // repo for users
    private final BCryptPasswordEncoder encoder; // password encoder
    private final RoleService roleService; // repo for Roles
    private final EmailService emailService; // сервис для отправки письма

    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder encoder, RoleService roleService, EmailService emailService) {
        this.repository = repository;
        this.encoder = encoder;
        this.roleService = roleService;
        this.emailService = emailService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("User %s not found", username))
        );
    }

    @Override
    public void register(User user) {

        // TODO *** домашнее задание - учесть, что пользователь
        // TODO может регистрироваться уже не первый раз
        // TODO например, если первый раз он просто не успел до истечения срока действия кода
        user.setId(null); // обнуляем по любому, чтобы база создала новый
        user.setPassword(encoder.encode(user.getPassword())); // закодировали пароль для пользователя

        Role userRole = roleService.getRoleUser(); // достали наименование роли из репозитория ролей
        user.setRoles(Set.of(userRole)); // установили пользователю роль USER_ROLE
        user.setActive(false); // установили значение поля active = false

        // TODO обработать все возможные ошибки - домашнее задание
        repository.save(user); // сохраняем пользователя в репозитории 
        emailService.sendConfirmationEmail(user);// отправляем ему письмо

    }
}
