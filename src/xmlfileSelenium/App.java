package xmlfileSelenium;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory docBuilderFactory= DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=docBuilderFactory.newDocumentBuilder();
		Document doc = 	docBuilder.parse(new File("book.xml"));
		//gtest
		doc.getDocumentElement().normalize();
		System.out.println("Debug: Root element"+ doc.getDocumentElement().getNodeName());
		NodeList node =doc.getElementsByTagName("TestData");
		System.out.println("TestData Details");
		System.out.println("________________________________________________");
		//Read XML to get test data
		for (int i = 0; i < node.getLength(); i++) {
			Node currentNode = node.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) currentNode;
				NodeList mailServerElemntList = element.getElementsByTagName("service");
				Element mailServer = (Element) mailServerElemntList.item(0);
				NodeList mailServer1 = mailServer.getChildNodes();
				String Service = ((Node)mailServer1.item(0)).getNodeValue();
				System.out.println("Mail Servername:"+ Service);
				
				NodeList emailNodeElementList = element.getElementsByTagName("email-id");
				Element emailNodeElement = (Element)emailNodeElementList.item(0);
				NodeList details = emailNodeElement.getChildNodes();
				String emailAddress=((Node) details.item(0)).getNodeValue();
				System.out.println("email :" + emailAddress);
				
				NodeList passwordNodeElementList = element.getElementsByTagName("password");
				Element passwordNodeElement = (Element) passwordNodeElementList.item(0);
				NodeList address = passwordNodeElement.getChildNodes();
				String passCode = ((Node) address.item(0)).getNodeValue();
				System.out.println("Password : "+passCode);

				NodeList destFolder = element.getElementsByTagName("folder");
				Element destElement = (Element) destFolder.item(0);
				NodeList city = destElement.getChildNodes();
				String destnFolder = ((Node) city.item(0)).getNodeValue();
				System.out.println("Folder : " + destnFolder);
				System.setProperty("webdriver.gecko.driver", "/Users/darya1/Documents/jarFolder/geckodriver");
				WebDriver wd = new FirefoxDriver();
				wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				wd.get("http://www.gmail.com");
				wd.findElement(By.id("Email")).sendKeys(emailAddress);
				wd.findElement(By.id("Passwd")).sendKeys(passCode);
				wd.findElement(By.id("signIn")).click();
				Thread.sleep(8000);
				System.out.println(wd.getTitle());
				System.out.println(wd.getCurrentUrl());
				if (!wd.getCurrentUrl().equals("https://mail.google.com/mail/?shva=1#inbox")) {
				wd.close();
				System.out.println("Failed to navigate to inbox");
				throw new RuntimeException("assertTitle failed");
				}
				System.out.println("Test Completed - login passed and navigated to inbox");
				wd.close(); 


			}
		}

	}

}
