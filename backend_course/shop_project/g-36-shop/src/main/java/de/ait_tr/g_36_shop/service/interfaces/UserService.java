package de.ait_tr.g_36_shop.service.interfaces;

import de.ait_tr.g_36_shop.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void register(User user);

}
