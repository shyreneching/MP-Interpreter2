package model.notifications;

import java.util.ArrayList;
import java.util.HashMap;

public class NotificationsCenter {

    private static NotificationsCenter sharedInstance = null;

    private final static String TAG = "NotificationCenter";

    private HashMap<String, ArrayList<NotificationListener>> notificationMap;
    private NotificationsCenter() {
        this.notificationMap = new HashMap<String, ArrayList<NotificationListener>>();
    }

    public void addObserver(String notificationString, NotificationListener listener) {

        //if there is already an existing key, put listener to array list
        if(this.notificationMap.containsKey(notificationString)) {
            ArrayList<NotificationListener> listenerList = this.notificationMap.get(notificationString);
            listenerList.add(listener);
        }
        //create new arraylist
        else {
            ArrayList<NotificationListener> listenerList = new ArrayList<NotificationListener>();
            listenerList.add(listener);
            this.notificationMap.put(notificationString, listenerList);
        }
    }

    public void removeObserver(String notificationString, NotificationListener listener) {
        if(this.notificationMap.containsKey(notificationString)) {
            ArrayList<NotificationListener> listenerList = this.notificationMap.get(notificationString);
            if(listenerList.remove(listener)) {
                System.out.println(TAG + ": " + "Removed observer " +listener);
            }
            else {
                System.out.println(TAG + ": " + "Listener not found. Doing nothing");
            }
        }
    }

    public void clearObservers() {
        this.notificationMap.clear();
    }

    public void postNotification(String notificationString, Parameters parameters) {
        ArrayList<NotificationListener> listenerList = this.notificationMap.get(notificationString);

        if(listenerList != null) {
            for(NotificationListener listener : listenerList) {
                listener.notified(notificationString, parameters);
            }
        }
    }

    public void postNotification(String notificationString) {
        ArrayList<NotificationListener> listenerList = this.notificationMap.get(notificationString);

        if(listenerList != null) {
            for(NotificationListener listener : listenerList) {
                listener.notified(notificationString, null);
            }
        }
    }

    public static NotificationsCenter getInstance() {
        if(sharedInstance == null) {
            sharedInstance = new NotificationsCenter();
        }

        return sharedInstance;
    }
}
