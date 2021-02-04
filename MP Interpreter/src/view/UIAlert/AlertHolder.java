package view.UIAlert;

import java.util.ArrayList;
import java.util.HashMap;

public class AlertHolder {

    private static AlertHolder sharedInstance = null;

    private final static String TAG = "NotificationCenter";

    private HashMap<String, ArrayList<IAlert>> notificationMap;
    private AlertHolder() {
        this.notificationMap = new HashMap<String, ArrayList<IAlert>>();
    }

    public void addObserver(String notificationString, IAlert listener) {

        //if there is already an existing key, put listener to array list
        if(this.notificationMap.containsKey(notificationString)) {
            ArrayList<IAlert> listenerList = this.notificationMap.get(notificationString);
            listenerList.add(listener);
        }
        //create new arraylist
        else {
            ArrayList<IAlert> listenerList = new ArrayList<IAlert>();
            listenerList.add(listener);
            this.notificationMap.put(notificationString, listenerList);
        }
    }

    public void removeObserver(String notificationString, IAlert listener) {
        if(this.notificationMap.containsKey(notificationString)) {
            ArrayList<IAlert> listenerList = this.notificationMap.get(notificationString);
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
        ArrayList<IAlert> listenerList = this.notificationMap.get(notificationString);

        if(listenerList != null) {
            for(IAlert listener : listenerList) {
                listener.notified(notificationString, parameters);
            }
        }
    }

    public void postNotification(String notificationString) {
        ArrayList<IAlert> listenerList = this.notificationMap.get(notificationString);

        if(listenerList != null) {
            for(IAlert listener : listenerList) {
                listener.notified(notificationString, null);
            }
        }
    }

    public static AlertHolder getInstance() {
        if(sharedInstance == null) {
            sharedInstance = new AlertHolder();
        }

        return sharedInstance;
    }
}
