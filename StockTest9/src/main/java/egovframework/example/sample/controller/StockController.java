package egovframework.example.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.sample.service.StockService;
import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;

@Controller
public class StockController {
    @Autowired
    private StockService stockService;
    
    @RequestMapping(value="/stockList.do")
    public String testListDo(Model model
    		,@RequestParam(required=false,defaultValue="testTitle")String searchType
            ,@RequestParam(required=false)String keyword
            ,@ModelAttribute("search")SearchVO searchVo)throws Exception{
      
    	
    	model.addAttribute("search", searchVo);
    	searchVo.setSearchType(searchType);
    	searchVo.setKeyword(keyword);
        
        model.addAttribute("list", stockService.selectStock(searchVo));


        
        
        return "stockList";
    }

}