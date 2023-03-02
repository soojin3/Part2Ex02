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
			<h6 class="m-0 font-weight-bold text-primary">게시글 목록 보기</h6>
			<a href="/board/register" class="w-btn w-btn-blue"
				style="float: right;"> 글쓰기 </a>
				글 보기 개수 선택
		<select id="amount">
            <option <c:if test="${pageDTO.cri.amount==5}"> selected </c:if> value="5">5</option>
            <option <c:if test="${pageDTO.cri.amount==10}"> selected </c:if> value="10">10</option>
            <option <c:if test="${pageDTO.cri.amount==20}"> selected </c:if> value="20">20</option>
            <option <c:if test="${pageDTO.cri.amount==30}"> selected </c:if> value="30">30</option>
        </select>
        
		</div>

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th><input type="checkbox" name="no" value="selectall"
								onclick="selectAll(this)" />순번</th>
							<th>글 번호</th>
							<th>글 제목</th>
							<th>조회수</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
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
								<td><input type="checkbox" name="12" value="b">
									${no=no+1 }</td>
								<td>${board.bno }</td>
								<!-- 글 삭제시에 진짜 글 번호가 필요하다 -->
								<td><a href="/board/get?bno=${board.bno }&pageNum=${pageDTO.cri.pageNum}&amount=${pageDTO.cri.amount }">
								<c:out value="${board.title }"></c:out></a></td>
								<td>${board.visit }</td>

								<c:if test="${board.regdate==board.updatedate }">
									<td>${board.writer }</td>
								</c:if>

								<c:if test="${board.regdate!=board.updatedate }">
									<td>${board.writer }🔨수정🎈
								</c:if>
								<td><fmt:formatDate pattern="YY년 MM월 dd일 a HH시 mm분"
										value="${board.regdate }" /></td>
								<c:if test="${board.regdate==board.updatedate }">
									<td><fmt:formatDate pattern="YY년 MM월 dd일 a HH시 mm분"
											value="${board.regdate }" /></td>
								</c:if>
								<c:if test="${board.regdate!=board.updatedate }">
									<td style="color: red"><fmt:formatDate
											pattern="YY년 MM월 dd일 a HH시 mm분" value="${board.updatedate }" /></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		<nav aria-label="...">
  <ul class="pagination">
    <li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1">Previous 수정중</a>
    </li>
    
    <c:forEach begin="${pageDTO.startPage }" end="${pageDTO.endPage }" var="num">
    <li class="page-item active">
      <a class="page-link" href="/board/list?pageNum=${num }&amount=${pageDTO.cri.amount}">
      현재 페이지는 ${pageDTO.cri.pageNum	 } <span class="sr-only">(current)</span></a>
    </li>
     </c:forEach>
     
     <c:forEach begin="${pageDTO.startPage }" end="${pageDTO.endPage }" var="num">
    <li class="page-item"><a class="page-link" href="/board/list?pageNum=${num }&amount=${pageDTO.cri.amount}">
    <c:if test="${pageDTO.cri.pageNum ==num }"><b>${num }</b></c:if>
	<c:if test="${pageDTO.cri.pageNum !=num }"><b>${num }</b></c:if></a></li>
    </c:forEach>
    
    <c:if test="${pageDTO.next }">
    <li class="page-item">
      <a class="page-link" href="/board/list?pageNum=${pageDTO.endPage+1 }&amount=${pageDTO.cri.amount}">Next</a>
    </li>
     </c:if>
  </ul>
</nav>
			현재 페이지는 ${pageDTO.cri.pageNum	 }
			<nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:if test="${pageDTO.prev }">
    <li class="page-item"><a class="page-link" href="/board/list?pageNum=${pageDTO.startPage-1 }&amount=${pageDTO.cri.amount}">Previous</a></li>
    </c:if>
    
    <c:forEach begin="${pageDTO.startPage }" end="${pageDTO.endPage }" var="num">
    <li class="page-item"><a class="page-link" href="/board/list?pageNum=${num }&amount=${pageDTO.cri.amount}&keyword=${pageDTO.cri.keyword}&type=${pageDTO.cri.type}">
    <c:if test="${pageDTO.cri.pageNum ==num }"><b>${num }</b></c:if>
			<c:if test="${pageDTO.cri.pageNum !=num }"><b>${num }</b></c:if>
			</a></li>
    </c:forEach>
    
    <c:if test="${pageDTO.next }">
    <li class="page-item"><a class="page-link" href="/board/list?pageNum=${pageDTO.endPage+1 }&amount=${pageDTO.cri.amount}&keyword=${pageDTO.cri.keyword}&type=${pageDTO.cri.type}">Next</a></li>
    </c:if>
  </ul>
</nav>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
<script>
	var bno = "${bno}";
	var modifybno = "${modifybno}";
	var removebno = "${removebno}";
	console.log("작성한 글번호 확인1", bno);
	console.log("수정한 글번호 확인1", modifybno);

	//1. 뒤로가기로 왔는지 확인 후 경고창(alert) 출력 여부 선택
	//->history.replaceState가 수정된 곳은 null 값이 아니다. 
	if (history.state == null) {
		//history.state가 null 일때 안내창을 띄어야된다. 

		//경고창 출력부분
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
	}
	
	//2. 뒤로가기 확인을 위해 표시해 두기(history.replaceState(,,))
	history.replaceState({}, null, null);
	
	$("#amount").change(function(e){
					//on("chage"),function(e){})같은 표현식
					//on("click"),function(e){})같은 표현식
		location.href="/board/list?pageNum=${pageDTO.cri.pageNum}&amount="+$("#amount").val();
	});
</script>
