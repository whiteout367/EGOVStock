package egovframework.example.sample.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;

public interface StockService {
	//검색 리스트
	 public List<StockVO> selectStock(SearchVO searchVo) throws Exception;
	 
	 //엑셀 다운로드
	 void excelDown(StockVO stockVO, HttpServletResponse response) throws Exception;
}

