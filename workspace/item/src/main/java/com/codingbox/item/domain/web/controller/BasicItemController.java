package com.codingbox.item.domain.web.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingbox.item.domain.web.dto.DeliveryCode;
import com.codingbox.item.domain.web.dto.Item;
import com.codingbox.item.domain.web.dto.ItemType;
import com.codingbox.item.domain.web.repository.ItemRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
// @RequiredArgsConstructor  
// : final 이 붙은 멤버변수만 사용해서 생성자를 자동으로 만들어준다.
public class BasicItemController {

	private final ItemRepository itemRepository;

	/*
	 * @ModelAttribute : Controller 를 호출할때(어떤 메서드가 호출되던지 간에) model 에 자동으로 해당 내용이
	 * 담기도록 보장된다.
	 */
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
		// enum에 있는 값을 배열로 넘겨준다
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

	// @Autowired (생성자가 하나일경우 autowired 생략가능함)
	// @Autowired 로 의존관계 주입해준다.
//	public BasicItemController(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}
//	이 부분을 LOMBOK 라이브러리 @RequiredArgsConstructor 로 대체가능함

	@GetMapping
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "/basic/items";
	}

	// 종료 메서드
	@PreDestroy
	public void destory() {
		// System.out.println("종료메서드호출");
	}

	@GetMapping("/{itemId}")
	public String item(@PathVariable long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "/basic/item";
	}

	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("item", new Item());
		return "/basic/addForm";
	}

//	@PostMapping("/add")
	public String saveItemV1(Model model, @RequestParam String itemName, @RequestParam int price,
			@RequestParam Integer quantity) {
		Item item = new Item();
		item.setItemName(itemName);
		item.setPrice(price);
		item.setQuantity(quantity);

		itemRepository.save(item);

		model.addAttribute("item", item);
		return "basic/item";
	}

//	@PostMapping("/add")
	public String saveItemV2(Model model, @ModelAttribute("item") Item item) {
		// @ModelAttribute 가 해주는 역할
//		Item item = new Item();
//		item.setItemName(itemName);
//		item.setPrice(price);
//		item.setQuantity(quantity);

		itemRepository.save(item);

		model.addAttribute("item", item);
		return "basic/item";
	}

	/*
	 * @ModelAttrubute name 생략가능 즉 , model.addAAttribute("item" , item); 생략가능 생략시
	 * model에 저장되는 name은 클래스명 첫 글자만 소문자로 등록 Item -> item
	 * 
	 * @ModelAttribute("hello") Item item -> model.addAttribute("hello" , item);
	 */
//	@PostMapping("/add")
	public String saveItemV3(@ModelAttribute("item") Item item) {
		itemRepository.save(item);
		return "basic/item";
	}

	/*
	 * @ModelAttribute 자체생략가능 권장하지는 않음
	 */
