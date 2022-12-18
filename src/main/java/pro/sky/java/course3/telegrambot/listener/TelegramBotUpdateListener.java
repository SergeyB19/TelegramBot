package pro.sky.java.course3.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TelegramBotUpdateListener implements UpdatesListener {

    private final Logger logger = LoggerFactory.getLogger(TelegramBotUpdateListener.class);
    private TelegramBot telegramBot;
    @Autowired
    public TelegramBotUpdateListener(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }



    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            // Process your updates here
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
}
