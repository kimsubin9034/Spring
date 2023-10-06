package com.codingbox.item.domain.web.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.ssl.JksSslBundleProperties.Store;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingbox.item.domain.web.dto.Item;

@Repository
public class ItemRepository {
	private static final Map<Long, Item> store = new HashMap<>();
	private static long sequence = 0L;

	// 저장
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

	public void update(Long itemId, Item updatParam) {
		// item 먼저 찾는다
		Item findItem = findById(itemId);
		findItem.setItemName(updatParam.getItemName());
		findItem.setPrice(updatParam.getPrice());
		findItem.setQuantity(updatParam.getQuantity());
	
		findItem.setOpen(updatParam.getOpen());
		findItem.setRegions(updatParam.getRegions());
		findItem.setItemType(updatParam.getItemType());
		findItem.setDeliveryCode(updatParam.getDeliveryCode());
		
	}


	// store clear
	public void clearStore() {
		store.clear();
	}
}
