package org.way;

public class Notifier implements NotifierService {

    private static final Notifier instance = new Notifier();

    public Notifier() {
    }

    public static Notifier getInstance() {
        return Notifier.instance;
    }

    @Override
    public void send(String message) {

    }
}
