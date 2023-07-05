package egovframework.example.sample.dao;

import java.util.List;

import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;
import egovframework.example.sample.vo.TotalCountVO;
import egovframework.example.sample.vo.UpdateVO;

public interface StockDAO {
	  public List<StockVO> selectStock(SearchVO searchVo) throws Exception;
	  
	  public int getBoardListCnt(SearchVO searchVo) throws Exception;
	  
	  public void updateStock(UpdateVO updateVo) throws Exception;

	  
	  public List<StockVO> selectStockList(StockVO stockVo) throws Exception;
}
