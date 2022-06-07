package ksmart.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.mybatis.dto.goods;

@Mapper
public interface GoodsMapper {
	////상품목록조회/////
	public List<goods> getgoodsList();
	
	////상품등록/////
	public int addGoods(goods goods);
}
