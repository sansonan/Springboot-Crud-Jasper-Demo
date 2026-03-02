package springboot_crud_jasper.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class NotificationLogPK implements Serializable {

    private Integer userId;
    private String fcmMessageId;

    public NotificationLogPK() {}

    public NotificationLogPK(Integer userId, String fcmMessageId) {
        this.userId = userId;
        this.fcmMessageId = fcmMessageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationLogPK)) return false;
        NotificationLogPK that = (NotificationLogPK) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(fcmMessageId, that.fcmMessageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, fcmMessageId);
    }
}