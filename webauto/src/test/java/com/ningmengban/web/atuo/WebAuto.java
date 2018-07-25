package com.ningmengban.web.atuo;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.mustache.Value;


public class WebAuto {
	@Test
	@Parameters(value={"registerPage","browserType","dirverPath","test"})
	public void test1(String registerPage,String browserType,String dirverPath,String test){
		WebDriver driver =  null;
		if("chrome".equalsIgnoreCase(browserType)){
			System.setProperty("webdriver.chrome.driver", dirverPath);
			driver = new ChromeDriver();
		}else if ("firefox".equalsIgnoreCase(browserType)){
			driver = new FirefoxDriver();
		}else if ("ie".equalsIgnoreCase(browserType)){
			System.setProperty("webdriver.ie.driver", dirverPath);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			driver = new InternetExplorerDriver(capabilities);
		}
	//访问百度
		driver.get(registerPage);
	//获取元素
		driver.findElement(By.id(test)).sendKeys("柠檬班");
		}
}
