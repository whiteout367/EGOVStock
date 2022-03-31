package egovframework.example.sample.service;

import java.util.List;

import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;

public interface StockService {
	 public List<StockVO> selectStock(SearchVO searchVo) throws Exception;
}

