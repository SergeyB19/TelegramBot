package pro.sky.java.course3.telegrambot.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class  NotificationTask {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long ChatId;
    private String DateTime;
    private String localDateTime;
    private String Text;

    public NotificationTask() {
        this.ChatId = ChatId;
        this.DateTime = DateTime;
        this.localDateTime = localDateTime;
        this.Text = Text;
    }

    public Long getChatId() {
        return ChatId;
    }

    public void setChatId(Long chatId) {
        ChatId = chatId;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}

