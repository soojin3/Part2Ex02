<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">작성자 차트 보기</h1>
	<p class="mb-4">코드로 배우는 스프링 웹 프로젝트(개정판)를 책을 보고 똑같이 만들고 있어요<br> <a target="_blank"
		>우리가 사용한 템플릿</a>.
	</p>
  <!-- Bar Chart -->
                      <div class="card shadow mb-4">
                         <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Bar Chart</h6>
                         </div>
                                <div class="card-body">
                                    <div class="chart-bar">
                              <canvas id="myBarChart"></canvas>
                         </div>
                       <hr>
                                    Styling for the bar chart can be found in the
                                    <code>/js/demo/chart-bar-demo.js</code> file.
                         </div>
                                </div>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">차트 보기</h6>
		</div>
			 <div class="chart-pie pt-4">
                <canvas id="myPieChart"></canvas>
                </div>
                </div>
                     
                            </div>
</body>
<%@include file="../includes/footer.jsp"%>
    <!-- Page level plugins -->
    <script src="/resources/vendor/chart.js/Chart.min.js"></script>
<script>
//var mylabels=["관리자","글쓴이","3교시","테스트","홍길동"];
//var mydata=[100,200,300,400,500];
var mylabels=${mylabels};
var mydata=${mydata};
</script>
    
<script src="/resources/js/demo/chart-pie-demo.js"></script>
<script src="/resources/js/demo/chart-bar-demo.js"></script>

<script>
mychart();
</script>
</html>