package com.praveen.oms.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.oms.item.model.Item;
import com.praveen.oms.item.repository.ItemRepository;
import com.praveen.oms.item.request.ItemRequest;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Item> getItems() {
		log.info("ItemServiceImpl getItems() Starts");
		List<Item> itemList= itemRepository.findAll();
		log.info("Item List size is "+ itemList.size());
		log.info("ItemServiceImpl getItems() Ends");
		return itemList;
	}
	
	@Override
	public Item getByItemname(String itemname) {
		log.info("ItemServiceImpl getByItemname() Starts");
		log.info("Item name in getByItemname() is "+itemname);
		Item item= itemRepository.findByItemname(itemname);
		log.info("Item Response in getByItemname() is "+ item);
		log.info("ItemServiceImpl getByItemname() Ends");
		return item;
	}

	@Override
	public Item createItem(ItemRequest itemRequest) {
		log.info("ItemServiceImpl createItem() Starts");
		log.info("Item Request in createItem()  is "+itemRequest);
		Item item= itemRepository.saveAndFlush(Item.builder().itemname(itemRequest.getItemname()).description(itemRequest.getDescription())
				.price(itemRequest.getPrice()).creationdate(itemRequest.getCreationdate()).build());
		log.info("Item Response in createItem()  is "+item);
		log.info("ItemServiceImpl createItem() Ends");		
		return item;
	}
}
