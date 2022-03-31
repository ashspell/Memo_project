<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
</head>
<body>
	<div id="wrap">
		<c:import url = "/WEB-INF/jsp/include/header.jsp" />
			<section class = "d-flex justify-content-center">
		<div class = "w-75 my-5">
			<h1 class = "text-center">메모 보기</h1>
			
			<div class = "d-flex">
				<label>제목 : </label>
				<input type ="text" class = "form-control col-11 mt-3" id = "titleInput" value = "${post.subject }">	
			</div>
			<textarea class = "form-control mt-3" rows ="5" id = "contentInput">${post.content}</textarea>
			
			<c:if test = "${not empty post.imagePath }">
			<img src= "${post.imagePath }">
			</c:if>
			
			<div class ="d-flex justify-content-between">
				<div>
					<a href = "/post/list_view" class = "btn btn-info mt-3">목록으로</a>
					<button type = "button" class = "btn btn-danger" id  = "deleteBtn" data-post-id = "${post.id }">삭제</button>
				</div>
				<button type = "button" class = "btn btn-success mt-3" id = "saveBtn"  data-post-id = "${post.id }">수정</button>
			
			</div>
		</div>
			
		
		</section>
	
	
	
		<c:import url = "/WEB-INF/jsp/include/footer.jsp" />
	</div>
</body>

<script>
	$(document).ready(function(){
		
		$("#saveBtn").on("click", function(){
			let title = $("#titleInput").val();
			let content = $("#contentInput").val();
			
			let postId = $(this).data("post-id");
			
			$.ajax({
				type:"post",
				url:"/post/update",
				data:{"postId":postId, "subject":subject, "content":content},
				success:function(data) {
					
					if(data.result == "success") {
						alert("수정 성공");
					}else{
						alert("수정 실패");
					}
				},
				error:function() {
					alert("수정 에러");
				}
			
				
				
			});
		});
		
		$("deleteBtn").on("click", function(){
			let postId = $(this).data("post-id");
			
			$.ajax({
				type: "get",
				url:"/post/delete",
				data:{"postId":postId}
				success:function(data) {
					if(data.result == "success") {
						location.href = "/post/list_view";
					}else{
						alert("삭제 실패");
					}
				},
				error:function() {
					alert("삭제 에러");
				}
				
				
			});
			
			
		});
		
		
	});
	


</script>
</html>