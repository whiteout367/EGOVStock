package egovframework.example.sample.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.sample.dao.StockDAO;
import egovframework.example.sample.service.StockService;
import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;

@Service
public class StockServiceImpl implements StockService{
 
    @Autowired
    private StockDAO stockDao;
    
    @Override
    public List<StockVO> selectStock(SearchVO searchVo) throws Exception {
        return stockDao.selectStock(searchVo);
    }
 
}
