package pro.sky.java.course3.telegrambot.localDateTime;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTime {
    LocalDateTime.parse("01.01.2022 20:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
            LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)

}

