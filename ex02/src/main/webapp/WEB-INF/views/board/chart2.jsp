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
		<h1 class="h3 mb-2 text-gray-800">작성자 순위 차트 보기</h1>
		<p class="mb-4">
			코드로 배우는 스프링 웹 프로젝트(개정판)를 책을 보고 똑같이 만들고 있어요<br> <a
				target="_blank">우리가 사용한 템플릿</a>.
		</p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">차트 보기</h6>
				<button id="showtime" class="w-btn w-btn-blue"
					style="float: right +1;">자동갱신</button>
				<button id="stop" class="w-btn w-btn-blue" style="float: right;">멈춤</button>
			</div>
			<div class="chart-pie pt-4">
				<canvas id="myPieChart"></canvas>
			</div>
		</div>
	</div>
</body>
<%@include file="../includes/footer.jsp"%>
<script src="/resources/vendor/chart.js/Chart.min.js?ver=3"></script>
<script>
//버튼처리
$(document).ready(function(){
	$("#showtime").on("click",function(e){
		console.log("갱신 실행");
		e.preventDefault();//버튼에 걸린 이벤트 처리 다 취소
		updateChart();
	});	
	$("#stop").on("click",function(e){
		e.preventDefault();
		//갱신멈춤
		clearTimeout(timerID);//타이머 멈춤 더이상 갱신되지 않는다.
	});
	
});

</script>

<script>
//footer에 쓰여있어서 바로 ajax사용 가능
//아래의 데이터를 ajax를 통해서 처리
//var mylabels=${mylabels};
//var mydata=${mydata};
//기존 데이터와 차이가 있을때만 다시 불러온다
var mylabels;
var mydata;
function updateChart(){
$.ajax({
	type:"get",
	url:"/api/board/chart",
	dataType:"json",
	success:function(data){
		console.log("이전 데이터",mylabels,mydata);
		
		//비교  |||3개는 타입까지 비교
		if((JSON.stringify(mylabels) != JSON.stringify(data.mylabels))  ||
		(JSON.stringify(mydata) != JSON.stringify(data.mydata))){
			//이 아래가 갱신 
			mylabels = data.mylabels;
			mydata = data.mydata;
		//아래 함수가 데이터 변할때
			mychart();
		}
		
		console.log("가져온데이터",mylabels,mydata)
		
	}
	});
	timerID = setTimeout("updateChart()",	2000);//앞이 수행 뒤가 갱신
	//2초 후에 updateChart를 수행해라
	//setInterval 일정시간 간격 두고 실행
}

</script>
<script src="/resources/js/demo/chart-pie-demo.js"></script>

</html>