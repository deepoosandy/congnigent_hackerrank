package com.hackerrank.stocktrades.controller;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

@RestController
public class StockTradeRestController {
  @Autowired
  public StockTradeRepository stockTradeRepository;

  public static int id=0;

  @PostMapping("/trades")
  public ResponseEntity<StockTrade> createStock(@RequestBody StockTrade stockTrade){
      id++;
    stockTrade.setId(id);
    stockTrade=stockTradeRepository.save(stockTrade);
    return new ResponseEntity<>(stockTrade, HttpStatus.CREATED);
  }
  @GetMapping("/trades")
  public ResponseEntity<List<StockTrade>> listStock(){

    List<StockTrade>list=stockTradeRepository.findAll();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }
  @GetMapping("/trades/{id}")
  public ResponseEntity<StockTrade> findByIdStock(@PathVariable("id") int id){
    StockTrade oneStockist=null;
   try{
      oneStockist=stockTradeRepository.findById(id).get();
   }catch (Exception e){

   }


    if(oneStockist==null){
      return new ResponseEntity<>(oneStockist, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(oneStockist, HttpStatus.OK);
  }

  @PatchMapping("/trades/{id}")
  public ResponseEntity<StockTrade> patch(@PathVariable("id") int id){


    return new ResponseEntity<>( HttpStatus.METHOD_NOT_ALLOWED);
  }

  @PutMapping("/trades/{id}")
  public ResponseEntity<StockTrade> delete(@PathVariable("id") int id){

    return new ResponseEntity<>( HttpStatus.METHOD_NOT_ALLOWED);
  }

  @DeleteMapping("/trades/{id}")
  public ResponseEntity<StockTrade> put(@PathVariable("id") int id){
    return new ResponseEntity<>( HttpStatus.METHOD_NOT_ALLOWED);
  }




}
