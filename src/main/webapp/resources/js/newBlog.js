/**
 * by huangshanqi
 */
$(function(){
	
	$('#category').tagsinput({
		  maxTags: 5
	});
	
	$('#tags').tagsinput({
		  maxTags: 5
	});
	
	$("#categorySelect").change(function(){
		var category = $(this).val();
		$('#category').tagsinput('removeAll');
		$('#category').tagsinput('add', category);
	});
	

	
	$(".oldtag").click(function(){
		var tagName = $(this).html();
		$('#tags').tagsinput('add', tagName);
	});
	
	$("#form").validate({
		ignore: [],
		rules : {
			blogType : {
				required : true,
			},
			title : {
				required : true,
				maxlength :100
			},
			summary : {
				required : true,
				maxlength :300
			},
			content: {
				required : true,
				maxlength :60000
			},
			category: {
				required : true
			},
			tags: {
			    required : true
		    }
		},
		messages : {
			blogType : {
				required : "请选择文章类型！只有原创和翻译文章才能推荐到首页"
			},
			title : {
				required : "请填写博文题目，最多100字！！！",
				maxlength : "博文题目最多100字！"
			},
			summary : {
				required : "请填写文章摘要，最多300字！！！",
				maxlength :"文章摘要最多300字!"
			},
			content : {
				required : "请填写文章详细内容！！！",
				maxlength :"章详细内容最多10000字"
			},
			category: {
				required : "请填写文章分类！！！"
			},
			tags: {
			    required : "请填写文章标签，最多五个！！！"
		    }
		}
	});
	
	
	
	//提交事件
	$('#submit-btn').click(function(){
		
        if($("#form").valid()){
        	$("#form").submit();
        	var category=$("#category").val();
    		alert(category);
        } 	
        
		
	});
	
});