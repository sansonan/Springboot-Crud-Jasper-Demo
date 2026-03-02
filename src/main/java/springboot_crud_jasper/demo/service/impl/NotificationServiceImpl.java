package springboot_crud_jasper.demo.service.impl;


import springboot_crud_jasper.demo.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot_crud_jasper.demo.entity.NotificationLog;
import springboot_crud_jasper.demo.entity.NotificationLogPK;
import springboot_crud_jasper.demo.repository.NotificationLogRepository;
import springboot_crud_jasper.demo.service.NotificationLogService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationLogService {
    private final NotificationLogRepository repository;

    @Override
    public NotificationLog save(NotificationLog log) {

        NotificationLogPK pk = new NotificationLogPK(
                log.getUserId(),
                log.getFcmMessageId()
        );

        if (repository.existsById(pk)) {
            throw new RuntimeException("Notification already exists");
        }

        return repository.save(log);
    }

    @Override
    public List<NotificationLog> findAll() {
        return repository.findAll();
    }

    @Override
    public NotificationLog findOne(Integer userId, String fcmMessageId) {
        NotificationLogPK pk = new NotificationLogPK(userId, fcmMessageId);
        return repository.findById(pk)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "NotificationLog",
                                "userId + fcmMessageId",
                                userId + " / " + fcmMessageId
                        )
                );
    }

    @Override
    public NotificationLog update(NotificationLog log) {
        NotificationLogPK pk = new NotificationLogPK(
                log.getUserId(),
                log.getFcmMessageId()
        );

        NotificationLog existing = repository.findById(pk)
                .orElseThrow(() ->
       new ResourceNotFoundException(
                "NotificationLog",
                "userId + fcmMessageId",
               log.getUserId() + " / " + log.getFcmMessageId())
        );

        existing.setTitle(log.getTitle());
        existing.setBody(log.getBody());
        existing.setStatus(log.getStatus());

        return repository.save(existing);
    }

    @Override
    public void delete(Integer userId, String fcmMessageId) {
        NotificationLogPK pk = new NotificationLogPK(userId, fcmMessageId);

        if (!repository.existsById(pk)) {
            throw new ResourceNotFoundException(
                    "NotificationLog",
                    "userId + fcmMessageId",
                    userId + " / " + fcmMessageId
            );
        }

        repository.deleteById(pk);
    }
}
