package com.praveen.oms.item.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.oms.item.model.Item;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long>{
	public Item findByItemname(String itemname);
}
