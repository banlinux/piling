//function downloadFile(sourceID) {
//	var src = document.getElementById(sourceID);
//	var fd = src.value;
//
//	alert(fd);
//
//	var str = "servlet/DownloadServlet?param1=" + fd;
//	document.location.href = str;
//	return true;
//}

function validateForm(whichPressed) {
	if (whichPressed == "Generate") {
			//
	}
	return true;
}


function getHTTPObject() {
    var http_req = null ;
    
    if (window.XMLHttpRequest) {
        http_req = new XMLHttpRequest() ;
    }
    else if (window.ActiveXObject) {
        try {
            http_req = new ActiveXObject("Msxml2.XMLHTTP") ;
        }
        catch (e) {
            try {
                http_req = new ActiveXObject("Microsoft.XMLHTTP") ;
            }
            catch (e) {}
        }
    }
    if (http_req == null) {
        alert("Hi, your browser is not worth it.") ;
    }
    
    return (http_req) ;
}
function getContractGroupDetails(code, form) {
    var http = getHTTPObject() ;
    if (http != null) {
        var random = Math.random() ;
        http.onreadystatechange = function () { handleHttpResponseContractGroupDetails(http) ; } ;
        http.open("GET", "contractGroupMaster.htm?_target1=contractGroupMaster&unique=" + random + "&form=" + form + "&code=" + code , true) ;
        http.send(null) ;
    }   
	
   }


function handleHttpResponseContractGroupDetails(http_req){

	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
        var contract = document.getElementById('contract') ;
        var selected_contract = document.getElementById('selected_contract') ;
        clearContractGroupDetails();
         if(http_req.status  == 200) {

            	document.forms[0].contract_name.value =xmldoc.getElementsByTagName('contractName')[0].firstChild.nodeValue;  

            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            	selected_contract.options[selected_contract.options.length] = 
                    new Option(xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue) ;
            }
            


            for (i = 0; i < xmldoc.getElementsByTagName('contractNotAssigned').length; i++) {
            	contract.options[contract.options.length] = 
                    new Option(xmldoc.getElementsByTagName('codeNA')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('nameNA')[i].firstChild.nodeValue) ;
            }
            }            
        }

	}
//TO BE IMPLEMENTED 2/1/17
function clearContractGroupDetails() {
	var contract = document.getElementById('contract') ;

    while (contract.options.length)
    	contract.options[0] = null ;
 

}
//

function updateMap(sourceID,destID,value,toDate,fromDate){

    var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.open ("GET", "fixedAssetAddition.htm?_target1=fixedAssetAddition&unique=" + random+"&sourceID="+sourceID+"&destID="+destID+"&zone="+value+"&toDate="+toDate+"&fromDate="+fromDate,true);
        http.send (null) ; 
       
    }
    var http1 = getHTTPObject () ;
    if (http1 != null)
    {
        var random = Math.random () ;
        http1.onreadystatechange = function () { handleHttpUpdateContractMap (http1,sourceID) ; } ;
        http1.open ("GET", "fixedAssetAddition.htm?_target2=fixedAssetAddition&unique=" + random+"&zone="+value+"&toDate="+toDate+"&fromDate="+fromDate,true);
        
        
        http1.send (null) ; 
       
    }    
}
function handleHttpUpdateMap (http_req)
{
	if (http_req.readyState == 4) {
		 if(http_req.status  == 200) {
			 http_req.Close ;
		 }
}
}
function handleHttpUpdateContractMap (http_req,sourceID)
{

	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
        var contract = document.getElementById('contract') ;
      
        var selected_contract = document.getElementById('selected_contract') ;
         if(http_req.status  == 200) {

  //          	document.forms[0].contract.value =xmldoc.getElementsByTagName('contract')[0].firstChild.nodeValue;  
        		if(sourceID=="zone"){
        	//		 clearContractGroupDetails();
            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            /*	contract.options[contract.options.length] = 
                    new Option(xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue) ;*/
            	 var newOption = new Option(xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue,xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue);
                 newOption.ondblclick = function(){ alert(this.text); };
                 contract.options[contract.options.length] = newOption;
            }
         }
        		if(sourceID=="selected_zone"){
        
        			
        		for (i=0;i<xmldoc.getElementsByTagName('contract').length;  i++) {
        			for(j=0;j<contract.options.length;j++){
        				//alert(contract.options[j].value+xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue);	
        			  if (contract.options[j].value.trim()==xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue.trim()) {
        			     contract.remove(j);
        			  }
        		}
        	}
 
        		for (i=0;i<xmldoc.getElementsByTagName('contract').length;  i++) {
        	
        			for(j=0;j<selected_contract.options.length;j++){
        				//alert(selected_contract.options[j].value+xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue);	
        			  if (selected_contract.options[j].value.trim()==xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue.trim()) {
        			     selected_contract.remove(j);
        			  }
        		}
        	}
         }
       }             
	}
}
////////////For Contract if(sourceId=='zone' )

