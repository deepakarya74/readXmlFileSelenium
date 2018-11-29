package xmlfileSelenium;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("TestData Details");
		System.out.println("________________________________________________");
		//Read XML to get test data
		String service=XmlReadData.readXmlFile("TestData","service");
		System.out.println(service);
		
		String emailid=XmlReadData.readXmlFile("TestData","email-id");
		System.out.println(emailid);
		
		
		String password=XmlReadData.readXmlFile("TestData","password");
		System.out.println(password);
		
		String folder=XmlReadData.readXmlFile("TestData","folder");
		System.out.println(folder);
		
		
		
		

	}

}
