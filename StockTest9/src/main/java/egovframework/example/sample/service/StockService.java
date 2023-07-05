package egovframework.example.sample.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;
import egovframework.example.sample.vo.TotalCountVO;
import egovframework.example.sample.vo.UpdateVO;

public interface StockService {
	 //검색 리스트
	 public List<StockVO> selectStock(SearchVO searchVo) throws Exception;
	 
	 //상세페이지
	 public StockVO selectDetail(int code) throws Exception;
	 
	 //게시물 총 갯수
	 public int getBoardListCnt(SearchVO searchVo) throws Exception;
	 
	 //업데이트
	 public void updateStock(StockVO stockVo) throws Exception;
	 
	 //삭제
	 public void deleteStock(int code) throws Exception;
	 
	 //글 작성
	 public void insertStock(StockVO stockVo) throws Exception;
	 
	 //엑셀 다운로드
	 void excelDown(StockVO stockVO, HttpServletResponse response) throws Exception;
}