function updateContractMap(sourceID,destID,value,toDate,fromDate){

    var http = getHTTPObject () ;
    if (http != null)
    {
    	//alert(sourceID);
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateMap (http) ; } ;
        http.open ("GET", "fixedAssetAddition.htm?_target3=fixedAssetAddition&unique=" + random+"&sourceID="+sourceID+"&destID="+destID+"&value="+value,true);
        
        http.send (null) ; 
    }

    /*16-Feb-17*/
    if(sourceID=='contract' ){
    var http1 = getHTTPObject () ;
    if (http1 != null)
    {
        var random = Math.random () ;
        
        http1.onreadystatechange = function () { handleHttpUpdateAllocationMap (http1,sourceID) ; } ;
        http1.open ("GET", "fixedAssetAddition.htm?_target31=fixedAssetAddition&unique=" + random+"&contract="+value+"&toDate="+toDate+"&fromDate="+fromDate,true);
        http1.send (null) ; 
       
    }
    }
    if(sourceID=='selected_contract' ){
    	
    	 var http1 = getHTTPObject () ;
    	    if (http1 != null)
    	    {
    	        var random = Math.random () ;
    	        
    	        http1.onreadystatechange = function () { handleHttpRemoveAllocationMap (http1,sourceID) ; } ;
    	        http1.open ("GET", "fixedAssetAddition.htm?_target32=fixedAssetAddition&unique=" + random+"&contract="+value+"&toDate="+toDate+"&fromDate="+fromDate,true);
    	        http1.send (null) ; 
    	       
    	    }
    	

    }
    /*End */
 
}
function updateAllocationMap(sourceID,destID,value){
	 if(sourceID=='allocation' ){
    var http = getHTTPObject () ;
    if (http != null)
    {
  //  	alert(sourceID);
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateMapAllocation (http) ; } ;
        http.open ("GET", "fixedAssetAddition.htm?_target1711=fixedAssetAddition&unique=" + random+"&sourceID="+sourceID+"&destID="+destID+"&value="+value,true);
        
        
        http.send (null) ; 
       
    }
	 }
	 if(sourceID=='selected_allocation' ){
		    var http = getHTTPObject () ;
		    if (http != null)
		    {
		  //  	alert(sourceID);
		        var random = Math.random () ;
		        http.onreadystatechange = function () { handleHttpUpdateMapAllocation (http) ; } ;
		        http.open ("GET", "fixedAssetAddition.htm?_target1811=fixedAssetAddition&unique=" + random+"&sourceID="+sourceID+"&destID="+destID+"&value="+value,true);
		        
		        
		        http.send (null) ; 
		       
		    }
			 }
}
function handleHttpUpdateMapAllocation (http_req)
{
	if (http_req.readyState == 4) {
		 if(http_req.status  == 200) {
			 http_req.Close ;
		 }
}
}
/*16-Feb-17
function handleHttpUpdateAllocationMap (http_req,sourceID)
{
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
        var allocation = document.getElementById('allocation') ;
        var selected_allocation = document.getElementById('selected_allocation') ;
      //  clearContractGroupDetails();
         if(http_req.status  == 200) {
alert(allocation.options.length);
            //	document.forms[0].allocation.value =xmldoc.getElementsByTagName('contractName')[0].firstChild.nodeValue;  

            for (i = 0; i < xmldoc.getElementsByTagName('allocation').length; i++) {
            	allocation.options[allocation.options.length] = 
                    new Option(xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue, 
                    		xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue) ;
            }
            }            
        }
	}
	*/

