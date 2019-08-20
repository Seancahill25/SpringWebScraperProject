package com.sean.stockscraper.scraper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sean.stockscraper.db.DbConnection;
import com.sean.stockscraper.entity.Stock;

public class SeleniumScraper {
	
	public List<Stock> Scrape(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1366,768");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://login.yahoo.com");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("seanscrap25");
        username.submit();
        
        WebElement element = (new WebDriverWait(driver, 5))
        		   .until(ExpectedConditions.elementToBeClickable(By.id("login-passwd")));
                
        WebElement password = driver.findElement(By.id("login-passwd"));
        password.sendKeys("Potatosalad33");
        password.sendKeys(Keys.ENTER);
        
        driver.get("https://finance.yahoo.com/portfolio/p_1/view/v1");
        
        WebElement element1 = (new WebDriverWait(driver, 15))
     		   .until(ExpectedConditions.elementToBeClickable(By.tagName("main")));
                
        WebElement table = driver.findElement(By.tagName("tbody"));
        
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        int i = 1;
        
        for(WebElement row: table.findElements(By.tagName("tr"))) {
        	
        	Stock tempStock = new Stock(){
        		
        	};
        		
        		tempStock.setSymbol(driver.findElement(By.xpath("//*[@id=\"pf-detail-table\"]/div[1]/table/tbody/tr[" + i  + "]/td[1]/a")).getAttribute("innerText"));
     			tempStock.setLastPrice(driver.findElement(By.xpath("//*[@id=\"pf-detail-table\"]/div[1]/table/tbody/tr[" + i  + "]/td[2]/span")).getAttribute("innerText"));
     			tempStock.setChanges(driver.findElement(By.xpath("//*[@id=\"pf-detail-table\"]/div[1]/table/tbody/tr[" + i  + "]/td[3]/span")).getAttribute("textContent"));
     			tempStock.setChangePercent(driver.findElement(By.xpath("//*[@id=\"pf-detail-table\"]/div[1]/table/tbody/tr[" + i  + "]/td[4]/span")).getAttribute("innerText"));
     			tempStock.setMarketTime(driver.findElement(By.xpath("//*[@id=\"pf-detail-table\"]/div[1]/table/tbody/tr[" + i  + "]/td[6]/span")).getAttribute("innerText"));
     			tempStock.setVolume(driver.findElement(By.xpath("//*[@id=\"pf-detail-table\"]/div[1]/table/tbody/tr[" + i  + "]/td[7]/span")).getAttribute("innerText"));
     			tempStock.setMarketCap(driver.findElement(By.xpath("//*[@id=\"pf-detail-table\"]/div[1]/table/tbody/tr[" + i  + "]/td[13]/span")).getAttribute("innerText"));
        	
			
		   

		    System.out.println(tempStock.getChanges());

			stocks.add(tempStock);
			i++;  
        }
        driver.quit();
            	
        DbConnection db = new DbConnection();
    	Connection conn = db.getConnection();
    	
    	String sql = "insert into stocks (symbol, last_price, changes, change_percent, market_time, volume, market_cap) values(?,?,?,?,?,?,?)";
    	
    	try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(Stock stock : stocks) {
		        ps.setString(1, stock.getSymbol());
		        ps.setString(2, stock.getLastPrice());
		        ps.setString(3, stock.getChanges());
		        ps.setString(4, stock.getChangePercent());
		        ps.setString(5, stock.getMarketTime());
		        ps.setString(6, stock.getVolume());
		        ps.setString(7, stock.getMarketCap());
		        ps.execute();
		        }
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
        return stocks;    
	}
}
