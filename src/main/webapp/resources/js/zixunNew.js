/**
 * 
 */

$().ready(function() {
	$("#zixunForm").validate({
		rules : {
			title : {
				required : true,
				maxlength :50
			},
			author : {
				required : true,
				maxlength :50
			},
			caipiaoType : {
				required : true
			},
			summary: {
				required : true,
				maxlength :300
			},
			content: {
				required : true,
				maxlength :2000
			}
		},
		messages : {
			title : {
				required : "请填写资讯文章名称",
				maxlength : "资讯文章名称不能多于50个字符"
			},
			author : {
				required : "请填写资讯文章作者/出处",
				maxlength : "资讯文章作者/出处不能多于50个字符"
			},
			caipiaoType : {
				required : "请选择资讯分类"
			},
			summary : {
				required : "请填写资讯简介",
				maxlength :"资讯简介最多300字"
			},
			content : {
				required : "请填写资讯详细信息",
				maxlength :"资讯文章详情最多2000字"
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