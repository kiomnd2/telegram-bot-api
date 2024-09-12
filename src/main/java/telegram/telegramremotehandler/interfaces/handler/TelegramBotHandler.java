package telegram.telegramremotehandler.interfaces.handler;

import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBotHandler extends TelegramWebhookBot {

    @Override
    public String getBotToken() {
        return "";
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotPath() {
        return "";
    }

    @Override
    public String getBotUsername() {
        return "";
    }
}
