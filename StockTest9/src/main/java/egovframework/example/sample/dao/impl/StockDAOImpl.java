package egovframework.example.sample.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.example.sample.dao.StockDAO;
import egovframework.example.sample.service.StockMapper;
import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;
import egovframework.example.sample.vo.UpdateVO;

@Repository
public class StockDAOImpl implements StockDAO {
 
    @Autowired
    private SqlSession sqlSession;
    
    @Override
    public List<StockVO> selectStock(SearchVO searchVo) throws Exception {
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        return mapper.selectStock(searchVo);
    }
    
    @Override
    public void updateStock(UpdateVO updateVo) throws Exception {
    	StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        mapper.updateStock(updateVo);
    }
 
    
    @Override
    public List<StockVO> selectStockList(StockVO stockVo) throws Exception {
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        return mapper.selectStockList(stockVo);
    }
 
}