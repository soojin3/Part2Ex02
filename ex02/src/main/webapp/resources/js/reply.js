/**
 * 
 */
console.log("리플관련 자바스크립트를 실행합니다.");

var replyService=(function(){
	
	//리플 등록
	//필요한건 리플
	function add(reply,callback,error){  
		console.log("리플 등록 js실행");
		$.ajax({
			type:"post",
			url:"/replies/new",
			data:JSON.stringify(reply),	//json 포맷의 리플 데이터
			contentType:"application/json;charset=utf-8",
			success:function(data){//성공시(200)success
				if(callback)//자바스크립트는 널이 아니면 무조건 트루이므로 그냥 두기만 해도 성공
					callback(data);//콜백함수로 처리할 내용 넣어줌
				
			},
			error:function(xhr,status,er){//function(xhr,status,error)3개가 이 순서대로 들어간다
				if(error){
					error(er);
				}
			}
		});
	}
	//해당글에 리플목록 가져오기
	//필요한건 글 번호
	function getList(bno,callback,error){  
		console.log("리플 목록 가져오기 js실행");
		$.ajax({
			type:"get",
			url:"/replies/pages/"+bno,
			success:function(data){//성공시(200)success
				if(callback)//자바스크립트는 널이 아니면 무조건 트루이므로 그냥 두기만 해도 성공
				callback(data);//콜백함수로 처리할 내용 넣어줌
				
			},
			error:function(xhr,status,er){//function(xhr,status,error)3개가 이 순서대로 들어간다
				if(error){
					error(er);
				}
			}
		});
	}
	//하나의 리플 가져오기
	function get(rno,callback,error){  
		console.log("해당 리플 가져오기 js실행");
		$.ajax({
			type:"get",
			url:"/replies/"+rno,
			success:function(data){//성공시(200)success
				if(callback)//자바스크립트는 널이 아니면 무조건 트루이므로 그냥 두기만 해도 성공
				callback(data);//콜백함수로 처리할 내용 넣어줌
				
			},
			error:function(xhr,status,er){//function(xhr,status,error)3개가 이 순서대로 들어간다
				if(error){
					error(er);
				}
			}
		});
	}
	
	//리플 수정하기
	//필요한건 리플 정보
	function modify(reply,callback,error){  
		console.log("리플 등록 js실행");
		$.ajax({
			type:"put",
			url:"/replies/"+reply.rno,
			data:JSON.stringify(reply),	//json 포맷의 리플 데이터
			contentType:"application/json;charset=utf-8",
			success:function(data){//성공시(200)success
				if(callback)//자바스크립트는 널이 아니면 무조건 트루이므로 그냥 두기만 해도 성공
				callback(data);//콜백함수로 처리할 내용 넣어줌
				
			},
			error:function(xhr,status,er){//function(xhr,status,error)3개가 이 순서대로 들어간다
				if(error){
					error(er);
				}
			}
		});
	}
	//리플 삭제하기
	function remove(rno,callback,error){  
		console.log("해당 리플 가져오기 js실행");
		$.ajax({
			type:"delete",
			url:"/replies/"+rno,
			success:function(data){//성공시(200)success
				if(callback)//자바스크립트는 널이 아니면 무조건 트루이므로 그냥 두기만 해도 성공
				callback(data);//콜백함수로 처리할 내용 넣어줌
				
			},
			error:function(xhr,status,er){//function(xhr,status,error)3개가 이 순서대로 들어간다
				if(error){
					error(er);
				}
			}
		});
	}
	
	//function get(){  }
	function aaa(num1,num2){
		console.log("두 수의 합은",num1+num2,"이다");
	}
	
	function displayTime(boardDateStr,replyDateStr){
		var boardDate = new Date(boardDateStr);
		console.log("게시글 작성 시간",boardDate);
		var replyDate = new Date(replyDateStr);
		var gap=replyDate-boardDate;
		console.log("시간차",gap);
				//시 분 초  ms
		if(gap < 24*60*60*1000 ){ //24시간 이내라면
			//11:38:30
			var hh=replyDate.getHours();
			var hh12= hh >12 ? hh-12: hh;
			var ampm= hh >=12 ? '오후': '오전';
			var mi=replyDate.getMinutes();
			var ss=replyDate.getSeconds();
			//var value=ampm+(hh12>9?' ':' 0') +hh12+":"+(mi>9?'':'0')
			          +mi+":"+(ss>9?'':'0')+ss;
			var value=[ampm,(hh12>9?' ':' 0'),hh12,":",(mi>9?'':'0'),
			mi,":",(ss>9?'':'0'),ss].join(''); //join 메소드는 배열의 요소를 합쳐서 문자열로
												//파라미터는 합칠때 사이에 넣어줄 문자
			var nowtime = new Date();
			var hours = nowtime.getHours();
			//var minutes = nowtime.Minutes();
			var before=hours-hh;
			if(before==0){
				return "방금";
			}else{
				return before+" 시간 전";
			}
		}else{
			var week_array = new Array('일', '월', '화', '수', '목', '금', '토');
			
			return [replyDate.getFullYear(),'/',
				(replyDate.getMonth()>10 ? '':'0'), replyDate.getMonth()+1,'/',
				(replyDate.getDate()>9 ?'':'0'),replyDate.getDate(),' ',
				week_array[replyDate.getDay()] ].join('');         
		
		}
	}
	
	return {add:add,getList:getList, get:get,modify:modify,remove:remove, mytest:aaa,time:displayTime};
	
})();

	
		

//replyService.add(reply,callback);