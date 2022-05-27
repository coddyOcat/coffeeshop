package org.way;

public abstract class NotifierDecorator implements NotifierService {
    protected final NotifierService _notifier;

    public NotifierDecorator(NotifierService notifier) {
        this._notifier = notifier;
    }
}
