$(function(){
	
	$('#catrgory').tagsinput({
		  maxTags: 1
		});
	
	$("#categorySelect").change(function(){
		var category = $("#categorySelect").val();
		$('#catrgory').tagsinput('removeAll');
		$('#catrgory').tagsinput('add', category);
	});
	
});