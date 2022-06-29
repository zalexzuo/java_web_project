package com.group1project.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group1project.model.bean.Account;
import com.group1project.model.bean.Product;
import com.group1project.model.bean.ProductComment;
import com.group1project.model.service.AccountService;
import com.group1project.model.service.ProductCommentService;
import com.group1project.model.service.ProductService;

//rest風格的CRUD 收到的頁面為http://localhost:8080/jotravel/back/product

@Controller
@RequestMapping("back/productcomment") 
public class ProductCommentController {

	
	@Autowired
	private ProductCommentService pService;
	
	@Autowired
	private ProductService pdService;
	
	@Autowired
	private AccountService accService;
	
	//查詢所有商品評論
	@GetMapping
	@ResponseBody //回傳json格式的資料
	public List<ProductComment> getAllCommnets(Model m) {
		List<ProductComment> list = pService.getAllProductComment(); 
		
		m.addAttribute("list", list);
		
		return list;
	}
	
	
	//查詢單筆商品
	//利用@GetMapping方法查詢商品,給參數就會查到對應產品 ex:http://localhost:8080/jotravel/back/product/1
	@GetMapping("{id}")
	@ResponseBody //回傳json格式的資料
	public ProductComment getProductById(@PathVariable("id") int productCommnetId) {
		return pService.getProductCommentById(productCommnetId);
	}
	
	
	//新增商品
	//@PostMapping方法,為新增商品,輸入json格式資料即可完成新增,利用@ResponseBody回傳json格式的資料
	@PostMapping("addgo")
	public String addProductComment(@ModelAttribute("pdComment") ProductComment productComment,
			@RequestParam(value="accountId", required = false ) Integer accountId,
			@RequestParam(value="productId", required = false ) Integer productId, 
			Model model) {
		
		
//		Object object =service.findById(id);
//		Account aaa = productComment.setAccount(accService.getAccountById(accountId));
//		Product ppp = productComment.setProduct(pdService.getProductById(productId));
		Account member = new Account();
		Product pd = new Product();
		member.setAccountId(accountId);
		pd.setProductId(productId);
		
		productComment.setAccount(member);
		productComment.setProduct(pd);
		
		Date nowDate = new Date();
		productComment.setUpdatedTime(nowDate);
		
		pService.saveProductComment(productComment);
//		HashMap<String, String> message = new HashMap<String, String>();
//		
//		message.put("okMsg", "insertOK");
//		model.addAttribute("msg", message);
		
		return "redirect:/back/allProduct";
	}
	
	//以非rest風格的方式刪除商品
	@RequestMapping(value="delete/{id}" , method = RequestMethod.GET)
	public String deleteProductById(@PathVariable("id") int productCommnetId) {
		pService.deleteProductComment(productCommnetId);
		return "redirect:/back/allProduct";
	}
	
	
	@GetMapping("editProductComment")
	public String editProducteComment(@RequestParam("id") int productCommnetId, Model model) {
		ProductComment newPdComment = pService.getProductCommentById(productCommnetId);

		model.addAttribute("newPdComment", newPdComment);
		
		return "editProductComment";//回到頁面
	}
	

	
	@PostMapping("editProductComment")
    public String postEditMessage(@ModelAttribute(name="newPd") ProductComment newPdComment ,
    		Model model) {
		
		Date nowDate = new Date();
		newPdComment.setUpdatedTime(nowDate);
		
		
		pService.saveProductComment(newPdComment);
		
		return "redirect:/back/allProduct";
		
	}
	
	
}
