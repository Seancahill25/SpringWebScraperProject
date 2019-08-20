package com.sean.stockscraper.dao;

import java.util.List;

import com.sean.stockscraper.entity.Stock;

public interface StockDAO {
	
	public List<Stock> getStocks();
}
