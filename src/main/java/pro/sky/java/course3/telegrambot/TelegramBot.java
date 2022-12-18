package pro.sky.java.course3.telegrambot;

import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.context.annotation.Bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Bean
public class TelegramBot {

    public void execute(DeleteMyCommands deleteMyCommands) {
        TelegramBot bot = new TelegramBot("BOT_TOKEN");
    }



    bot.setUpdatesListener(updates -> {
        // Обрабатываем входящие сообщения
        // возвращаем id последнего обработанного сообщения или отмечаем все как обработанные
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    });

    SendMessage message = new SendMessage(chatId, messageText);

    SendResponse response = bot.execute(message);
    Pattern pattern = Pattern.compile("[a-zA-Z]");

    Matcher matcher = pattern.matcher(string);
if (matcher.matches()) {
        String date = matcher.group(1);
        String item = matcher.group(3);
    }
}
