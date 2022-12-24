package pro.sky.java.course3.telegrambot.entity;

import org.springframework.context.annotation.Bean;
import pro.sky.java.course3.telegrambot.component.NotificationTimer;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class  NotificationTask {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long chatId;
    private LocalDateTime dateTime;
    private String text;


    public NotificationTask() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

