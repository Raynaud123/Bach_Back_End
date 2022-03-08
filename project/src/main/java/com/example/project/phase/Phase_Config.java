package com.example.project.phase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




@Configuration
public class Phase_Config {


    String dateString = "10/09/2001";
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Date date = format.parse(dateString);

    public Phase_Config() throws ParseException {
    }

    @Bean
    CommandLineRunner commandLineRunner(PhaseRepository repository) {
        return args -> {
            Phase fase1 = new Phase(
                    "fase1", date, date,true
            );
            Phase fase2 = new Phase(
                    "fase2", date, date,false
            );
            Phase fase3 = new Phase(
                    "fase3", date, date,true
            );
            repository.saveAll(
                    List.of(fase1,fase2,fase3)
            );
        };
    }

}