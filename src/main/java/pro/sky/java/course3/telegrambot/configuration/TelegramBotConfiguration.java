package pro.sky.java.course3.telegrambot.configuration;

import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.sky.java.course3.telegrambot.TelegramBot;
@Configuration
public class TelegramBotConfiguration {

        @Value("${telegram.bot.token}")
        private String token;

        @Bean
        public TelegramBot telegramBot() {
            TelegramBot bot = new TelegramBot(token);
            bot.execute(new DeleteMyCommands());
            return bot;
        }

    }
