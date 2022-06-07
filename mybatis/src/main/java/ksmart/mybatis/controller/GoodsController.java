package ksmart.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ksmart.mybatis.dto.goods;
import ksmart.mybatis.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);

	
	/////Di//////
	private final GoodsService goodsService;
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	/////상품목록출력//////
	@GetMapping("/goodsList")
	public String getGoodsList(Model model) {
		
	List<goods> goodsList = goodsService.getGoodsList();
	log.info("상품목록   :   {}", goodsList);
	model.addAttribute("goodsList", goodsList);
	
		
	return "goods/goodsList";
	}
	//////상품등록//////
	@PostMapping("/addGoods")
	public String addGoodsList(goods goods
								,@RequestParam(name="goodsCode")String goodsCode) {
		log.info("입력받은 데이터값   :   {}", goods);
		log.info("입력받은 주문목록????    :   {}", goodsCode);
		goodsService.addGoods(goods);
		return "redirect:/goods/goodsList";
	}
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		return "goods/addGoods";
	}
	@PostMapping("/removeGoods")
	public String removeGoods(@RequestParam(name="goodsCode", required = false)String goodsCode) {
		
		return "redirect:/goods/goodsList";
	}
	
}
