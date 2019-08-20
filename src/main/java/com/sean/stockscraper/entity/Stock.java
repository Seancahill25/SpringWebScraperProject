package com.sean.stockscraper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stocks")
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="last_price")
	private String lastPrice;
	
	@Column(name="changes")
	private String changes;
	
	@Column(name="change_percent")
	private String changePercent;
	
	@Column(name="market_time")
	private String marketTime;
	
	@Column(name="volume")
	private String volume;
	
	@Column(name="market_cap")
	private String marketCap;
	
	public Stock() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getChanges() {
		return changes;
	}

	public void setChanges(String changes) {
		this.changes = changes;
	}

	public String getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(String changePercent) {
		this.changePercent = changePercent;
	}

	public String getMarketTime() {
		return marketTime;
	}

	public void setMarketTime(String marketTime) {
		this.marketTime = marketTime;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}
}
