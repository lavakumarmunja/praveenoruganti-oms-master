package com.praveen.oms.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.oms.item.model.Item;
import com.praveen.oms.item.repository.ItemRepository;
import com.praveen.oms.item.request.ItemRequest;


@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Item> getItems() {
		return itemRepository.findAll();
	}
	
	@Override
	public Item getByItemname(String itemname) {
		return itemRepository.findByItemname(itemname);
	}

	@Override
	public Item createItem(ItemRequest itemRequest) {
		return itemRepository.saveAndFlush(Item.builder().itemname(itemRequest.getItemname()).description(itemRequest.getDescription())
				.price(itemRequest.getPrice()).creationdate(itemRequest.getCreationdate()).build());
	}
}
