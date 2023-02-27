<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">랭킹 게시판</h1>
	<p class="mb-4">
		코드로 배우는 스프링 웹 프로젝트(개정판)를 책을 보고 똑같이 만들고 있어요<br> <a target="_blank"
			href="https://startbootstrap.com/previews/sb-admin-2">우리가 사용한 템플릿</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<h2>
			<b class="twinkle" style="color: #7cfc00"> 🎈🎈</b> 
			<b class="twinkle" style="color: #0000ff">게시글</b> 
			<b class="twinkle" style="color: #ffd700">목록</b> 
			<span style="text-shadow: 1px 1px 1px #000;">보기</span>~~
		</h2>
	</div>
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">게시글 목록 보기</h6>
		<a href="/board/register" class="w-btn w-btn-blue"
			style="float: right;"> 글쓰기 </a>
	</div>

	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>가장 최근 글 제목</th>
					</tr>
				</thead>
				<tfoot>
					<tr>

					</tr>
				</tfoot>
				<tbody>
					<c:set var="no" value="0" />
					<!-- 페이지 영역에 변수 선언 -->
					<c:forEach items="${list }" var="board">
						<tr>
							<td class="twinkle" style="color: #0000ff">💡 ${board.title }</td>
							<!-- 글 삭제시에 진짜 글 번호가 필요하다 -->

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
<script>
	var bno = "${bno}";
	var modifybno = "${modifybno}";
	var removebno = "${removebno}";
	console.log("작성한 글번호 확인1", bno);
	console.log("수정한 글번호 확인1", modifybno);
	if (bno) {
		alert(bno + " 번 글이 등록되었습니다.");
	}
	if (modifybno) {
		alert(modifybno + " 번 글이 수정되었습니다.");
	}
	if (removebno) {
		if (removebno == -1) {
			alert("패스워드가 다릅니다")
		} else {
			alert(removebno + " 번 글이 삭제되었습니다.");
		}
	}
</script>
