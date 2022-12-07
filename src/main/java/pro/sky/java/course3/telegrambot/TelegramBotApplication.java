package pro.sky.java.course3.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@EnableScheduling
@SpringBootApplication
public class TelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class, args);
        LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);


    }
    @Scheduled(fixedDelay = 1_000L)
    public void run() {
    }


}
