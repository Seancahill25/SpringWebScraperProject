package com.sean.stockscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.stockscraper.dao.StockDAO;
import com.sean.stockscraper.entity.Stock;
import com.sean.stockscraper.scraper.SeleniumScraper;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockDAO stockDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Stock> theStocks = stockDAO.getStocks();
		
		theModel.addAttribute("stocks", theStocks);
		
		return "list-stocks";
	}
	
	@RequestMapping("/scrape")
	public String scrapeData() {
		
		SeleniumScraper scraper = new SeleniumScraper();
		scraper.Scrape();
		
		return "scrape-results";
	}
}