package com.ijunfu.pdf.web.controller;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author ijunfu
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final DataSource dataSource;

    @GetMapping("/student/html")
    public void studentReport() throws IOException, JRException, SQLException {

        ClassPathResource resource = new ClassPathResource("report/student.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource.getConnection());

        JasperExportManager.exportReportToHtmlFile(jasperPrint, "report.html");

    }

}
