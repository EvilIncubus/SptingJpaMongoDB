package org.aviasales;

import org.aviasales.dao.FlightDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class CreateUserTest {
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    FlightDao flightDao;
    @Test
    public void createUser() {
        System.out.println(bCryptPasswordEncoder.encode("admin"));
        System.out.println(bCryptPasswordEncoder.encode("customer"));
    }

    @Test
    public void getDateFlightTest() {
        List<LocalDateTime> localDateTimes = flightDao.getListOfDateForFlights("KIV");
        System.out.println(localDateTimes);
    }
}
