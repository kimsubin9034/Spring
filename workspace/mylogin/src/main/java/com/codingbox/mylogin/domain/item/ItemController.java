package com.codingbox.mylogin.domain.item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor

public class ItemController {

	private final ItemRepository itemRepository;


	@ModelAttribute("regions")
	public Map<String, String> regions() {
		// 기존 HashMap : 순서가 보장되지 않는다
		// LinkedHashMap : 순서보장
		Map<String, String> regions = new LinkedHashMap<>();
		regions.put("SEOUL", "서울");
		regions.put("BUSAN", "부산");
		regions.put("JEJU", "제주");
//		model.addAttribute("regions", regions);

		return regions;
	}

	@ModelAttribute("itemTypes")
	public ItemType[] itemTypes() {
		return ItemType.values();
	}

	@ModelAttribute("deliveryCodes")
	public List<DeliveryCode> deliveryCodes() {
		List<DeliveryCode> deliveryCodes = new ArrayList<>();
		deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
		deliveryCodes.add(new DeliveryCode("NORMAL", "일반 배송"));
		deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));
		return deliveryCodes;
	}


	@GetMapping
	public String items(Model model) {
		//로그인 체크여부
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "/items/items";
	}

	@GetMapping("/{itemId}")
	public String item(@PathVariable long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "/items/item";
	}

	@GetMapping("/add")
	public String addForm(Model model) {
		//로그인 체크여부
		model.addAttribute("item", new Item());
		return "/items/addForm";
	}


	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable Long itemId, Model model) {
		// 조회
		// model에 담아서
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "items/editForm";
	}

	/*
	 * update 후에는 상세페이지로 이동
	 */
	@PostMapping("/{itemId}/edit")
	public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
		//로그인 체크여부
		System.out.println("item: " + item.getOpen());

		itemRepository.update(itemId, item);
		return "redirect:/items/{itemId}";
	}
	

	
	@PostMapping("/add")
	public String saveItemV9(Item item, BindingResult bindingResult, 
	        RedirectAttributes redirectAttributes) {

	    if (!StringUtils.hasText(item.getItemName())) {
	        bindingResult.addError(
	            new FieldError("item", "itemName", item.getItemName(),false, new String[]{"required.item.itemName","required.default"} , null, null));
	    }
	    if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
	        bindingResult.addError(new FieldError("item", "price",item.getPrice(),false,new String[]{"range.item.price"},new Object[] {1000,1000000},null));
	    }
	    
	    if (item.getQuantity() == null || item.getQuantity() > 9999) {
	        bindingResult.addError(new FieldError("item", "quantity",item.getQuantity(),false,new String[]{"max.item.quantity"},new Object[] {9999}, null));
	    }
	    
	    if (bindingResult.hasErrors()) {
	        System.out.println("error: " + bindingResult);
	        return "items/addForm";
	    }
	    Item savedItem = itemRepository.save(item);
	    redirectAttributes.addAttribute("status", true);
	    return "redirect:/items/" + savedItem.getId(); // 수정: item.getId() 대신 savedItem.getId() 사용
	}
	
	
	// 테스트 데이터 추가
	@PostConstruct
	public void init() {
		// System.out.println("초기화메서드실행");
		itemRepository.save(new Item("testA", 100000, 10));
		itemRepository.save(new Item("testB", 200000, 20));
	}

}
