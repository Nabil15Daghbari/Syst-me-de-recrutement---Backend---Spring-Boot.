package com.nabil.SystemRecrutement.controller;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.nabil.SystemRecrutement.controller.api.ContratsApi;
import com.nabil.SystemRecrutement.dto.contratsDto;
import com.nabil.SystemRecrutement.service.ContratsService;
import com.nabil.SystemRecrutement.serviceImpl.ConnectionbReport;

import net.sf.jasperreports.engine.JRException;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class ContratsController implements ContratsApi {
	
	private ContratsService contratsService ;
	
	@Autowired
	ConnectionbReport connectionBdReport;
	@Autowired
	public ContratsController (ContratsService contratsService  ) {
		this.contratsService=contratsService ;
	}

	@Override
	public contratsDto save(contratsDto dto) {
		return contratsService.save(dto);
	}

	@Override
	public contratsDto findById(Long id) {
		return contratsService.findById(id);
	}

	@Override
	public List<contratsDto> findAll() {
		return contratsService.findAll();
	}
  
	@Override
	public void delete(Long id) {
		contratsService.delete(id);
		
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value=APP_ROOT + "/report/{ReportName}/{cin}" )
	@Override
	public byte[] getReportfile(String ReportName, String cin) throws JRException, IOException {
		byte[] getReportFile;
		
		try {
			/*Call Method Generate PDF */
			getReportFile = connectionBdReport.GeneratePDF(ReportName, cin);
			System.out.println(getReportFile);


		} catch (Exception ex) {
			return null;
		}
		return getReportFile;
	}
	

	
	

//	@CrossOrigin
//	@GetMapping(path = "/report/{ReportName}/{cin}")
//	public byte[] getReportfile(@PathVariable String ReportName, @PathVariable String cin)
//			throws JRException, IOException {
//		byte[] getReportFile;
//
//		try {
//			/*Call Method Generate PDF */
//			getReportFile = connectionBdReport.GeneratePDF(ReportName, cin);
//			System.out.println(getReportFile);
//
//
//		} catch (Exception ex) {
//			return null;
//		}
//		return getReportFile;
//	}




	

}
