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
						id="exampleInputEmail" name="title" value="${board.title }"
						readonly>
				</div>
				<div class="form-group">
					<input type="text" class="form-control form-control-user"
						id="exampleInputEmail" name="writer" value="${board.writer }"
						readonly>
				</div>
				<div class="form-group">
					<textarea rows="10" class="form-control form-control-user"
						id="exampleInputEmail" name="content" readonly>${board.content }</textarea>
				</div>
				<form action="/board/remove" method="post" id="delForm">
					<input type="hidden" name="bno" value="${board.bno}"> <input
						type="hidden" name="delKey" id="delKey"> <input
						type="hidden" name="pageNum" value="${cri.pageNum }"> <input
						type="hidden" name="amount" value="${cri.amount }"> <input
						class="w-btn w-btn-pink" type="button" value=" 삭제하기 "
						id="delButton"> <a
						href="/board/list?pageNum=${cri.pageNum }&amount=${cri.amount}"
						class="w-btn w-btn-blue"> 목록으로 돌아가기 </a> <a
						href="/board/modify?bno=${board.bno }&pageNum=${cri.pageNum}&amount=${cri.amount}"
						class="w-btn w-btn-blue"> 수정 </a>
						<button class="btn btn-primary">테스트</button>
				</form>
			</div>
			<div>
				<br>
				<div class="table-responsive">

					<span id="reply"></span> <br> 
					
					작성자: <input id="replyerdata"
						type="text" placeholder="작성자" style="width: 100px; height: 23px;"><br>
					댓글 내용: <input id="replydata" type="text" placeholder="댓글을 입력해 주세요"
						style="width: 500px; height: 50px;"><br>
					<button class="w-btn w-btn-blue" id="modifyreply"
						style='font-size: 13px; padding-top: 9px; padding-bottom: 8px; padding-left: 9px; padding-right: 9px;'>수정 확인</button>
					<button class="w-btn w-btn-pink" id="modifycancle"
						style='font-size: 13px; padding-top: 9px; padding-bottom: 8px; padding-left: 9px; padding-right: 9px;'>수정 취소</button><br>
					<button class="w-btn w-btn-pink" id="replyInsert"
						style='font-size: 13px; padding-top: 9px; padding-bottom: 8px; padding-left: 9px; padding-right: 9px;'>댓글
						등록</button>
				</div>
			</div>
		</div>
		<div></div>
	</div>

	<!-- /.container-fluid -->

	<!-- End of Main Content -->
	<%@include file="../includes/footer.jsp"%>
	<script src="/resources/js/reply.js?ver=1">
</script>
	<script>