//	@PostMapping("/add")
	public String saveItemV4(Item item) {
		itemRepository.save(item);
		return "basic/item";
	}

	// 상품등록시 새로고침 안되게끔하기
	// @PostMapping("/add")
	public String saveItemV5(Item item) {
		itemRepository.save(item);
		return "redirect:/basic/items/" + item.getId();
	}

	// 화면에 메시지출력 저장성공메시지 , 주소창 status=true
	//@PostMapping("/add")
	public String saveItemV6(Item item, RedirectAttributes redirectAttributes) {

		System.out.println("Item.open: " + item.getOpen());
		System.out.println("Item.regions: " + item.getRegions());
		System.out.println("Item.itemType: " + item.getItemType());

		Item savedItem = itemRepository.save(item);
	//  redirectAttributes.addAttribute("itemId", savedItem);
		redirectAttributes.addAttribute("status", true);
		return "redirect:/basic/items/" + item.getId();
	}

	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable Long itemId, Model model) {
		// 조회
		// model에 담아서
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "basic/editForm";
	}

	/*
	 * update 후에는 상세페이지로 이동
	 */
	@PostMapping("/{itemId}/edit")
	public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
		System.out.println("item: " + item.getOpen());

		itemRepository.update(itemId, item);
		return "redirect:/basic/items/{itemId}";
	}
	
	
	/*
	 * BindingResult : Item객체에 값이 잘 담기지 않을 떄
	 * BindingResult : 객체에 값이 담기게 된다.
	 * StringUtils : 값이 있을경우에는 true를 반환, 공백이나 NULL이 들어올 경우에는 
	 * false를 반환하게 된다.
	 */
	//@PostMapping("/add")
	public String saveItemV7(Item item, BindingResult bindingResult, 
	        RedirectAttributes redirectAttributes) {

	    if (!StringUtils.hasText(item.getItemName())) {
	        bindingResult.addError(
	            new FieldError("item", "itemName", "상품 이름은 필수입니다"));
	    }
	    if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
	        bindingResult.addError(new FieldError("item", "price", "가격은 1,000~1,000,000 까지 허용"));
	    }

	    if (item.getQuantity() == null || item.getQuantity() > 9999) {
	        bindingResult.addError(new FieldError("item", "quantity", "수량은 최대 9,999까지 허용됩니다"));
	    }
	    
	    // 검증 실패시 다시 입력폼
	    if (bindingResult.hasErrors()) {
	        System.out.println("error: " + bindingResult);
	        return "basic/addForm";
	    }
	    Item savedItem = itemRepository.save(item);
	    redirectAttributes.addAttribute("status", true);
	    return "redirect:/basic/items/" + savedItem.getId(); // 수정: item.getId() 대신 savedItem.getId() 사용
	}

	
	//@PostMapping("/add")
	public String saveItemV8(Item item, BindingResult bindingResult, 
	        RedirectAttributes redirectAttributes) {

	    if (!StringUtils.hasText(item.getItemName())) {
	        bindingResult.addError(
	            new FieldError("item", "itemName", item.getItemName(),false,null,null, "상품 이름은 필수입니다"));
	    }
	    if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
	        bindingResult.addError(new FieldError("item", "price",item.getPrice(),true,null,null, "가격은 1,000~1,000,000 까지 허용"));
	    }

	    if (item.getQuantity() == null || item.getQuantity() > 9999) {
	        bindingResult.addError(new FieldError("item", "quantity",item.getQuantity(),false,null,null, "수량은 최대 9,999까지 허용됩니다"));
	    }
	    
	    if (bindingResult.hasErrors()) {
	        System.out.println("error: " + bindingResult);
	        return "basic/addForm";
	    }
	    Item savedItem = itemRepository.save(item);
	    redirectAttributes.addAttribute("status", true);
	    return "redirect:/basic/items/" + savedItem.getId(); // 수정: item.getId() 대신 savedItem.getId() 사용
	}
	
	@PostMapping("/add")
	public String saveItemV9(Item item, BindingResult bindingResult, 
	        RedirectAttributes redirectAttributes) {

	    if (!StringUtils.hasText(item.getItemName())) {
	        bindingResult.addError(
	            new FieldError("item", "itemName", item.getItemName(),false, new String[]{"required.item.itemName"} , null, null));
	    }
	    if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
	        bindingResult.addError(new FieldError("item", "price",item.getPrice(),true,new String[]{"range.item.price"},new Integer[]{10,1000},null));
	    }

	    if (item.getQuantity() == null || item.getQuantity() > 9999) {
	        bindingResult.addError(new FieldError("item", "quantity",item.getQuantity(),false,new String[]{"max.item.quantity"},new Integer[]{9999}, null));
	    }
	    
	    if (bindingResult.hasErrors()) {
	        System.out.println("error: " + bindingResult);
	        return "basic/addForm";
	    }
	    Item savedItem = itemRepository.save(item);
	    redirectAttributes.addAttribute("status", true);
	    return "redirect:/basic/items/" + savedItem.getId(); // 수정: item.getId() 대신 savedItem.getId() 사용
	}
	
	
	// 테스트 데이터 추가
	@PostConstruct
	public void init() {
		// System.out.println("초기화메서드실행");
		itemRepository.save(new Item("testA", 100000, 10));
		itemRepository.save(new Item("testB", 200000, 20));
	}

}
