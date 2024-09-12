package telegram.telegramremotehandler.interfaces.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TelegramBotHandler extends TelegramLongPollingBot {

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if (update.hasMessage() && update.getMessage().hasText()) {
            String receivedText = update.getMessage().getText();
            String chatId = String.valueOf(update.getMessage().getChatId());
            System.out.println(receivedText);
            System.out.println(chatId);
            if ("/myChatId".equals(receivedText)) {
                resMessage(chatId, "chatId: " + chatId);
            }
        }
    }

    private void resMessage(String chatId, String text) {
        SendMessage responseMessage = new SendMessage();
        responseMessage.setChatId(chatId);
        responseMessage.setText(text);
        try {
            execute(responseMessage);
        } catch (Exception e) {
            e.printStackTrace(); // 전송 중 예외 발생 시 예외를 출력
        }
    }
}
