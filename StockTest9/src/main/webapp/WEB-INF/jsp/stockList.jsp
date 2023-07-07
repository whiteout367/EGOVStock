<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board List</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
<style type="text/css">
a{
 text-decoration: auto;
}
#btn_group{
	margin-top: 20px
}
.w100{
	margin:auto; 
    text-align:center;
}

.w100 input{
  height: 30px;
  width: 500px;
   
  
}
#keyword{
	margin: auto;
}
#btnSearch{
  width: 500px;
  height: 36px;
  margin: auto;
}

#insert{
	margin:auto; 
    text-align:center;
    margin-top: 30px;
    
    
}

#insert_btn{
	height: 40px;
  	width: 500px;
  	
  	margin: auto;
}
</style>
</head>
<body>

 <br/>
    <h1 class="text-center">Stock List</h1>
    <div class="form-group row">
 
            <div class="w100" style="padding-right: 10px">
                <select class="form-control form-control-sm" name="searchType" id="searchType" style = "width: 500px; margin: auto;">
                    <option value="code">코드</option>
                    <option value="barcode">바코드</option>
                    <option value="partname">제품이름</option>
                </select>
                
                <input type="text" class="form-control form-control-sm" name="keyword" id="keyword">
                <div id = "btn_group">
                	<button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">검색</button>
                	<form action="/excelDown.do" method="post" style = "margin-top: 20px">
   						<input type="submit" value='엑셀 다운로드'>
					</form>
					
                </div>
                
            </div>
 			
        </div>
        
    <br/>
    <br/>
    <div class="container">
        <table class="table table-hover table-striped text-center" style="border:1px solid;">
				<colgroup>
					<col width="20" />
					<col width="10%" />
					<col width="10%" />
					<col width="20%" />
					<col width="10%" />
					<col width="10%" />
					<col width="10%" />
					<col width="10%" />
				</colgroup>
				<tbody>
				<thead>

					<tr>
						<th>분류항복</th>
						<th>코드</th>
						<th>바코드</th>
						<th>제품이름</th>
						<th>용량</th>
						<th>박스당 갯수</th>
						<th>박스 수</th>
						<th>낱개</th>
					</tr>
				</thead>

<!-- jstl 데이터베이스를 검색해 넘겨 받은 list 를 result 라는 이름으로 순차적으로 실행을 시키게 됨  java의 for문같이 순차적으로 실행시킴-->
			 
          <c:forEach items="${list }" var="result">
					<tr>
						<td><c:out value="${result.kind}" /></td>
						<td><a href="stockDetail.do?code=${result.code}"><c:out value="${result.code}" /></a></td>
						<td><c:out value="${result.barcode}" /></td>
						<td><c:out value="${result.partname}" /></td>
						<td><c:out value="${result.std}" /></td>
						<td><c:out value="${result.qtybox}" /></td>
						<td><c:out value="${result.box}" /></td>
						<td><c:out value="${result.stock}" /></td>
					</tr>
				</c:forEach>
	
				</tbody>
			</table>
        <hr/>
	        



    </div>
    <br>
    <div class="pagination justify-content-center">
    	<ul><ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage"/></ul>
	</div>
	<div id = "insert">
		<a class="btn btn-outline-info" id = "insert_btn" href="stockRegister.do">제품 추가하기</a>
	</div>
</body>
<script type="text/javascript">
        
    // 검색
    $(document).on('click', '#btnSearch', function(e){
        e.preventDefault();
        var url = "/stockList.do";
        url += "?searchType=" + $('#searchType').val();
        url += "&keyword=" + $('#keyword').val();
        location.href = url;
        
 
    });    
 
    </script>
    <script type="text/javascript">
	function linkPage(pageNo){
		location.href = "/stockList.do?pageNo="+pageNo;
	}	
</script>
</html>