package com.techie.microservice.order.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

//@Slf4j
@FeignClient(value = "inventory", url="http://localhost:8082")
public interface InventoryClient {

    Logger log = LoggerFactory.getLogger(InventoryClient.class);

    //@GetExchange("/api/inventory")
    //@CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    //@Retry(name = "inventory")
    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

   /* default boolean fallbackMethod(String code, Integer quantity, Throwable throwable) {
        log.info("Cannot get inventory for skucode {}, failure reason: {}", code, throwable.getMessage());
        return false;
    }*/
}