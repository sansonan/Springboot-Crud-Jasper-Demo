package springboot_crud_jasper.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot_crud_jasper.demo.entity.NotificationLog;
import springboot_crud_jasper.demo.service.NotificationLogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationLogController {

    private final NotificationLogService service;

    @GetMapping
    public List<NotificationLog> getAll() {
        return service.findAll();
    }

    @PostMapping
    public NotificationLog create(@RequestBody NotificationLog log) {
        return service.save(log);
    }

    @PutMapping
    public NotificationLog update(@RequestBody NotificationLog log) {
        return service.update(log);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> delete(@RequestParam Integer userId,
                                                      @RequestParam String fcmMessageId) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Notification deleted successfully");
        service.delete(userId, fcmMessageId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/{fcmMessageId}")
    public NotificationLog getOne(@PathVariable Integer userId,
                                  @PathVariable String fcmMessageId) {
        return service.findOne(userId, fcmMessageId);
    }
}