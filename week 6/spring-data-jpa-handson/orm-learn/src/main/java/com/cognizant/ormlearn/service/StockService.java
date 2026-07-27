package com.cognizant.ormlearn.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

import jakarta.transaction.Transactional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getFacebookStocks(Date startDate, Date endDate) {
        return stockRepository.findByCodeAndDateBetween("FB", startDate, endDate);
    }

    @Transactional
    public List<Stock> getGoogleStocks(double price) {
        return stockRepository.findByCodeAndCloseGreaterThan("GOOG", BigDecimal.valueOf(1250));
    }

    @Transactional
    public List<Stock> getTop3VolumeStocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional
    public List<Stock> getLowest3NetflixStocks() {
        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
    }
}