function handleHttpRemoveAllocationMap (http_req,sourceID)
{
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
    
	for (i=0;i<xmldoc.getElementsByTagName('allocation').length;  i++) {
		for(j=0;j<allocation.options.length;j++){
			
		//	alert(selected_contract.options[j].value+xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue);	
		  if (allocation.options[j].value.trim()==xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue.trim()) {
			  
			  allocation.remove(j);
		  }
		}
		}
	}
}

/*End */

function getGroupDetails(categoryCode){
	$.ajax({
		type: "POST",
		url: "index.htm",
		data: "categoryCode="+categoryCode+"&_target5=group",
		success: function(response){
		var data=	$.parseJSON(response);
		
		 var html = '<option value="0">--Select Group--</option>';
         var len = data.length;
             for ( var i = 0; i < len; i++) {
                 html += '<option value="' + data[i].groupCode + '">'+"("+data[i].groupCode+')'+ data[i].groupName+ '</option>';
             }
             html += '</option>';
             $('#groupCode').html(html);
			 
		},
		error: function(e){
			alert('Error: ' + e);
			}
			
	});
	
}
function getMajorDetails(groupCode,category){
	$.ajax({
		type: "POST",
		url: "index.htm",
		data: "category="+category+"&groupCode="+groupCode+"&_target6=major",
		success: function(response){
		var data=	$.parseJSON(response);
		
		 var html = '<option value="0">--Select Major--</option>';
         var len = data.length;
             for ( var i = 0; i < len; i++) {
                 html += '<option value="' + data[i].majorCode + '">'+"("+data[i].majorCode+')'+ data[i].majorName+ '</option>';
             }
             html += '</option>';
             $('#majorCode').html(html);
			 
		},
		error: function(e){
			alert('Error: ' + e);
			}
			
	});
	
}
function getMinorDetails(majorCode,category,group){

	$.ajax({
		type: "POST",
		url: "index.htm",
		data: "category="+category+"&groupCode="+group+"&majorCode="+majorCode+"&_target7=major",
		success: function(response){
		var data=	$.parseJSON(response);
		
		var html = '<option value="0">--Select Minor--</option>';
         var len = data.length;
             for ( var i = 0; i < len; i++) {
                 html += '<option value="' + data[i].minorCode + '">'+"("+data[i].minorCode+')'+ data[i].minorName+ '</option>';
             }
             html += '</option>';
             $('#minorCode').html(html);
			 
		},
		error: function(e){
			alert('Error: ' + e);
			}
			
	});
	
}

function getSupplierDetails(fromDate,toDate){
	$.ajax({
		type: "POST",
		url: "index.htm",
		data: "fromDate="+fromDate+"&toDate="+toDate+"&_target8=major",
		success: function(response){
		var data=	$.parseJSON(response);
		
		var html = '<option value="0">--Select Supplier--</option>';
         var len = data.length;
             for ( var i = 0; i < len; i++) {
                 html += '<option value="' + data[i].supplierCode + '">'+"("+data[i].supplierCode+')'+ data[i].supplierName+ '</option>';
             }
             html += '</option>';
             $('#supplierCode').html(html);
			 
		},
		error: function(e){
			alert('Error: ' + e);
			}
			
	});
}

function getItemDetails(supplier,category,group,major,minor,fromDate,toDate){

	$.ajax({
		type: "POST",
		url: "index.htm",
		data: "supplier="+supplier+"&category="+category+"&group="+group+"&major="+major+"&minor="+minor+"&fromDate="+fromDate+"&toDate="+toDate+"&_target9=major",
		success: function(response){
		var data=	$.parseJSON(response);
		
		var html = '<option value="0">--Select Item--</option>';
         var len = data.length;
             for ( var i = 0; i < len; i++) {
                 html += '<option value="' + data[i].itemCode + '">'+"("+data[i].itemCode+')'+ data[i].itemName+ '</option>';
             }
             html += '</option>';
             $('#itemCode').html(html);
			 
		},
		error: function(e){
			alert('Error: ' + e);
			}
			
	});
}

