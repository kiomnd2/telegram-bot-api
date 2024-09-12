package telegram.telegramremotehandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import telegram.telegramremotehandler.interfaces.handler.TelegramBotHandler;

@SpringBootApplication
public class TelegramRemoteHandlerApplication {

    public static void main(String[] args) throws TelegramApiException {
        ConfigurableApplicationContext context = SpringApplication.run(TelegramRemoteHandlerApplication.class, args);
        TelegramBotsApi bot = new TelegramBotsApi(DefaultBotSession.class);
        TelegramBotHandler handler = context.getBean(TelegramBotHandler.class);
        bot.registerBot(handler);
    }

}
