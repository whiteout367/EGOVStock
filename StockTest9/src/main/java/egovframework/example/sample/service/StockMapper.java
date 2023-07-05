package egovframework.example.sample.service;

import java.util.List;

import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;
import egovframework.example.sample.vo.TotalCountVO;
import egovframework.example.sample.vo.UpdateVO;

public interface StockMapper {
	List<StockVO> selectStock(SearchVO searchVo) throws Exception;
	
	public int getBoardListCnt(SearchVO searchVo) throws Exception;
	
    public void updateStock(UpdateVO updateVo) throws Exception;

	List<StockVO> selectStockList(StockVO stockVo) throws Exception;
}
