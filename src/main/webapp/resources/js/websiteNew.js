/**
 * 
 */

$().ready(function() {
	$("#webForm").validate({
		rules : {
			name : {
				required : true,
				maxlength :50
			},
			url : {
				required : true,
				url : true
			},
			score : {
				required : true
			},
			logoFile: {
				required : true,
				accept: "gif|png|jpg|jpeg" 
			},
			picture1: {
				required : true,
				accept: "gif|png|jpg|jpeg" 
			},
			picture2: {
				required : true,
				accept: "gif|png|jpg|jpeg" 
			},
			picture3: {
				required : true,
				accept: "gif|png|jpg|jpeg" 
			},
			summary : {
				required : true,
				maxlength :300
			},
			content : {
				required : true,
				maxlength :2000
			}
		},
		messages : {
			title : {
				required : "请填写网站名称",
				maxlength : "网站名称不能多于50个字符"
			},
			url : {
				required : "请填写广告网址",
				url : "请填写正确以http://或https://开始的完整网址"
			},
			score : {
				required : "请选择网站评分"
			},
			logoFile : {
				required : "请选择网站logo",
				accept   :"只能上传gif|png|jpg|jpeg格式的图像"
			},
			picture1 : {
				required : "请选择网站展示图片",
				accept   :"只能上传gif|png|jpg|jpeg格式的图像"
			},
			picture2 : {
				required : "请选择网站展示图片",
				accept   :"只能上传gif|png|jpg|jpeg格式的图像"
			},
			picture3 : {
				required : "请选择网站展示图片",
				accept   :"只能上传gif|png|jpg|jpeg格式的图像"
			},
			summary : {
				required : "请填写网站简介",
				maxlength :"网站简介最多300字"
			},
			content : {
				required : "请填写网站详细信息",
				maxlength :"网站简介最多2000字"
			}
		}
	});
	
	
	//提交事件
	$('#sb').click(function(){
        if($("#webForm").valid()){
        	$("#webForm").submit();
        } 
    });
});