package com.abc.hybriddriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hybrid {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		FileInputStream fis=new FileInputStream("G:\\selenium\\HybridDriven\\src\\com\\abc\\utilities\\hybrid.properties");
		Properties p=new Properties();
		p.load(fis);		
		
		String myaccount =p.getProperty("myacct");
		String email=p.getProperty("emailloc");
		String pass=p.getProperty("passloc");
		String login=p.getProperty("loginloc");
		String logout=p.getProperty("logoutloc");
		String urldata=p.getProperty("url");
		String emaildata=p.getProperty("email");
		String passdata=p.getProperty("pass");
		
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(urldata);
		
		driver.findElement(By.xpath(myaccount)).click();
		driver.findElement(By.xpath(email)).sendKeys(emaildata);
		driver.findElement(By.xpath(pass)).sendKeys(passdata);
		driver.findElement(By.xpath(login)).click();
		driver.findElement(By.xpath(logout)).click();
		Thread.sleep(3000);
		driver.close();

	}

}
