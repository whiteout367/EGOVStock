package egovframework.example.sample.dao;

import java.util.List;

import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;

public interface StockDAO {
	  public List<StockVO> selectStock(SearchVO searchVo) throws Exception;

	 
}
