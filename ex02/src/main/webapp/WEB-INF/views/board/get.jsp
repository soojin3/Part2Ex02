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
				<a href="/board/list" class="w-btn-neon2"> 목록으로 돌아가기 </a>

			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>