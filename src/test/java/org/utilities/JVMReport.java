package org.utilities;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
public class JVMReport {
	
	
	
	public void generateReport(String jsonPath) {
		
		
		File loc=new File(System.getProperty("user.dir")+"\\target\\Reports\\JVMReport");
		
		
		Configuration config=new Configuration(loc, "FaceBook");
		config.addClassifications("Platform", "Windows 11");
		config.addClassifications("Broswer", "Google Chrome");
		config.addClassifications("Version", "107");
		config.addClassifications("Finctionality", "Login");
		
		
		
		
		List<String> l=new LinkedList<String>();
		l.add(jsonPath);
		
		
		
		
		ReportBuilder R=new ReportBuilder(l, config);
		R.generateReports();
	}
}
