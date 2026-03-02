package springboot_crud_jasper.demo.service.impl;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import springboot_crud_jasper.demo.entity.NotificationLog;
import springboot_crud_jasper.demo.repository.NotificationLogRepository;
import springboot_crud_jasper.demo.service.ReportService;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final NotificationLogRepository repository;

    @Override
    public byte[] exportNotificationsReport() throws Exception {

        List<NotificationLog> data = repository.findAll();

        InputStream reportStream =
                getClass().getResourceAsStream("/reports/notifications.jrxml");

        JasperReport jasperReport =
                JasperCompileManager.compileReport(reportStream);

        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(data);

        InputStream logoStream =
                getClass().getResourceAsStream("/reports/logo.png");

        if (logoStream == null) {
            throw new RuntimeException("Logo not found!");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("logo", logoStream);
        params.put("generatedDate", "Generated: " + LocalDateTime.now());

        JasperPrint jasperPrint =
                JasperFillManager.fillReport(jasperReport,
                        params,
                        dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}