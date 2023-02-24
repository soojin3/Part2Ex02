<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">스프링 게시판</h1>
	<p class="mb-4">
		코드로 배우는 스프링 웹 프로젝트(개정판)를 책을 보고 똑같이 만들고 있어요<br> <a target="_blank"
			href="https://startbootstrap.com/previews/sb-admin-2">우리가 사용한 템플릿</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">게시글 상세보기</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="exampleInputEmail"  name="title" value="${board.title }" readonly>
					</div>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="exampleInputEmail"  name="writer" value="${board.writer }" readonly>
					</div>
					<div class="form-group">
						<textarea rows="10" class="form-control form-control-user"
							id="exampleInputEmail" name="content" " readonly>${board.content }</textarea>
					</div>
				<form action="/board/remove" method="post" id="delForm">
				<a href="/board/list" class="w-btn w-btn-blue"> 목록으로 돌아가기 </a>
				<a href="/board/modify?bno=${board.bno }" class="w-btn w-btn-blue"> 수정 </a>
                            		<input type="hidden" name="bno" value="${board.bno}">
                            		<input type="hidden" name="delKey" id="delKey">
                            		<input class="w-btn w-btn-pink"   type="button" value=" 삭제하기 " id="delButton">
                            	</form>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
<script>
/* 
 * 확인창을 이용한 확인 처리
 $(document).ready(function(){ 
	$("#delButton").on("click",function(e){
		//1. 버튼 이벤트(submit) 금지
		e.preventDefault();
		//2. 확인창 띄어서 확인받기
		var isConfirm= confirm("정말 삭제하시겠습니까?")
		//3. 확인되었으면 submit처리
		if(isConfirm){//true라면 이라는 뜻
			$("#delForm").submit()
		}
	})
	
}); */
/* $(document).ready(function(){ 
	$("#delButton").on("click",function(e){
		//1. 버튼 이벤트(submit) 금지
		e.preventDefault();
		//2. 입력창으로 값을 받고
		var delKey=prompt("삭제를 위한 키값을 입력해 주세요")
		//3. 그 내용도 같이 보내준다
		if(delKey==1111){
			$("#delForm").submit()
		}else{
			alert("키값이 틀렸습니다.")
		}
	})
}); */
$(document).ready(function(){ 
	$("#delButton").on("click",function(e){
		//1. 버튼 이벤트(submit) 금지
		e.preventDefault();
		//2. 입력창으로 값을 받고
		var delKey=prompt("삭제를 위한 키값을 입력해 주세요")
		//3. 그 내용도 같이 보내준다
		if(delKey){
		$("#delKey").val(delKey);
		$("#delForm").submit();
		//delKey 값을 보내면 처리
		}
	})
});
</script>