package org.way.notifier;

import org.way.NotifierDecorator;
import org.way.NotifierService;

public class Telegram extends NotifierDecorator implements TelegramAPI {
    public Telegram(NotifierService notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        _notifier.send(message);
        System.out.println("\nTelegram send message");
        TelegramAPI.run(message);
    }
}
