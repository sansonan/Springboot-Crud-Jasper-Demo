package springboot_crud_jasper.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springboot_crud_jasper.demo.entity.NotificationLog;
import springboot_crud_jasper.demo.entity.NotificationLogPK;

public interface NotificationLogRepository
        extends JpaRepository<NotificationLog, NotificationLogPK> {
}