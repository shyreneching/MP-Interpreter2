package model.notifications;

public interface NotificationListener {
    public abstract void notified(String notificationString, Parameters params);
}
