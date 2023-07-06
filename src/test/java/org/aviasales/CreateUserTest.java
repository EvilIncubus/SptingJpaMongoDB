package org.aviasales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class CreateUserTest {
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;
    @Test
    public void createUser() {
        System.out.println(bCryptPasswordEncoder.encode("admin"));
        System.out.println(bCryptPasswordEncoder.encode("customer"));
    }
}
