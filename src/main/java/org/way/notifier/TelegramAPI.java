package org.way.notifier;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public interface TelegramAPI {
    static void run(String message) {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        //Add Telegram token (given Token is fake)
        String apiToken = "5142598036:AAEiWJFrqpQegRbM2wnFINqh9Nkg6zF3eIo";

        //Add chatId (given chatId is fake)
        String chatId = "@ForTesingAPI";
        String text = URLEncoder.encode(message, StandardCharsets.UTF_8);

        urlString = String.format(urlString, apiToken, chatId, text);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
