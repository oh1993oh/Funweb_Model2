// room 보이게 하는 쿼리

//$('.room_sec').click(function(){
//	if($('.room_sec').hasClass('room_sec')){
//		$('.room_sec').height('790px');
//
//		$('.room_sec').addClass('close').removeClass('room_sec');
//		
//		$('.click').addClass('icons').removeClass('click');
//		
//		$('.container-time-room').css('visibility', 'visible');
//		
//		$('.notis_area').css('visibility', 'hidden');
//		
//		
//	}else if($('.close').hasClass('close')){
//		$('.close').height('200px');
//		
//			$('.close').addClass('room_sec').removeClass('close');
//			
//			$('.icons').addClass('click').removeClass('icons');
//			
//			$('.container-time-room').css('visibility','hidden');
//		
//			$('.notis_area').css('visibility', 'visible');
//	}
//	
//	
//});


//var floatPosition = parseInt($("#scroll_menu").css('top'));
//// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );
//
//$(window).scroll(function() {
//	// 현재 스크롤 위치를 가져온다.
//	var scrollTop = $(window).scrollTop();
//	var newPosition = scrollTop + floatPosition + "px";
//	
//	/* 애니메이션 없이 바로 따라감
//	 $("#floatMenu").css('top', newPosition);
//	 */
//
//	$("#scroll_menu").stop().animate({
//		"top" : newPosition
//	}, 500);
//if(floatPosition==1800){
//	alert('Test!!');
//}
//}).scroll();
















$('.person-in').change(function(){
	var perener = $('.person-in option:checked').val();
	
	
	alert(perener);
	$('#person').val(perener);
	$('.person_t').val(perener);
});

$('.time_select').change(function(){
	var timein =  $('.time_select option:checked').val();
	alert(timein);
	$('#date').val(timein);
	$('.time_t').val(timein);
});




$('.time-in').click(function(){
	var time_inv =$(this).text();
	//alert(time_inv);
	 var dateinfo = $("#datepicker").val();
	 $('input#datepicker-info').val(dateinfo);
	$('#date').val(time_inv);
});

//// 데이터 요청
//$('.time-in').on('click',function(){
//	alert("데이터 요청!");
//	$.ajax({
//		url:"Reservation_write.bo",
//		type:'get',
//		success:function(t){
//			alert("1단계");
//			$(t).find("table").each(function(){
//			
//				var date = $(this).find('date').text();
//				var time = $(this).find('time').text();
//				
//			});
//		},
//		error:function(){
//			alert('실패!');
//		}
//		
//		
//	});
//	
//});

//데이터 전송
$('.time-in').on('click',function(){
	$.ajax({
		url:"Reservation_write1.me",
		type:"get",
		dataType:"json",
		data:{ date : $('#datepicker-info').val(),
			   time : $(this).text()
		
		},
		
		
		success:function(t){
			alert("호실선택 완료");
			console.log(t);
			$(t).each(function(){
				if(this.roomid=="1인실"){
					$('#rnum-11').css('visibility','hidden');
				}
				else if(this.roomid=="2인실"){
					$('#rnum-22').css('visibility','hidden');
				}
				else if(this.roomid=="4인실"){
					$('#rnum-33').css('visibility','hidden');
				}
				else if(this.roomid=="6인실"){
					$('#rnum-44').css('visibility','hidden');
				}
				else if(this.roomid=="8인실"){
					$('#rnum-55').css('visibility','hidden');
				}
				else if(this.roomid=="특실1"){
					$('#rnum-66').css('visibility','hidden');
				}
				else if(this.roomid=="특실2"){
					$('#rnum-77').css('visibility','hidden');
				}
			});
			
		
//			var changeid=$().val(t);//
			
//				$('#'+t).css('color','green');
			
			
//			alert(changeid);
//			$('#'+changeid).css('visible',invisible);
			
//			for(var idx=0; idx<t.data.length; idx++){
//			  $('.hidden').append(t.data[idx].roomcount+": "+ t.data[idx].roomid );
//			};
//			
		},
		error:function(){
			alert('실패!');
			console.log(t);
		}
		
		
	});
	
});









$('.room-in').click(function(){
	var room_inv =$(this).attr('value');
	$('#room').val(room_inv);
});


// $('.price-in').click(function(){
//	var pricener = $(this).attr('value');
//	alert(pricener);
//	$('#price').val(pricener);
// });

$('.text_r').change(function(){
	var noticer = $(this).val();
	$('#notice').val(noticer);
});


//
//$('.room-in').click(function(){
//	var roomser = $(this).attr('value');
//	alert(roomser);
//	$('#room').val(roomser);
//});








//$('#reser_click').click(function(){
//	
//	var datep =$('#datepicker-info').val();
//	var timep =$('#date').val();
//	var roomp =$('#room').val();
//	alert(datep+timep+roomp);
//	$(location).attr("href","Reservation_write_pro.bo");
//});









calender = $("#datepicker")
		.datepicker(
				{
					dateFormat : 'yy년mm월dd일' // Input Display Format 변경
					,
					showOtherMonths : true // 빈 공간에 현재월의 앞뒤월의 날짜를 표시
					,
					showMonthAfterYear : true // 년도 먼저 나오고, 뒤에 월 표시
					,
					changeYear : true // 콤보박스에서 년 선택 가능
					,
					changeMonth : true // 콤보박스에서 월 선택 가능
					,
					showOn : "button" // button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^
										// both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력
										// 표시
					,
					buttonImage : "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" // 버튼
																										// 이미지
																										// 경로
					,
					buttonImageOnly : true // 기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
					,
					buttonText : "선택" // 버튼에 마우스 갖다 댔을 때 표시되는 텍스트
					,
					yearSuffix : "년" // 달력의 년도 부분 뒤에 붙는 텍스트
					,
					monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7', '8',
							'9', '10', '11', '12' ] // 달력의 월 부분 텍스트
					,
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ] // 달력의 월 부분
																// Tooltip 텍스트
					,
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] // 달력의
																		// 요일 부분
																		// 텍스트
					,
					dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일',
							'토요일' ] // 달력의 요일 부분 Tooltip 텍스트
					,
					minDate : "-0D" // 최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
					,
					maxDate : "+5Y" // 최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
			
				});

	








// $(document).ready(function() {
// $(".ui-datepicker-trigger").click(function(){
// alert("click");
// if ($(".ui-datepicker ui-widget ui-widget-content ui-helper-clearfix
// ui-corner-all").is(':visible') == false) {
// var dateinfo = $("#datepicker").val();
// alert(dateinfo);
// } else {
// var dateinfo = $("#datepicker").val();
// alert(dateinfo);
// }
//	  
// });
//  
//  
// $('#datepicker').change(function() {
// var dataS = $('#datepicker').val();
// var dats = dataS;
//		
// $('input#datepicker-info').val(dataS);
// });
//  

// $('.ui-datepicker-trigger').click(function() {
// var data1 = $('#datepicker').val();
// alert("Change");
// $('input#datepicker-info').val(data1);
// });
// });
