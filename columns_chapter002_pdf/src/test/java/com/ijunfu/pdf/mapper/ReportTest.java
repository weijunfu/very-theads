package com.ijunfu.pdf.mapper;

import com.ijunfu.pdf.PdfApplication;
import jakarta.annotation.Resource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ijunfu
 * @version 1.0.0
 *
 */
@SpringBootTest(classes = PdfApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportTest {


    @Resource
    private DataSource dataSource;

    @Resource
    private StudentMapper studentMapper;

    @Test
    void test() throws IOException, JRException, SQLException {

        ClassPathResource resource = new ClassPathResource("report/student.jrxml");
        assertNotNull(resource);

//        System.out.println(resource.getInputStream().available());
//        System.out.println(resource.getURL());

        /*BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String line = "";
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();*/
        JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource.getConnection());

        byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);

        FileOutputStream outputStream = new FileOutputStream("report.pdf");
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        System.out.println("Done!");
    }

    @Test
    void testDatabase() throws IOException, JRException, SQLException {

        ClassPathResource resource = new ClassPathResource("report/student.jrxml");
        assertNotNull(resource);

        JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource.getConnection());

        byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);

        FileOutputStream outputStream = new FileOutputStream("report1.pdf");
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        System.out.println("Done!");
    }

    @Test
    void testParam() throws Exception {
        ClassPathResource resource = new ClassPathResource("report/student_params.jrxml");
        assertNotNull(resource);

        JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());

        HashMap<String, Object> params = new HashMap<>();
        params.put("P_NAME", "张三");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

        byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);

        FileOutputStream outputStream = new FileOutputStream("report-params.pdf");
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        System.out.println("Done!");
    }
}
