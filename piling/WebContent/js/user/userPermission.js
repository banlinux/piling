function validateForm()
{
	var ui=document.getElementById("userId").value;			//user id.
	var pw=document.getElementById("password").value;		//password.
	var repw=document.getElementById("repassword").value;	//re-enter password.
	var un=document.getElementById("userName").value;		// username.
	var st=document.getElementById("status").value;			// status.
	
	if (ui==null || ui=="" || ui=="0"){
		alert("User Id must be filled out");
		return false;
	}
	if (pw==null || pw==""){
		alert("Password must be filled out");
		return false;
	}
	if (repw==null || repw==""){
		alert("Re-enter Password must be filled out");
		return false;
	}
	if (pw != repw){
		alert("Password and Re-enter Password must be same");
		return false;
	}
	if (st==null || st==""){
		alert("Active Status must be filled out with y/n");
		return false;
	}
	if (st.toLowerCase()!="y" && st.toLowerCase()!="n" ){
		alert("Active Status must be y or n");
		return false;
	}
	if(un==null || un==""){
		alert("User Id is not valid !!! Select valid user.");
		return false;
	}
	
	return true;
}
function getEmpDetails(empcd){
	// alert(empcd);
	$.ajax({
        type: "POST", 		
        url: "userPermission.htm", 		
        data: "empCode="+empcd+"&_target2=empDetails", 
        success: function(response){
			var data=	$.parseJSON(response);
			$("#empCode").val(data[0].eCode);
			 $("#userName").val(data[0].eName);
			 $("#userId").val(data[0].uId);
	//		 document.getElementById("userId").value=data[0].uId;  //Rinku Added
			 $("#status").val(data[0].status);
			},
			error: function(e){
				alert('Error: ' + e);
				}
				
		});
}
function getPassword(empcd){
	$.ajax({
		type: "POST",
		url: "userPermission.htm",
		data: "empCode="+empcd+"&_target3=pwdDetails",
		success: function(response){
			var data = $.parseJSON(response);
			$("#password").val(data[0].password);
			$("#repassword").val(data[0].password);
			$("#status").val(data[0].status);
		},
		error: function(e){
			alert('Error:' + e);
		}
	});
}
function getPermissionDetails(empcd){

//	document.getElementById("contCode").readOnly = true;  Rinku
//	document.getElementById("userName").readOnly = true;   Rinku
	var empC=empcd.substring(0,empcd.indexOf(":"));
	getEmpDetails(empC); 
	//getPassword(empC);   Rinku
	btnenable();			

	$.ajax({
		type: "POST",
		url: "userPermission.htm",
		data: "empCode="+empC+"&_target1=entryDetails",
		success: function(response){

			var data=	$.parseJSON(response);

	//		document.getElementById("userId").value=empC;  //Rinku Added	
			if (data[0].M_SITE == "Y")
				document.getElementById("m_site").checked = true;
			else
				document.getElementById("m_site").checked = false;
				
			if (data[0].M_CONTRACT == "Y")
				document.getElementById("m_contract").checked = true;
			else
				document.getElementById("m_contract").checked = false;
				
			if (data[0].M_PERMISSION == "Y")
				document.getElementById("m_permission").checked = true;
			else
				document.getElementById("m_permission").checked = false;
				
			if (data[0].F_RIG_PROGERSS == "Y"){
				document.getElementById("f_rig_progress").checked = true;
		
			}
			else
				document.getElementById("f_rig_progress").checked = false;
				
			if (data[0].R_RIG_PROGERSS == "Y")
				document.getElementById("r_rig_progress").checked = true;
			else
				document.getElementById("r_rig_progress").checked = false;
				
			if (data[0].M_RIG== "Y")
				document.getElementById("m_rig").checked = true;
			else
				document.getElementById("m_rig").checked = false;
				
			if (data[0].M_PILE == "Y")
				document.getElementById("m_pile").checked = true;
			else
				document.getElementById("m_pile").checked = false;
	
		
			
			btndisable(); 
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}

function btndisable(){
	document.getElementById("_save").disabled = true;		// save disabled.
	document.getElementById("_modify").disabled = false;	//modify enabled.
}
function btnenable(){
	document.getElementById("_modify").disabled = true;		// modify disabled.
	document.getElementById("_save").disabled = false;		// save enabled.
}

function selectall(){
	document.getElementById("ltds").checked = true;
	document.getElementById("csbso").checked = true;
	document.getElementById("es").checked = true;
	document.getElementById("faa").checked = true;
	document.getElementById("scbsf").checked = true;
	document.getElementById("up").checked = true;
	document.getElementById("is").checked = true;
	document.getElementById("orl").checked = true;
	document.getElementById("os").checked = true;
	
}
function withdrawall(){
	document.getElementById("ltds").checked = false;
	document.getElementById("csbso").checked = false;
	document.getElementById("es").checked = false;
	document.getElementById("faa").checked = false;
	document.getElementById("scbsf").checked = false;
	document.getElementById("up").checked = false;
	document.getElementById("is").checked = false;
	document.getElementById("orl").checked = false;
	document.getElementById("os").checked = false;
}

/*
function chkinit(){
	// master entry.
	alert("inside chkinit");
	if (document.getElementById("empMenuMaster").value == "Y")
		document.getElementById("empMenuMaster").checked = true;
	else
		document.getElementById("empMenuMaster").checked = false;
	
	if (document.getElementById("usrMenuPermission").value == "Y")
		document.getElementById("usrMenuPermission").checked = true;
	else
		document.getElementById("usrMenuPermission").checked = false;
	
	if (document.getElementById("dptMenu").value == "Y")
		document.getElementById("dptMenu").checked = true;
	else
		document.getElementById("dptMenu").checked = false;
	
	if (document.getElementById("contractMenu").value == "Y")
		document.getElementById("contractMenu").checked = true;
	else
		document.getElementById("contractMenu").checked = false;
	
	if (document.getElementById("contractGroupMenu").value == "Y")
		document.getElementById("contractGroupMenu").checked = true;
	else
		document.getElementById("contractGroupMenu").checked = false;
	
	if (document.getElementById("locationMenu").value == "Y")
		document.getElementById("locationMenu").checked = true;
	else
		document.getElementById("locationMenu").checked = false;
	
	if (document.getElementById("courierMenu").value == "Y")
		document.getElementById("courierMenu").checked = true;
	else
		document.getElementById("courierMenu").checked = false;
	
	if (document.getElementById("contMstViewMenu").value == "Y")
		document.getElementById("contMstViewMenu").checked = true;
	else
		document.getElementById("contMstViewMenu").checked = false;
	
	if (document.getElementById("courierRateMenu").value == "Y")
		document.getElementById("courierRateMenu").checked = true;
	else
		document.getElementById("courierRateMenu").checked = false;
	
	// out entry.
	if (document.getElementById("outEntryMenu").value == "Y")
		document.getElementById("outEntryMenu").checked = true;
	else
		document.getElementById("outEntryMenu").checked = false;
	
	if (document.getElementById("outEntryDispMenu").value == "Y")
		document.getElementById("outEntryDispMenu").checked = true;
	else
		document.getElementById("outEntryDispMenu").checked = false;
	
	if (document.getElementById("returnEntryModMenu").value == "Y")
		document.getElementById("returnEntryModMenu").checked = true;
	else
		document.getElementById("returnEntryModMenu").checked = false;
	
	if (document.getElementById("returnMenu").value == "Y")
		document.getElementById("returnMenu").checked = true;
	else
		document.getElementById("returnMenu").checked = false;
	
	if (document.getElementById("consignModMenu").value == "Y")
		document.getElementById("consignModMenu").checked = true;
	else{
		document.getElementById("consignModMenu").checked = false;
		alert(document.getElementById("consignModMenu").value);
	}
	// in entry.
	if (document.getElementById("inEntryMenu").value == "Y")
		document.getElementById("inEntryMenu").checked = true;
	else
		document.getElementById("inEntryMenu").checked = false;
	
	if (document.getElementById("courierReturnMenu").value == "Y")
		document.getElementById("courierReturnMenu").checked = true;
	else
		document.getElementById("courierReturnMenu").checked = false;
	
	if (document.getElementById("indAckMenu").value == "Y")
		document.getElementById("indAckMenu").checked = true;
	else
		document.getElementById("indAckMenu").checked = false;
	
	if (document.getElementById("entryAckMenu").value == "Y")
		document.getElementById("entryAckMenu").checked = true;
	else
		document.getElementById("entryAckMenu").checked = false;
	//alert(document.getElementById("entryAckMenu").value);
	// reports.
	if (document.getElementById("incommingRptMenu").value == "Y")
		document.getElementById("incommingRptMenu").checked = true;
	else
		document.getElementById("incommingRptMenu").checked = false;
	
	if (document.getElementById("outSumRptMenu").value == "Y")
		document.getElementById("outSumRptMenu").checked = true;
	else
		document.getElementById("outSumRptMenu").checked = false;
	
	if (document.getElementById("returnRptMenu").value == "Y")
		document.getElementById("returnRptMenu").checked = true;
	else
		document.getElementById("returnRptMenu").checked = false;
	
	if (document.getElementById("outDtlRptMenu").value == "Y")
		document.getElementById("outDtlRptMenu").checked = true;
	else
		document.getElementById("outDtlRptMenu").checked = false;
	
}


function getPermissionDetails(empcd){
	getEmpDetails(empcd);
	btnenable();
	$('#result').jqGrid('GridUnload');
	$('#result').jqGrid({
		mtype: "POST",		
		url:"userPermission.htm?empCode="+empcd+"&_target1=entryDetails",		
		datatype: "json", 
		ajaxGridOptions: { contentType: 'application/json; charset=utf-8' },
		height: "auto",
		colNames:['Srl#','EmpCd','ContractCd','Empl.Master','Menu Permission', 'Dept.Master','Contract Master','Contract Group Master','Location Master','Courier Master','Contract Master View And Print','Courier Rate Master','Out Entry','Out Entry Distribution','Return Entry Modification','Out Entry Return','Unknown Consignment Modification','InEntry And Distribution','Courier Returns','Individual Acknowledgment','InEntry Acknowledgment','Incoming Mail Report','Outgoing Mail Summary Report','Outgoing Mail Return Report','Outgoing Mail Details Report'],
		colModel:[ 
		           {name:'id',index:'id',align:"center"},	// id must be a unique column.
		           {name:'empcd', align:"center"},
		           {name:'contractcd',  align:"center"},
		           {name:'empMenuMaster', align:"center"},
		           {name:'usrMenuPermission', align:"center"},
		           {name:'dptMenu', align:"center"},
		           {name:'contractMenu', align:"center"},
		           {name:'contractGroupMenu', align:"center"},
		           {name:'locationMenu', align:"center"},
		           {name:'courierMenu', align:"center"},
		           {name:'contMstViewMenu', align:"center"},
		           {name:'courierRateMenu', align:"center"},
		           {name:'outEntryMenu', align:"center"},
		           {name:'outEntryDispMenu', align:"center"},
		           {name:'returnEntryModMenu', align:"center"},
		           {name:'returnMenu', align:"center"},
		           {name:'consignModMenu', align:"center"},
		           {name:'inEntryMenu', align:"center"},
		           {name:'courierReturnMenu', align:"Center"},
		           {name:'indAckMenu', align:"center"},
		           {name:'entryAckMenu', align:"center"},
		           {name:'incommingRptMenu', align:"center"},
		           {name:'outSumRptMenu', align:"center"},
		           {name:'returnRptMenu', align:"center"},
		           {name:'outDtlRptMenu', align:"center"}],
		           onSelectRow: function(id){	
		        	      	// next 3 lines also work.
		                  	// var rowData = jQuery(this).getRowData(id); 
		                  	// var temp= rowData['out1'];//replace out1 with your column
		                  	// alert(temp);
		        	   
		        	   	 	var temp=$(this).jqGrid('getLocalRow',id);
		        	   	 	alert(temp.empcd+'-'+temp.contractcd+'--'+temp.out1+'..'+id);
		        	   	 	getModificationData(temp.empcd,temp.contractcd,temp.empMenuMaster,temp.usrMenuPermission,temp.dptMenu,temp.contractMenu,temp.contractGroupMenu,temp.locationMenu,temp.courierMenu,temp.contMstViewMenu,temp.courierRateMenu,temp.outEntryMenu,temp.outEntryDispMenu,temp.returnEntryModMenu,temp.returnMenu,temp.consignModMenu,temp.inEntryMenu,temp.courierReturnMenu,temp.indAckMenu,temp.entryAckMenu,temp.incommingRptMenu,temp.outSumRptMenu,temp.returnRptMenu,temp.outDtlRptMenu);
		                  },
		           rowNum:10,
		           autowidth: true,
		           rowList:[10,15,20,25,30,35,40],
		           gridview: true,
		           pager: '#pager',
		           viewrecords: true,
		           multiselect: false,
		           loadonce: true,
		           caption: "User Permission Details:" ,
		           
		           loadComplete: function () {
		           //    alert("OK");
		           },
		           loadError: function (jqXHR, textStatus, errorThrown) {
		               alert('HTTP status code: ' + jqXHR.status + '\n' +
		                     'textStatus: ' + textStatus + '\n' +
		                     'errorThrown: ' + errorThrown);
		               alert('HTTP message body (jqXHR.responseText): ' + '\n' + jqXHR.responseText);
		           }
		           });
	
	jQuery("#result").jqGrid('navGrid','#pager',{edit:false,add:false,del:false});	
}
*/

/*
function getModificationData(empcd,contractcd,mst1,mst2,mst3,mst4,mst5,mst6,mst7,mst8,mst9,out1,out2,out3,out4,out5,ine1,ine2,ine3,ine4,rtp1,rtp2,rtp3,rtp4){
	btndisable();
	alert(empcd+'-'+contractcd+'--'+out1);
	$.ajax({
		success: function(response){
			 $("#addedContCode").val(contractcd);
			 $("#empMenuMaster").val(mst1);
			 $("#usrMenuPermission").val(mst2);
			 $("#dptMenu").val(mst3);
			 $("#contractMenu").val(mst4);
			 $("#contractGroupMenu").val(mst5);
			 $("#locationMenu").val(mst6);
			 $("#courierMenu").val(mst7);
			 $("#contMstViewMenu").val(mst8);
			 $("#courierRateMenu").val(mst9);
			 $("#outEntryMenu").val(out1);
			 $("#outEntryDispMenu").val(out2);
			 $("#returnEntryModMenu").val(out3);
			 $("#returnMenu").val(out4);
			 $("#consignModMenu").val(out5);
			 $("#inEntryMenu").val(ine1);
			 $("#courierReturnMenu").val(ine2);
			 $("#indAckMenu").val(ine3);
			 $("#entryAckMenu").val(ine4);
			 $("#incommingRptMenu").val(rpt1);
			 $("#outSumRptMenu").val(rpt2);
			 $("#outSumRptMenu").val(rpt3);
			 $("#outDtlRptMenu").val(rpt4);
			 // initialization of check boxes.
			 chkinit();
		},
			
		error: function(e){
			alert('Error: ' + e);
			}
			
	});
}
*/
