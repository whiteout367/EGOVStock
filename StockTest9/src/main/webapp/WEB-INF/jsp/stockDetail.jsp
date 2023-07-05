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

<title>Stock Detail</title>
</head>
<body>
<br />
    <h1 class="text-center">Stock Detail</h1>
    <br />
    <br />
    <div class="container">
        <form action="updateStock.do" id="viewForm" method="post"
            encType="multiplart/form-data">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <th>코드 번호</th>
                        <td><input name="code" type="text" value="${vo.code}"
                            class="form-control" readonly /></td>
                    </tr>
                    <tr>
                        <th>박스</th>
                        <td><input type="text" value="${vo.box}"
                            name="box" class="form-control" /></td>
                    </tr>
                    <tr>
                        <th>수량</th>
                        <td><textarea name="stock" class="form-control"
                                style="height: 200px;">${vo.stock}</textarea></td>
 
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: right;">
                            <button id="btn_previous" type="button" class="btn_previous">이전</button>
                            <button id="btn_modify" type="button" class="btn_register">수정</button>
                            <button id="btn_delete" type="button" class="btn_delete">삭제</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
<script type="text/javascript">
    $(document).on('click', '#btn_modify', function(e) {
        if (confirm("정말 수정하시겠습니까 ?") == true) {
            $("#viewForm").submit();
        } else {
            return;
        }
    });
    $(document).on('click', '#btn_delete', function(e) {
        
        var code = ${vo.code};
        
        if (confirm("정말 삭제하시겠습니까 ?") == true) {
            $("#viewForm").attr("action", "deleteStock.do?code="+code);
            $("#viewForm").submit();
        } else {
            return;
        }
    });
 
    //이전 클릭 시 testList로 이동
    $("#btn_previous").click(function previous() {
        $(location).attr('href', 'stockList.do');
 
    });
</script>
</html>