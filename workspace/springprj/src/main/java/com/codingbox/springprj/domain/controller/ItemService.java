package com.codingbox.springprj.domain.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.springprj.domain.Item;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
	
	
	private final ItemRepository itemRepository;
//	public List<Item> findItems() {
//		return ItemRepository.findAll();
//	}
	
	//saveItem(), void
	@Transactional
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	
	//return type arrayList
	// findItems()
	public List<Item> findItems() {
		return itemRepository.findAll();
	}
}
