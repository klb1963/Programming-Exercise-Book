package de.ait_tr.g_36_shop.service.interfaces;

import de.ait_tr.g_36_shop.domain.entity.User;

public interface EmailService {
    void sendConfirmationEmail(User user);
}