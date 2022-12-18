package pro.sky.java.course3.telegrambot.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

@Bean
public class FixedDelay {
    @Scheduled(fixedDelay = 1_000L)
    public void run() {
    }
}
