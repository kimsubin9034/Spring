package com.codingbox.item.domain.web.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.ssl.JksSslBundleProperties.Store;
import org.springframework.stereotype.Repository;

import com.codingbox.item.domain.web.dto.Item;

@Repository
public class ItemRepository {
	private static final Map<Long, Item> store = new HashMap<>();
	private static long sequence = 0L;
	
	
	//저장
	public Item save(Item item) {
		item.setId(++sequence);
		store.put(item.getId(), item);
		return item;
	}
	
	public Item findById(Long id) {
		return store.get(id);
	}
	
	public List<Item> findAll() {
		return new ArrayList<Item>(store.values());
	}
	
	//아이템 수정
	public void update(Long itemId, Item updateParam) {
		//item 먼저 찾기
		Item findItem = findById(itemId);
		findItem.setItemName(updateParam.getItemName());
		findItem.setPrice(updateParam.getPrice());
		findItem.setQuantity(updateParam.getQuantity());
		
	}
	
	//store clear
	public void clearStore() {
		store.clear();
	}
}
