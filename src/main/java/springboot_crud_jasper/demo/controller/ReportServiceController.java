package springboot_crud_jasper.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_crud_jasper.demo.service.ReportService;

@RestController
@RequiredArgsConstructor
public class ReportServiceController {

    private final ReportService reportService;

    @GetMapping("/report")
    public ResponseEntity<byte[]> generateReport() throws Exception {

        byte[] pdf = reportService.exportNotificationsReport();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=notifications.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
