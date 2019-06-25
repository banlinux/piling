function getContractDetails(contractCode){

	
	

	
	var contNo=contractCode.substring(0,5);
	var contName=contractCode.substring(6);	
	$.ajax({
		type: "POST",
		url: "rigMaster.htm?",
		data: "contractNo="+contNo+"&_target1=associationDetails",
		success: function(response){
		var data=	$.parseJSON(response);
		
	//	 var html = '<option value="0">--Select--</option>';
         var len = data.length;

             for ( var i = 0; i < len; i++) {
             //    html += '<option value="' + data[i].id + '">'+ data[i].subLDesc+ '</option>';
            	
                 $("#site_no").val( data[i].siteCode);
             }
      	   $("#contract_no").val(contNo);
    	   $("#contractName").val(contName);
			 
		},
		error: function(e){
			alert('Error: ' + e);
			}
			
	});

}