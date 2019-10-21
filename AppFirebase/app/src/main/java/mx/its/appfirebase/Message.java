package mx.its.appfirebase;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ServerValue;

import java.util.Map;

@IgnoreExtraProperties
public class Message {
    private String userUid;
    private String email;
    private String message;
    private long creationDate;

    public Message(){}

    public Message(String userUid, String email, String message) {
        this.userUid = userUid;
        this.email = email;
        this.message = message;

    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getCreationDate() {
        return ServerValue.TIMESTAMP;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    @Exclude
    public Long getCreationDateLong() {
        return creationDate;
    }
}
