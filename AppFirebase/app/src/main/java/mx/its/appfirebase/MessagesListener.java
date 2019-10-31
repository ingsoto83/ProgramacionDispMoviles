package mx.its.appfirebase;

public interface MessagesListener {
    public abstract void onMessageLongClick(String key);
    public abstract void onMessageClick(Message message, String key);
}
