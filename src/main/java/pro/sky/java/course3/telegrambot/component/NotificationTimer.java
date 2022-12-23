package pro.sky.java.course3.telegrambot.component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.java.course3.telegrambot.entity.NotificationTask;
import pro.sky.java.course3.telegrambot.listener.TelegramBotUpdateListener;
import pro.sky.java.course3.telegrambot.repository.NotificationTaskRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class NotificationTimer {

    private final TelegramBot telegramBot;

    private final NotificationTask notificationTask;

    private final NotificationTaskRepository notificationTaskRepository;

    private final TelegramBotUpdateListener telegramBotUpdateListener;

    public NotificationTimer(TelegramBot telegramBot,
                             NotificationTaskRepository notificationTaskRepository,
                             NotificationTask notificationTask,
                             TelegramBotUpdateListener telegramBotUpdateListener) {
        this.telegramBot = telegramBot;
        this.notificationTaskRepository = notificationTaskRepository;
        this.notificationTask = notificationTask;
        this.telegramBotUpdateListener = telegramBotUpdateListener;
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void checkNotifications() {
        LocalDateTime currentDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        notificationTaskRepository.findAllByDateTime(currentDateTime).forEach(notificationTask - > {
                SendMessage sendMessage = new SendMessage(notificationTask.getChatId(),notificationTask.getText());
        telegramBot.execute(sendMessage);
        })
    }
}
