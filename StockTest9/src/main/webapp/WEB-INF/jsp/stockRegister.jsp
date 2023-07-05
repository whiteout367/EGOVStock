<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

<title>Stock Register</title>
</head>
<body>
<br/>
    <h1 class="text-center">Board Write</h1>
<br/>
<br/>
<div class="container">
        <form id="form_test" action="insertStock.do" method="post"
            encType="multiplart/form-data">
            <table class="table table-bordered">
                <tbody>
                	<tr>
                        <th>종류</th>
                        <td><input type="text" placeholder="제품 종류를 입력하세요."
                            name="kind" class="form-control" required/></td>
                    </tr>
                	
                	<tr>
                        <th>코드</th>
                        <td><input type="text" placeholder="상품 코드를 입력하세요."
                            name="code" class="form-control" required/></td>
                    </tr>
                	
                	<tr>
                        <th>바코드</th>
                        <td><input type="text" placeholder="바코드 번호를 입력하세요."
                            name="barcode" class="form-control" /></td>
                    </tr>
                    
                	<tr>
                        <th>상품 이름</th>
                        <td><input type="text" placeholder="상품 이름"
                            name="partname" class="form-control" required/></td>
                    </tr>
                    
                    <tr>
                        <th>용량</th>
                        <td><input type="text" placeholder="용량을 입력하세요"
                            name="std" class="form-control" /></td>
                    </tr>
                    
                    <tr>
                        <th>박스당 갯수</th>
                        <td><input type="text" placeholder="박스 당 낱개를 입력하세요"
                            name="qtybox" class="form-control" /></td>
                    </tr>
                    
                    <tr>
                        <th>박스</th>
                        <td><input type="text" placeholder="박스 갯수를 입력하세요"
                            name="box" class="form-control" /></td>
                    </tr>
                    
                    <tr>
                        <th>낱개</th>
                        <td><input type="text" placeholder="낱개를 입력하세요"
                            name="stock" class="form-control" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button id="btn_register" type="button" class="btn_register">등록</button>
                            <button id="btn_previous" type="button" class="btn_previous">이전</button>
                    </tr>
 
                </tbody>
            </table>
        </form>
    </div>
</body>
<script type="text/javascript">
    //글쓰기
    $(document).on('click', '#btn_register', function(e) {
        $("#form_test").submit();
    });
 	
    //이전 클릭 시 testList로 이동
    $("#btn_previous").click(function previous() {
        $(location).attr('href', 'stockList.do');
 
    });
</script>
</html>