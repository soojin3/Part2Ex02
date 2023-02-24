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
                            <h6 class="m-0 font-weight-bold text-primary">게시글 목록 보기</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
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
                                    <c:forEach items="${list }" var="board">
                                        <tr>
                                            <td>${board.bno }</td>
                                            <td>${board.title }</td>
                                            <td>${board.writer }</td>
                                            <td>${board.regdate }</td>
                                            <td>${board.updatedate }</td>
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