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

import egovframework.example.sample.service.StockMapper;
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
    
    //글 상세페이지
    @RequestMapping(value="stockDetail.do")
    public String viewForm(Model model, HttpServletRequest request) throws Exception{
        int code = Integer.parseInt(request.getParameter("code"));
        
        StockVO testVo = stockService.selectDetail(code);
        model.addAttribute("vo", testVo);
        
        return "stockDetail";
    }
    
    @RequestMapping(value = "/excelDown.do")

    @ResponseBody

    public void excelDown(@ModelAttribute StockVO stockVO, HttpServletResponse response
                                                        , HttpServletRequest request) throws Exception{

       stockService.excelDown(stockVO, response);

    }
    
    @RequestMapping(value="/updateStock.do")
    public String updateStock(@ModelAttribute("stock")StockVO stockVo) throws Exception {
    	
    	System.out.println(stockVo.getCode());
    	stockService.updateStock(stockVo);
       	
    	return "redirect:stockDetail.do?code="+stockVo.getCode();
    	
    }
    
  //글삭제
    @RequestMapping(value="/deleteStock.do")
    public String deleteStock(HttpServletRequest request) throws Exception {
        int testId = Integer.parseInt(request.getParameter("code"));
        System.out.println(testId);
        stockService.deleteStock(testId);
        return "redirect:stockList.do";
    }
    
    //글작성페이지
    @RequestMapping(value="/stockRegister.do")
    public String testRegister(){
        return "stockRegister";
    }
    
    //글쓰기
    @RequestMapping(value="/insertStock.do")
    public String write(@ModelAttribute("insert") StockVO stockVo) throws Exception {
        stockService.insertStock(stockVo);
        return "redirect:stockList.do";
    }
    
}