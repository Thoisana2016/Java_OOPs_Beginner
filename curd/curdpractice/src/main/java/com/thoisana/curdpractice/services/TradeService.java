package com.thoisana.curdpractice.services;

import com.thoisana.curdpractice.model.Trade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeService {
    private List<Trade> trades = new ArrayList<>();
    private int nextId = 1;

    //Add a new trade
    public Trade createTrade(Trade trade){
        trade.setId(nextId++);
        trades.add(trade);
        return trade;
    }

    //Get all trades with filter options
    public List<Trade> getAllTrades(String type, Integer userId){
        return trades.stream()
                .filter(trade -> (type == null || trade.getType().equals(type)) &&
                        (userId == null || trade.getUserId() == userId))
                .sorted(Comparator.comparingInt(Trade::getId))
                .collect(Collectors.toList());
    }

    //Get a specific trade by id
    public Trade getTradeById(int id){
        return trades.stream()
                .filter(trade -> trade.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
