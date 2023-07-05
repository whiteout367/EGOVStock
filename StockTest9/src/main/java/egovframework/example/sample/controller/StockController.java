package egovframework.example.sample.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sample.service.StockService;
import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;
import egovframework.example.sample.vo.TotalCountVO;
import egovframework.example.sample.vo.UpdateVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class StockController {
    @Autowired
    private StockService stockService;
    
    @RequestMapping(value="/stockList.do")
    public String testListDo(Map<String,Object> commandMap, Model model
    		,@RequestParam(required=false,defaultValue="code")String searchType
            ,@RequestParam(required=false)String keyword
            ,@RequestParam(required=false,defaultValue="1") int pageNo
            ,@ModelAttribute("search")SearchVO searchVo)throws Exception{
    	
    	try {
    		PaginationInfo paginationInfo = new PaginationInfo();
    		paginationInfo.setCurrentPageNo(pageNo); //현재 페이지 번호
    		paginationInfo.setRecordCountPerPage(10); //한 페이지에 게시되는 게시물 건수
    		paginationInfo.setPageSize(10); //페이징 리스트의 사이즈
    		
    		
    		
    		searchVo.setFirstIndex(paginationInfo.getFirstRecordIndex());
    		searchVo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

    		
    		model.addAttribute("search", searchVo);
    		searchVo.setSearchType(searchType);
        	searchVo.setKeyword(keyword);
        	
    		int listCnt = stockService.getBoardListCnt(searchVo);
    		paginationInfo.setTotalRecordCount(listCnt); //전체 게시물 건 수
    		//페이징 관련 정보가 있는 PaginationInfo 객체를 모델에 반드시 넣어준다.
    		model.addAttribute("paginationInfo", paginationInfo);
    		
        	
            
            model.addAttribute("list", stockService.selectStock(searchVo));
            

            
            
            
    	}
    	catch(Exception e){
    		
    	}
    	
    	return "stockList";
    }
    
    @RequestMapping(value = "/excelDown.do")

    @ResponseBody

    public void excelDown(@ModelAttribute StockVO stockVO, HttpServletResponse response
                                                        , HttpServletRequest request) throws Exception{

       stockService.excelDown(stockVO, response);

    }
    
    @RequestMapping(value="/updateStock.do", method = RequestMethod.GET)
    public void updateStock(HttpServletRequest request) throws Exception {
    	UpdateVO updateVo = new UpdateVO();
    	String barcode = request.getParameter("barcode");
    	String box = request.getParameter("box");
    	String stock = request.getParameter("stock");
    	
    	updateVo.setBarcode(barcode);
    	updateVo.setBox(box);
    	updateVo.setStock(stock);
    	
    	stockService.updateStock(updateVo);
    	
    }



}