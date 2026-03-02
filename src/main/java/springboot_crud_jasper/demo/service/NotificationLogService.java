package springboot_crud_jasper.demo.service;

import springboot_crud_jasper.demo.entity.NotificationLog;

import java.util.List;

public interface NotificationLogService {
    NotificationLog save(NotificationLog log);
    List<NotificationLog> findAll();
    NotificationLog findOne(Integer userId, String fcmMessageId);
    NotificationLog update(NotificationLog log);
    void delete(Integer userId, String fcmMessageId);
}
