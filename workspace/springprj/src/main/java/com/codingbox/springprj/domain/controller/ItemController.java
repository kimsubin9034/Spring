package com.codingbox.springprj.domain.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.springprj.domain.Item;
import com.codingbox.springprj.dto.ItemForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	
	//url : /items/new
	// createForm() 
	// return : items/createItemForm
	
	private final ItemService itemService;
	
	@GetMapping("/items/new")
	public String createForm(Model model) {
		model.addAttribute("form", new ItemForm());
		return "items/createItemForm";
	}
	
	
	// 저장 
	// url : /items/new
	// create()
	// 성공 시 : redirect : / 로 (홈화면)
	@PostMapping("/items/new")
	public String create(ItemForm form) {
		Item item = new Item();
		item.setName(form.getName());
		item.setPrice(form.getPrice());
		item.setStockQuantity(form.getStockQuantity());
		
		itemService.saveItem(item);
		return "redirect:/";
	}
	// url : items
	// list()
	// return items/itemList
	@GetMapping("/items")
	public String list(Model model) {
		List<Item> items = itemService.findItems();
		model.addAttribute("items", items);
		return "items/itemList";
	}
	
}