/////////////////// For moving all in map   /////////////////////////
function listbox_moveacrossAll(sourceId,destinationId){
	
	if(sourceId=='zone' ){
		var http = getHTTPObject () ;
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpUpdateZoneMapAll (http) ; } ;
	        http.open ("GET", "fixedAssetAddition.htm?_target15=purchaseRegister&unique=" + random,true);
	        
	        
	        http.send (null) ; 
	       
	    }
	
	}

	if(sourceId=='selected_zone'){
		var http = getHTTPObject () ;
	//	alert(sourceId);
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpRemoveZoneMapAll (http) ; } ;
	        http.open ("GET", "fixedAssetAddition.htm?_target16=purchaseRegister&unique=" + random,true);
	        
	        
	        http.send (null) ; 
	       
	    }
    
	}
	
	if(sourceId=='contract' ){
		var toDate=document.getElementById('toDate').value;
		var fromDate=document.getElementById('fromDate').value;
		var http = getHTTPObject () ;
	//	alert(sourceId);
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpUpdateContractMapAll (http) ; } ;
	        http.open ("GET", "fixedAssetAddition.htm?_target17=purchaseRegister&unique=" + random+"&toDate="+toDate+"&fromDate="+fromDate,true);
	        
	        
	        http.send (null) ; 
	       
	    }
	    var http1 = getHTTPObject () ;
			
		    if (http1 != null)
		    {
		    	//alert(sourceId);
		        var random = Math.random () ;
		        http1.onreadystatechange = function () { handleHttpUpdateAllocationMap (http1) ; } ;
		        http1.open ("GET", "fixedAssetAddition.htm?_target171=purchaseRegister&unique=" + random+"&toDate="+toDate+"&fromDate="+fromDate,true);
		        
		        
		        http1.send (null) ; 
		       
		    }
	
	}

	if(sourceId=='selected_contract'){
		var http = getHTTPObject () ;
		var toDate=document.getElementById('toDate').value;
		var fromDate=document.getElementById('fromDate').value;
	//	alert(sourceId);
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpRemoveContractMapAll (http) ; } ;
	        http.open ("GET", "fixedAssetAddition.htm?_target18=purchaseRegister&unique=" + random+"&toDate="+toDate+"&fromDate="+fromDate,true);
	        
	        
	        http.send (null) ; 
	       
	    }
	    var http1 = getHTTPObject () ;
		
	    if (http1 != null)
	    {
	    	//alert(sourceId);
	        var random = Math.random () ;
	        http1.onreadystatechange = function () { handleHttpRemoveAllocationMapAll (http1) ; } ;
	        http1.open ("GET", "fixedAssetAddition.htm?_target181=purchaseRegister&unique=" + random+"&toDate="+toDate+"&fromDate="+fromDate,true);
	        
	        
	        http1.send (null) ; 
	       
	    }
    
	}
	if(sourceId=='allocation' ){
		var http = getHTTPObject () ;
		var toDate=document.getElementById('toDate').value;
		var fromDate=document.getElementById('fromDate').value;
	//	alert(sourceId);
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpUpdateAllocationMapAll (http,sourceId) ; } ;
	        http.open ("GET", "fixedAssetAddition.htm?_target1000=purchaseRegister&unique=" + random+"&toDate="+toDate+"&fromDate="+fromDate,true);
	        
	        
	        http.send (null) ; 
	       
	    }
	}
	if(sourceId=='selected_allocation' ){
		var http = getHTTPObject () ;
		var toDate=document.getElementById('toDate').value;
		var fromDate=document.getElementById('fromDate').value;
	//	alert(sourceId);
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpUpdateAllocationMapAll (http,sourceId) ; } ;
	        http.open ("GET", "fixedAssetAddition.htm?_target1001=purchaseRegister&unique=" + random+"&toDate="+toDate+"&fromDate="+fromDate,true);
	        
	        
	        http.send (null) ; 
	       
	    }
	}
	
}
function handleHttpUpdateZoneMapAll (http_req)
{
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
        var zone = document.getElementById('zone') ;
        var selected_zone = document.getElementById('selected_zone') ;
        clearZoneGroupDetails();
        clearSelectedContractGroupDetails();
           if(http_req.status  == 200) {

          //  	document.forms[0].contract_name.value =xmldoc.getElementsByTagName('contractName')[0].firstChild.nodeValue;  

            for (i = 0; i < xmldoc.getElementsByTagName('zone').length; i++) {
            	selected_zone.options[selected_zone.options.length] = 
                    new Option(xmldoc.getElementsByTagName('ZName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('ZCode')[i].firstChild.nodeValue) ;
            }
            
            var contract = document.getElementById('contract') ;

            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            	contract.options[contract.options.length] = 
                    new Option(xmldoc.getElementsByTagName('CName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue) ;
            }
            }            
        }	
}

function clearZoneGroupDetails() {
	var zone = document.getElementById('zone') ;

    while (zone.options.length)
    	zone.options[0] = null ;


}
function  clearSelectedContractGroupDetails(){
	var selected_contract = document.getElementById('selected_contract') ;

    while (selected_contract.options.length)
    	selected_contract.options[0] = null ;
}

function handleHttpRemoveZoneMapAll (http_req)
{
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
        var zone = document.getElementById('zone') ;
        var selected_zone = document.getElementById('selected_zone') ;
        clearSelectedZoneGroupDetails();
        clearContractGroupDetails();
        clearSelectedContractGroupDetails();
        clearZoneGroupDetails();
           if(http_req.status  == 200) {

  
            for (i = 0; i < xmldoc.getElementsByTagName('zone').length; i++) {
            	zone.options[zone.options.length] = 
                    new Option(xmldoc.getElementsByTagName('ZName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('ZCode')[i].firstChild.nodeValue) ;
            }
            

            }            
        }		
}
function clearContractGroupDetails(){
	var contract = document.getElementById('contract') ;

    while (contract.options.length)
    	contract.options[0] = null ;
}
function clearSelectedContractGroupDetails(){
	var selected_contract = document.getElementById('selected_contract') ;

    while (selected_contract.options.length)
    	selected_contract.options[0] = null ;
}
function clearSelectedZoneGroupDetails(){
	var selected_zone= document.getElementById('selected_zone') ;

    while (selected_zone.options.length)
    	selected_zone.options[0] = null ;
}
function handleHttpUpdateContractMapAll(http_req){
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
       
        clearSelectedContractGroupDetails();
        clearContractGroupDetails();
           if(http_req.status  == 200) {

          //  	document.forms[0].contract_name.value =xmldoc.getElementsByTagName('contractName')[0].firstChild.nodeValue;  

        	   var selected_contract = document.getElementById('selected_contract') ;


            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            /*	selected_contract.options[selected_contract.options.length] = 
                    new Option(xmldoc.getElementsByTagName('CName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue) ;*/
            	 var newOption = new Option(xmldoc.getElementsByTagName('CName')[i].firstChild.nodeValue,xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue);
                 newOption.ondblclick = function(){ alert(this.text); };
                 selected_contract.options[selected_contract.options.length] = newOption;
            }
            }            
        }		
}
function handleHttpUpdateAllocationMap(http_req){
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
     
        clearSelectedAllocationGroupDetails();
     //   clearAllocationGroupDetails();
           if(http_req.status  == 200) {

          //  	document.forms[0].contract_name.value =xmldoc.getElementsByTagName('contractName')[0].firstChild.nodeValue;  

        	   var allocation = document.getElementById('allocation') ;


            for (i = 0; i < xmldoc.getElementsByTagName('allocation').length; i++) {
            	allocation.options[allocation.options.length] = 
                    new Option(xmldoc.getElementsByTagName('AName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('ACode')[i].firstChild.nodeValue) ;
            }
            }            
        }		
}
function  clearSelectedAllocationGroupDetails(){
	var selected_allocation = document.getElementById('selected_allocation') ;

    while (selected_allocation.options.length)
    	selected_allocation.options[0] = null ;
}
function clearAllocationGroupDetails() {
	var allocation = document.getElementById('allocation') ;

    while (allocation.options.length)
    	allocation.options[0] = null ;
 

}
function handleHttpRemoveContractMapAll(http_req){
	   var selected_contract = document.getElementById('selected_contract') ;
	   var contract = document.getElementById('contract') ;
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
       
        clearSelectedContractGroupDetails();
        clearContractGroupDetails();
        
           if(http_req.status  == 200) {

          //  	document.forms[0].contract_name.value =xmldoc.getElementsByTagName('contractName')[0].firstChild.nodeValue;  



            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            /*	contract.options[contract.options.length] = 
                    new Option(xmldoc.getElementsByTagName('CName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue) ;*/
            	 var newOption = new Option(xmldoc.getElementsByTagName('CName')[i].firstChild.nodeValue,xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue);
                 newOption.ondblclick = function(){ alert(this.text); };
                 contract.options[contract.options.length] = newOption;
            }
            }            
        }
	

    while (selected_contract.options.length)
    	selected_contract.options[0] = null ;
}
function handleHttpRemoveAllocationMapAll(http_req){
	   var selected_allocation = document.getElementById('selected_allocation') ;
	   var allocation = document.getElementById('allocation') ;
	if (http_req.readyState == 4) {
     var xmldoc = http_req.responseXML ;
    
     clearSelectedAllocationGroupDetails();
     clearAllocationGroupDetails();
     
        if(http_req.status  == 200) {

       //  	document.forms[0].contract_name.value =xmldoc.getElementsByTagName('contractName')[0].firstChild.nodeValue;  


/*
         for (i = 0; i < xmldoc.getElementsByTagName('allocation').length; i++) {
         	allocation.options[contract.options.length] = 
                 new Option(xmldoc.getElementsByTagName('AName')[i].firstChild.nodeValue, 
             xmldoc.getElementsByTagName('ACode')[i].firstChild.nodeValue) ;
         }
         */
         }            
     }
	

 while (selected_allocation.options.length)
 	selected_allocation.options[0] = null ;
}
function searchInfo(){
	var toDate=document.getElementById('toDate').value;
	var fromDate=document.getElementById('fromDate').value;
	var searchContract = document.forms[0].contractSearch.value;

	if(searchContract.length > 2)
		{
		var http = getHTTPObject () ;
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpSearchContract (http) ; } ;
	        http.open ("GET", "fixedAssetAddition.htm?_target155=purchaseRegister&unique=" + random+"&toDate="+toDate+"&fromDate="+fromDate+"&searchContract="+searchContract,true);
	        
	        
	        http.send (null) ; 
	       
	    }
		}
	/*else if(searchContract.length = 0)
		var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
     //   http.onreadystatechange = function () { handleHttpSearchContract (http) ; } ;
    //    http.open ("GET", "fixedAssetAddition.htm?_target155=purchaseRegister&unique=" + random+"&toDate="+toDate+"&fromDate="+fromDate+"&searchContract="+searchContract,true);
        http.onreadystatechange = function () { handleHttpUpdateAllocationMap (http,'contract') ; } ;
        http.open ("GET", "fixedAssetAddition.htm?_target31=fixedAssetAddition&unique=" + random+"&contract="+searchContract+"&toDate="+toDate+"&fromDate="+fromDate,true);
        
        http.send (null) ; 
       
    }*/
}
function handleHttpSearchContract(http_req){
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
       
     //   clearSelectedContractGroupDetails();
        clearContractGroupDetails();
           if(http_req.status  == 200) {

           	   var contract = document.getElementById('contract') ;

            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            	contract.options[contract.options.length] = 
                    new Option(xmldoc.getElementsByTagName('CName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue) ;
            }
            }            
        }
}
function handleHttpUpdateAllocationMapAll(http_req,sourceId){
	if(sourceId=='allocation'){
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
       
        clearSelectedAllocationGroupDetails();
        clearAllocationGroupDetails();
           if(http_req.status  == 200) {

          //  	document.forms[0].contract_name.value =xmldoc.getElementsByTagName('contractName')[0].firstChild.nodeValue;  

        	   var selected_allocation = document.getElementById('selected_allocation') ;


            for (i = 0; i < xmldoc.getElementsByTagName('allocation').length; i++) {
            	selected_allocation.options[selected_allocation.options.length] = 
                    new Option(xmldoc.getElementsByTagName('AName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('ACode')[i].firstChild.nodeValue) ;
            }
            }            
        }
}
	if(sourceId=='selected_allocation'){
		if (http_req.readyState == 4) {
	        var xmldoc = http_req.responseXML ;
	       
	        clearSelectedAllocationGroupDetails();
	        clearAllocationGroupDetails();
	           if(http_req.status  == 200) {

	          //  	document.forms[0].contract_name.value =xmldoc.getElementsByTagName('contractName')[0].firstChild.nodeValue;  

	        	   var selected_allocation = document.getElementById('selected_allocation') ;
	        	   var allocation = document.getElementById('allocation') ;

	            for (i = 0; i < xmldoc.getElementsByTagName('allocation').length; i++) {
	            	allocation.options[allocation.options.length] = 
	                    new Option(xmldoc.getElementsByTagName('AName')[i].firstChild.nodeValue, 
	                xmldoc.getElementsByTagName('ACode')[i].firstChild.nodeValue) ;
	            }
	            }
	           while (selected_allocation.options.length){
	        	 	selected_allocation.options[0] = null ;
	        	}
	        }
	}
}