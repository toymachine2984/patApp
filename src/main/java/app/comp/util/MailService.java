package app.comp.util;

import app.comp.entity.system.User;

import java.util.Locale;

public interface MailService {

    void sendVerificationToken(User user, String token, Locale locale);
}
