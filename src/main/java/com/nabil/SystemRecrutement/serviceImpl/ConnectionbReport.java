package com.nabil.SystemRecrutement.serviceImpl;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ConnectionbReport {
	@Value("${spring.datasource.url}")
	private String ConnDatasource;

	@Value("${spring.datasource.username}")
	private String UserName;
	@Value("${spring.datasource.password}")
	private String Password;
	

	@Autowired  ServletContext context;

	@Autowired
	DataSource datasource;
	public Connection BdReport() {
		Connection conn = null;

		try {
			//Class.forName(DiverBD);

			// conn =
			// DriverManager.getConnection("jdbc:oracle:thin:@//127.0.0.1:1521/local",
			// "fid", "arab");
			// conn =
			// DriverManager.getConnection("jdbc:oracle:thin:@//192.168.2.234:1521/local",
			// "fid", "arab");
			conn = DriverManager.getConnection(ConnDatasource, UserName, Password);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	/*Methode Generate PDF File*/
		public byte[] GeneratePDF(String param1, String param2)
			
			throws JRException, IOException {
			
			
			//String path = "D:\\pdf\\report";
			String path ="c:/pdf";
			
			//String path =".//PDF";
			try {
			
			File file = ResourceUtils.getFile("classpath:"+ param1 + ".jrxml");
			
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			Map parameters = new HashMap();
			parameters.put("cin",Long.parseLong(param2));
			
			//parameters.put("Logo",context.getRealPath("/")+"/images/articles/angular.png");
			// get Connection
			Connection conn = BdReport();
			System.out.println(jasperReport);
			System.out.println(parameters);
			System.out.println(jasperReport);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			// create file jasper
			System.out.println(jasperReport);

			param1 = param1+param2;
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\" + param1+ ".pdf");
			// return Files.readAllBytes(Paths.get(path + "\\" + ReportName + ".pdf"));
			return Files.readAllBytes(Paths.get(path + "\\" +param1+ ".pdf"));
		} catch (Exception ex) {
			return null;
		}
	}
		
		
		public byte[] GeneratePDFF(String param1)
		
				throws JRException, IOException {
				 
				//String path = "D:\\pdf\\report";
				String path ="c:/pdf";
				//String path =".//PDF";
				try {
				File file = ResourceUtils.getFile( "classpath:"  + param1 +  ".jrxml");
				JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
				Map parameters = new HashMap();
				// get Connection
				Connection conn = BdReport();
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
				// create file jasper
				param1 = param1+System.currentTimeMillis();
				JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\" + param1+ ".pdf");
				// return Files.readAllBytes(Paths.get(path + "\\" + ReportName + ".pdf"));
				return Files.readAllBytes(Paths.get(path + "\\" +param1+ ".pdf"));
			} catch (Exception ex) {
				return null;
			}
		}
	
}