//리플 목록을 가져와서 화면에 뿌려주기
$(document).ready(function(){
	show();
	function show(){
		
	console.log("리플 내용")
	replyService.getList(${board.bno},function(data){
		//data에 리플 내요잉 들어있다
		len=data.length || 0;
		var htmlString="";
		console.log(data);
		console.log(len);
		for(var i=0;i<len;i++){
			htmlString+="<b>"+(i+1)+". "+data[i].replyer+"</b>  "+"("+
			replyService.time('<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${board.regdate}"/>'
		,data[i].updatedate)
	+") <button value='"+data[i].rno+"' id='modButton'class='w-btn w-btn-pink' style='font-size: 13px;  padding-top: 9px; padding-bottom: 8px; padding-left: 9px;padding-right: 9px;'>수정</button> <button id ='delButton' value='"+data[i].rno+"' class='w-btn w-btn-blue' style='font-size: 13px;  padding-top: 9px; padding-bottom: 8px; padding-left: 9px;padding-right: 9px;'>삭제</button><br>"+"&nbsp"+data[i].reply+"<hr>" 
			
			
// 			htmlString +="<b>"+(i+1)+"."+data[i].replyer+"</b> -"+"("+data[i].updatedate+")"+ 
// 			//replyService.time('<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${board.regdate}"/>'
// 			"<button class='w-btn w-btn-pink' +data[i].rno+ id='replydelButton' style='font-size: 13px;  padding-top: 9px; padding-bottom: 8px; padding-left: 9px;padding-right: 9px;'>수정</button>"+
// 			"<button id ='delButton' value='"+data[i].rno+"' class='w-btn w-btn-blue' style='font-size: 13px; padding-top: 9px; padding-bottom: 8px; padding-left: 9px;padding-right: 9px;'>삭제</button><br>"+
// 			"&nbsp"+data[i].reply+"<hr>"; 
				
		}
		console.log("리플 만들어줘 ",htmlString)
		$("#reply").html(htmlString);
	});
	
	}
	
	//리플 작성버튼을 클릭했을때 수행하는 작업(1. 댓글 등록 2. 댓글 목록 가져오기)
	$("#replyInsert").on("click",function(){    
		console.log("리플작성버튼 클릭");
		
		var bnodata=${board.bno};
		var replydata=$("#replydata").val();
		var replyerdata=$("#replyerdata").val();
		console.log("리플입력값",bnodata,replydata,replyerdata);
		if(replydata && replyerdata ){ //작성내용이 있을때만 동작해라~
			replyService.add({bno:bnodata ,reply:replydata ,replyer:replyerdata },function(data){
				//alert(data);
				show();	// 위치가 여기인 이유는 자바스크립트가 ajax,time 관련해서는 비동기처리되기 때문에
			} ); //콜백함수
			//작성내용 비우기
		$("#replydata").val("");
		$("#replyerdata").val("");
		}else{
			alert("댓글과 작성자를 모두 입력해주세요");
		}
		
	});
	
	$(".table-responsive").on("click","#delButton",function(){//
		var removerno=$(this).val();
		console.log("리무브 rno : ",removerno);
		replyService.remove(removerno,function(){
		alert(removerno+"번 댓글 삭제완료 되었습니다.");
		console.log(removerno,"번 삭제 완료");
			show();			
		});			
		
	});
	
	var Modreply;
	var Modreplyer;
	$("#modifyreply").hide();
	$("#modifycancle").hide();
	$(".table-responsive").on("click","#modButton",function(){//수정하려고
		$("#modifyreply").show();
		$("#modifycancle").show();
		$("#replyInsert").hide();
		//var bnodata=${board.bno};
		var modifyrno=$(this).val();
		console.log("수정 rno : ",modifyrno);
		var reply;
		var replyer;
		replyService.get(modifyrno,function(data){//data에 모든 정보를 갖고옴
			//console.log("수정번호: ",modifyrno,data);
			//console.log(data);
			reply = data.reply;
			replyer = data.replyer;
			console.log("갖고 온 작성자: ",replyer);
			console.log("갖고 온 내용: ",reply);
			//${board.regdate}
			
			//입력창에 수정 내용 올리기
			Modreply = $("#replydata").val(reply);
			Modreplyer = $("#replyerdata").val(replyer);
			
			//수정 취소 버튼 누름
			$("#modifycancle").on("click",function(){
				console.log("!!댓글 수정 취소 버튼 누름");
				$("#replydata").val("");
				$("#replyerdata").val("");
				$("#modifyreply").hide();
				$("#modifycancle").hide();
				$("#replyInsert").show();
			});
			
			//"댓글 수정 확인" modifyreply
			$("#modifyreply").on("click",function(){
				console.log("!!댓글 수정 확인 버튼 누름");
				var Modifyreply = $("#replydata").val();
				var Modifyreplyer = $("#replyerdata").val();
				console.log("수정번호 잘 뜨나~~",modifyrno);
				console.log("수정하는 댓글: ",Modifyreply,Modifyreplyer);
				replyService.modify({rno:modifyrno ,reply:Modifyreply,replyer:Modifyreplyer},function(data){
				
					$("#modifyreply").hide();
					$("#modifycancle").hide();
					$("#replyInsert").show();
					show();	
					$("#replydata").val("");
					$("#replyerdata").val("");
					
				});
				
			});
			
		});
		//console.log("수정 rno 잘 가져왓나~~",modifyrno);
		
		
// 		replyService.modify({rno:34,replyer:"수진",reply:"이건내용"}.modifyrno,function(){
			
// 			show();			
// 		});			
		
	});
	
	
});
	
	//"댓글 수정 확인" modifyreply
/* 	$("#modifyreply").on("click",function(){
		console.log("!!댓글 수정 확인 버튼 누름");
		var Modifyreply = $("reply").val();
		var Modifyreplyer = $("replyer").val();
		console.log("수정하는 댓글: ",Modifyreply,Modifyrepler);
		
	}); */
	
	
// 	$("#replyInsert").on("click",function(){
// 		//수행할 내용 적기
// 		console.log("리플작성버튼 클릭");
		
// 		var bnodata=${board.bno};
// 		var replydata=$("replydata").val();
// 		var replyerdata=$("replyerdata").val();
// 		console.log("리플입력값 ",bnodata, replydata,replyerdata);
// 		if(replydata && replerdata){//작성 내용이 있을때만 동작해라
// 		replyService.add({bno:bnodata ,reply:replydata , replyer:replyerdata },function(data){
// 			//alert(data);
// 			show();//위치가 여기인 이유는 자바스크립트가 ajax,time관련해서는 비동기처리되기 때문
// 		});//콜백함수
// 		}
			
// 		//작성내용 비우기
// 		$("replydata").val("");
// 		$("replyerdata").val("");
// 	}else{
// 		alert("댓글과 작성자를 모두 입력해 주세요")
// 	}
// 	);
	
// });
</script>
	<script>
//리플등록테스트(자바스크립트객체를 이용해야 json포맷으로 변환해줌 쌍따옴표 금지)
// replyService.add({reply:"리플내용..",replyer:"작성자",bno:229},function(data){
// 	alert("결과확인"+data);
// });
// replyService.mytest(3,4)//콘솔로그에 7이 나오도록
// replyService.getList(229,function(data){
// 	alert("목록 가져오기 성공")
// 	console.log("목록",data)
// })
// replyService.get(1,function(data){
// 	alert("가져오기 성공")
// 	console.log("1번 댓글",data)
// })
// replyService.modify({rno:124,reply:"4교시",replyer:"2나그네"},function(data){
// 	alert("46번 수정함~",data)
// })
/* replyService.remove(45,function(data){
	alert("45번 삭제함 ",data)
}) */
</script>

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