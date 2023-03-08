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
	
	return {add:add,getList:getList, get:get,modify:modify,remove:remove, mytest:aaa};
	
})();

	
		

//replyService.add(reply,callback);