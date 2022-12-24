package pro.sky.java.course3.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.java.course3.telegrambot.entity.NotificationTask;
import pro.sky.java.course3.telegrambot.repository.NotificationTaskRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TelegramBotUpdateListener implements UpdatesListener {

    private static final Pattern PATTERN = Pattern.compile("([0-9.\\s]{16})(\\s)([\\W+]+)");

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private final Logger logger = LoggerFactory.getLogger(TelegramBotUpdateListener.class);

    private final TelegramBot telegramBot;


    private final NotificationTaskRepository notificationTaskRepository;
    public TelegramBotUpdateListener(TelegramBot telegramBot, NotificationTaskRepository notificationTaskRepository) {
        this.telegramBot = telegramBot;
        this.notificationTaskRepository = notificationTaskRepository;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            long chatId = update.message().chat().id();
            String message = update.message().text();

            if ("/start".equals(message)) {
                SendMessage sendMessage = new SendMessage((chatId),
                        "Привет! Этот бот позволяет планировать уведомления. Чтобы запланировать уведомления отправьте сообщение в формате 23.12.2022 15:00 Сделать домашку"))
                telegramBot.execute(sendMessage);
            } else {
                Matcher matcher = PATTERN.matcher(message);
                if (matcher.find()) {
                    String dateTime = matcher.group(1);
                    String text = matcher.group(3);
                    LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
                    NotificationTask notificationTask = new NotificationTask();
                    notificationTaskRepository.save(notificationTask);
                } else {
                    SendMessage sendMessage = new SendMessage((chatId),
                            "Неверный формат! Чтобы запланировать уведомления отправьте сообщение в формате 23.12.2022 15:00 Сделать домашку");
                    telegramBot.execute(sendMessage);
                }
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
