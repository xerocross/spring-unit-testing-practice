package com.adamfgcross.unittesting.controller;

import com.adamfgcross.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adamfgcross.unittesting.business.ItemBusinessService;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item fromBusinessService() {
        return businessService.retrieveHardcodedItem();
    }
}
