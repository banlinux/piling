function getSiteDetails(zoneCode){
	$.ajax({
		type: "POST",
		url: "pilingRigProgressForm.htm",
		data: "zoneCode="+zoneCode+"&_target2=site",
		success: function(response){
		var data=	$.parseJSON(response);
		var html = '<option value="0">--Select Site--</option>';
         var len = data.length;
             for ( var i = 0; i <len; i++) {

                 html += '<option value="' + data[i].siteCode + '">'+ data[i].siteCode+":"+ data[i].siteName+ '</option>';
             }
             html += '</option>';
             $('#siteCode').html(html);
			 
		},
		error: function(e){
			alert('Error: ' + e);
			}
			
	});
	
}
/*
function getContractDetails(siteCode){
	$.ajax({
		type: "POST",
		url: "pilingRigProgressForm.htm",
		data: "siteCode="+siteCode+"&_target3=contract",
		success: function(response){
		var data=	$.parseJSON(response);
		var html = '<option value="0">--Select Contract--</option>';
         var len = data.length;
             for ( var i = 0; i <len; i++) {

                 html += '<option value="' + data[i].contractCode + '">'+ data[i].contractCode+":"+ data[i].contractName+ '</option>';
             }
             html += '</option>';
             $('#contractCode').html(html);
			 
		},
		error: function(e){
			alert('Error: ' + e);
			}
			
	});
}
*/       
function getContractDetails(contractCode){
	
	var contNo=contractCode.substring(0,5);
	var contName=contractCode.substring(6);	
	$.ajax({
		type: "POST",
		url: "pilingRigProgressForm.htm?",
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
function getRigDetails(rigCode){

	var rigNo=rigCode.substr(0,rigCode.indexOf(':'));

	var rigName=rigCode.substr(rigCode.indexOf(':')+1);
	alert(rigName);
	   $("#rig_no").val(rigNo);

	   $("#rig_name").val(rigName);
	   

}








function getPileDetails(contractCode){
	var pileNo=contractCode.substring(0,6);
	var contName=contractCode.substring(7);
	$('#result').jqGrid('GridUnload');
	$('#result').jqGrid({
		mtype: "POST",		
		url:"pilingRigProgressForm.htm?_target4=associationDetails&pileNo="+pileNo,		
		datatype: "json", 
		ajaxGridOptions: { contentType: 'application/json; charset=utf-8' },
		 height: "auto",
		colNames:['Pile No','Pile Dia','Cage Length','Boring Length','Concrete Volume','Cage Detail','Drawing No'],
		colModel:[  
		           {name:'pileNo',width:120},		          
		           {name:'pileDia', width:120},
		           {name:'cageLength', width:120},
		           {name:'boringLength',width:120},		          
		           {name:'concreteVoume', width:120},
		           {name:'cageDetail', width:250},
		           {name:'drawingNo', width:120}],
		           rowNum:10,
		           rowList:[10,15,20,25,30,35,40],
		           gridview: true,
		           pager: '#pager',
		           viewrecords: true,
		           multiselect: false,
		           loadonce: true,
		           caption: "Country" ,
		           
		           loadComplete: function () {
		        	   $("#pileNo").val(pileNo);
		        
		           },
		           loadError: function (jqXHR, textStatus, errorThrown) {
		               alert('HTTP status code: ' + jqXHR.status + '\n' +
		                     'textStatus: ' + textStatus + '\n' +
		                     'errorThrown: ' + errorThrown);
		               alert('HTTP message body (jqXHR.responseText): ' + '\n' + jqXHR.responseText);
		           }
		           });
	
	jQuery("#result").jqGrid('navGrid','#pager',{edit:false,add:false,del:false});	
	
	jQuery("#result").click( function(){ 
		var id = jQuery("#result").jqGrid('getGridParam','selrow');
		if (id) { var ret = jQuery("#result").jqGrid('getRowData',id); 
	//	alert("Code="+ret.pileNo+"...");
		$("#pileNo").val(ret.pileNo);
	//	$("#countryName").val(ret.contName);
	//	$("#countryName").val(ret.deptCode);
	//	$("#countryName").val(ret.deptName);
		} 
		else { alert("Please select row");} });
	
	

	
}