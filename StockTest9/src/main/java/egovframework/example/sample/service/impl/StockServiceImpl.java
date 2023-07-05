package egovframework.example.sample.service.impl;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.sample.dao.StockDAO;
import egovframework.example.sample.service.StockService;
import egovframework.example.sample.vo.SearchVO;
import egovframework.example.sample.vo.StockVO;
import egovframework.example.sample.vo.TotalCountVO;
import egovframework.example.sample.vo.UpdateVO;

@Service
public class StockServiceImpl implements StockService{
 
    @Autowired
    private StockDAO stockDao;
    
    @Override
    public List<StockVO> selectStock(SearchVO searchVo) throws Exception {
        return stockDao.selectStock(searchVo);
    }
    
    @Override
    public StockVO selectDetail(int code) throws Exception {
        return stockDao.selectDetail(code);
    }
    
    @Override
    public void updateStock(StockVO stockVo) throws Exception {
        stockDao.updateStock(stockVo);
    }
    
    @Override
    public void deleteStock(int code) throws Exception {
        stockDao.deleteStock(code);
    }
    
    @Override
    public void insertStock(StockVO stockVo) throws Exception {
        stockDao.insertStock(stockVo);
    }
    
    @Override
    public int getBoardListCnt(SearchVO searchVo) throws Exception {
        return stockDao.getBoardListCnt(searchVo);
    }
    
    @Override

    public void excelDown(StockVO stockVo, HttpServletResponse response) throws Exception {

  

    List<StockVO> testList = stockDao.selectStockList(stockVo);

  

    try {

       //Excel Down 시작

       Workbook workbook = new HSSFWorkbook();

  

       //시트생성

       Sheet sheet = workbook.createSheet("재고_관리");

  

       //행, 열, 열번호

       Row row = null;

       Cell cell = null;

       int rowNo = 0;

  

       // 테이블 헤더용 스타일

       CellStyle headStyle = workbook.createCellStyle();

       // 가는 경계선을 가집니다.

       headStyle.setBorderTop(BorderStyle.THIN);

       headStyle.setBorderBottom(BorderStyle.THIN);

       headStyle.setBorderLeft(BorderStyle.THIN);

       headStyle.setBorderRight(BorderStyle.THIN);

       // 배경색은 노란색입니다.

       headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());

       headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

       // 데이터용 경계 스타일 테두리만 지정

       CellStyle bodyStyle = workbook.createCellStyle();

       bodyStyle.setBorderTop(BorderStyle.THIN);

       bodyStyle.setBorderBottom(BorderStyle.THIN);

       bodyStyle.setBorderLeft(BorderStyle.THIN);

       bodyStyle.setBorderRight(BorderStyle.THIN);

  

       // 헤더명 설정

       String[] headerArray = {"종류", "코드","바코드","상품이름","용량","박스당 수량","박스수","낱개"};

       row = sheet.createRow(rowNo++);

       for(int i=0; i<headerArray.length; i++) {

       cell = row.createCell(i);

       cell.setCellStyle(headStyle);

       cell.setCellValue(headerArray[i]);

       }

  

       for(StockVO excelData : testList ) {

  

       row = sheet.createRow(rowNo++);

       cell = row.createCell(0);

       cell.setCellStyle(bodyStyle);

       cell.setCellValue(excelData.getKind());

  

       cell = row.createCell(1);

       cell.setCellStyle(bodyStyle);

       cell.setCellValue(excelData.getCode());

       cell = row.createCell(2);

       cell.setCellStyle(bodyStyle);

       cell.setCellValue(excelData.getBarcode());

  

       cell = row.createCell(3);

       cell.setCellStyle(bodyStyle);

       cell.setCellValue(excelData.getPartname());
       
       
       cell = row.createCell(4);

       cell.setCellStyle(bodyStyle);

       cell.setCellValue(excelData.getStd());

  

       cell = row.createCell(5);

       cell.setCellStyle(bodyStyle);

       cell.setCellValue(excelData.getQtybox());

  

       cell = row.createCell(6);

       cell.setCellStyle(bodyStyle);

       cell.setCellValue(excelData.getBox());
       
       
       cell = row.createCell(7);

       cell.setCellStyle(bodyStyle);

       cell.setCellValue(excelData.getStock());

       }

  

       // 컨텐츠 타입과 파일명 지정

       response.setContentType("ms-vnd/excel");

       response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode("***_관리.xls", "UTF8"));

  

       // 엑셀 출력

       workbook.write(response.getOutputStream());

       workbook.close();

       } catch (Exception e) {

       e.printStackTrace();

       }

  

       }
 
}
