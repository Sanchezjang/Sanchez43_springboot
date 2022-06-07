package ksmart.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.mybatis.dto.goods;
import ksmart.mybatis.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {

	////DI//////



	private final GoodsMapper goodsMapper;
	public GoodsService(GoodsMapper goodsMapper){
		this.goodsMapper = goodsMapper;
	}
	
	
	////상품리스트/////
	  public List<goods> getGoodsList() {
	  
	  List<goods> goodsList = goodsMapper.getgoodsList();
	  
	  return goodsList;
	 
	  }
	////상품등록/////
	  public int addGoods(goods goods) {
		  
		  int result = goodsMapper.addGoods(goods);
		  
		  return result;
	}
	
}
