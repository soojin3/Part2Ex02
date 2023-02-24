<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">스프링 게시판</h1>
                    <p class="mb-4">코드로 배우는 스프링 웹 프로젝트(개정판)를 책을 보고 똑같이 만들고 있어요<br> <a target="_blank"
                            href="https://startbootstrap.com/previews/sb-admin-2">우리가 사용한 템플릿</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">게시글 목록 보기
                            </h6>
                       <a href="/board/register" class="w-btn-neon2" style="float: right;" > 글쓰기 </a>
                        </div>
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>순번</th>
                                            <th>글 번호</th>
                                            <th>글 제목</th>
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
                                    <c:set var="no" value="0"/><!-- 페이지 영역에 변수 선언 -->
                                    <c:forEach items="${list }" var="board">
                                        <tr>
                                            <td>${no=no+1 }</td>
                                            <td>${board.bno }</td>
                                            <!-- 글 삭제시에 진짜 글 번호가 필요하다 -->
                                            <td><a href="/board/get?bno=${board.bno }">${board.title }</a></td>
                                            <td>${board.writer }</td>
                                            <td><fmt:formatDate pattern="YY년 MM월 dd일 a HH시 mm분" value="${board.regdate }"/></td>
                                            <c:if test="${board.regdate==board.updatedate }">
                                            <td><fmt:formatDate pattern="YY년 MM월 dd일 a HH시 mm분" value="${board.regdate }"/></td>
                                            </c:if>
                                            <c:if test="${board.regdate!=board.updatedate }">
                                            <td style="color:red"><fmt:formatDate pattern="YY년 MM월 dd일 a HH시 mm분" value="${board.updatedate }"/></td>
                                            </c:if>
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
<%@include file="../includes/footer.jsp" %>
<script>
	var bno="${bno}";
	var modifybno="${modifybno}";
	var removebno="${removebno}";
	console.log("작성한 글번호 확인1", bno);
	console.log("수정한 글번호 확인1", modifybno);
	if(bno){
		alert(bno +" 번 글이 등록되었습니다.");
	}
	if(modifybno){
		alert(modifybno +" 번 글이 수정되었습니다.");
	}
	if(removebno){
		alert(removebno +" 번 글이 삭제되었습니다.");
	}
</script>
