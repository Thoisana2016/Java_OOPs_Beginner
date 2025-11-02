package com.thoisana.curdpractice.controller;

import com.thoisana.curdpractice.model.Trade;
import com.thoisana.curdpractice.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trades")
public class Tradecontroller {
    @Autowired
    private TradeService tradeService;

    //POST
    @PostMapping
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade){
        Trade createdTrade = tradeService.createTrade(trade);
        return new ResponseEntity<>(createdTrade, HttpStatus.CREATED);
    }

    //Get trades
    public ResponseEntity<List<Trade>> getAllTrades(@RequestParam(required = false) String type, @RequestParam(required = false) Integer userId){
        List<Trade> trades = tradeService.getAllTrades(type, userId);
        return new ResponseEntity<>(trades, HttpStatus.OK);
    }


    //Get /trade/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable int id){
        Trade trade = tradeService.getTradeById(id);
        if (trade == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trade, HttpStatus.OK);
    }


    //delete, put, patch
    public ResponseEntity<Void> notAllowed(){
        return  new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }


}
