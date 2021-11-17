package com.example.loginandregistrationdemo.appuser;

import com.example.loginandregistrationdemo.registration.token.ConfirmationToken;
import com.example.loginandregistrationdemo.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    public static final String USER_NOT_FOUND_MSG = "User with e-mail %s not found";
    public static final String EMAIL_ALREADY_EXISTS_MSG = "The e-mail %s is already taken";
    public static final Integer TOKEN_DURATION_MINUTES = 15;

    // good practice: a service only is injected with its own repository
    // that's why this service needs to call the ConfirmationTokenService to save the token (instead of going directly to repository)
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExists) {
            // TODO if email not confirmed, send confirmation email (given same user)
            throw new IllegalStateException(String.format(EMAIL_ALREADY_EXISTS_MSG, appUser.getEmail()));
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser); // this line inserts the user in the database with the encoded password

        String token = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                now,
                now.plusMinutes(TOKEN_DURATION_MINUTES),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        // TODO: send e-mail

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
