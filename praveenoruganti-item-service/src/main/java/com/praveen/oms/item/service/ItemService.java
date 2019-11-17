package com.praveen.oms.item.service;

import java.util.List;

import com.praveen.oms.item.model.Item;
import com.praveen.oms.item.request.ItemRequest;


public interface ItemService {
	List<Item> getItems();
	Item createItem(ItemRequest itemRequest);
	Item getByItemname(String itemname);
}
