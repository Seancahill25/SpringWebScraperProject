package com.sean.stockscraper.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sean.stockscraper.entity.Stock;

@Repository
public class StockDAOImpl implements StockDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Stock> getStocks() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Stock> theQuery =
				currentSession.createQuery("from Stock", Stock.class);
		
		List<Stock> stocks = theQuery.getResultList();
		
		return stocks;
	}

}
