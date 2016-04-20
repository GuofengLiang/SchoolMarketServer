$("#commName").focusin(function(){
	$(this).parent().children(".err_red").text("");
}).focusout(function(){ 
    		$(this).parent().children(".err_red").text("");
    		if($("#commName").val().trim()==""){
    			$(this).parent().children(".err_red").text("商品名不能为空!");
    		 	return ;
    		}			
});
//校验是否为正数
String.prototype.isUnsignedNumeric = function() {
	return /^\d+(\.\d+)?$/.test(this);
};
//校验是否为正整数
String.prototype.isPInt=function() {
    var str= /^[1-9]*[1-9][0-9]*$/;
    return str.test(this);
}
//校验是否为应该格式的图片
String.prototype.isPicture=function() {
    var str= /.(jpg|jpeg|png)$/;
    return str.test(this);
}
$("#price").focusin(function(){
	$(this).parent().children(".err_red").text("");
}).focusout(function(){ 
    		$(this).parent().children(".err_red").text("");
    		if($("#price").val().trim()==""){
    			$(this).parent().children(".err_red").text("价格不能为空!");
    		 	return ;
    		}	
    		if(!$("#price").val().isUnsignedNumeric()){
    			$(this).parent().children(".err_red").text("数字不合法，必须为正数!");
    			$(this).val("");
    		 	return ;
    		}
    	});
$("#specification").focusin(function(){
	$(this).parent().children(".err_red").text("");
}).focusout(function(){ 
    		$(this).parent().children(".err_red").text("");
    		if($("#specification").val().trim()==""){
    			$(this).parent().children(".err_red").text("商品规格不能为空!");
    		 	return ;
    		}			
});
$("#describes").focusin(function(){
	$(this).parent().children(".err_red").text("");
}).focusout(function(){ 
    		$(this).parent().children(".err_red").text("");
    		if($("#describes").val().trim()==""){
    			$(this).parent().children(".err_red").text("商品描述不能为空!");
    		 	return ;
    		}			
});
$("#stock").focusin(function(){
	$(this).parent().children(".err_red").text("");
}).focusout(function(){ 
    		$(this).parent().children(".err_red").text("");
    		if($("#stock").val().trim()==""){
    			$(this).parent().children(".err_red").text("库存不能为空!");
    		 	return ;
    		}	
    		if(!$("#stock").val().isPInt()){
    			$(this).parent().children(".err_red").text("数字不合法，必须为正整数!");
    			$(this).val("");
    		 	return ;
    		}
    	});
$("#discount").focusin(function(){
	$(this).parent().children(".err_red").text("");
}).focusout(function(){ 
    		$(this).parent().children(".err_red").text("");
    		if($("#discount").val().trim()==""){
    			$(this).parent().children(".err_red").text("折扣不能为空!");
    		 	return ;
    		}	
    		if(!$("#discount").val().isUnsignedNumeric()||$("#discount").val()<0||$("#discount").val()>10){
    			$(this).parent().children(".err_red").text("数字不合法，必须为大于0小于10的正数!");
    			$(this).val("");
    		 	return ;
    		}
    	});
$("#addCommodity").click(function(){
    //判断输入值是否为空，若为空那么就把原来的值赋给val（）
    if($("#commName").val().trim()==""){
    	$("#commName").parent().children(".err_red").text("商品名不能为空!");
    	return;
    }

    if($("#price").val().trim()==""){
    	$("#price").parent().children(".err_red").text("价格不能为空!");
    	return;
    }

    if($("#specification").val().trim()==""){
    	$("#specification").parent().children(".err_red").text("商品规格不能为空!");
    	return;
    }

    if($("#describes").val().trim()==""){
    	$("#describes").parent().children(".err_red").text("商品描述不能为空!");
    	return;
    }

    if($("#stock").val().trim()==""){
    	$("#stock").parent().children(".err_red").text("库存不能为空!");
    	return;
    }

    if($("#specialTime").val().trim()==""){
    	$("#specialTime").parent().children(".err_red").text("特价截止时间不能为空!");
    	return;
    }
    if($("#upload_image").val()==""){
    	$("#upload_image").parent().children(".err_red").text("请添加商品图片!");
    	return;
    }
    if(!$("#upload_image").val().isPicture()){
    	$("#upload_image").parent().children(".err_red").text("请添加jpg|jpeg|png商品图片!");
    	return;
    }
    if($("#discount").val().trim()==""){
    	$("#discount").parent().children(".err_red").text("折扣不能为空!");
    	return;
    }
    var formData = new FormData($("#uploadForm")[0]);
    $.ajax({
		url : 'addSingleCommodity.jhtml',
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(data) {
			alert(data.message);
			 location.reload()
		},
		error : function(data) {
			alert(data.message);
		}
	});
    });

