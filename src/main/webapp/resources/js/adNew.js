/**
 * 
 */

$().ready(function() {
	$("#adForm").validate({
		rules : {
			title : {
				required : true,
				maxlength :20
			},
			url : {
				required : true,
				url : true
			},
			image : {
				required : true,
				accept: "gif|png|jpg|jpeg" 
			}
		},
		messages : {
			title : {
				required : "请填写广告标语",
				maxlength : "广告标语不能多于20个字符"
			},
			url : {
				required : "请填写广告网址",
				url : "请填写正确以http://或https://开始的完整网址"
			},
			image : {
				required : "请选择广告封面",
				accept   :"只能上传gif|png|jpg|jpeg格式的图像"
			}
		}
	});
	
	
	//提交事件
	$('#sb').click(function(){
        if($("#adForm").valid()){
        	$("#adForm").submit();
        } 
    });
});