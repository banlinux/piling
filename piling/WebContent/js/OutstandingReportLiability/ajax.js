function downloadFile(sourceID) {
	var src = document.getElementById(sourceID);
	var fd = src.value;

	alert(fd);

	var str = "servlet/DownloadORLServlet?param1=" + fd;
	document.location.href = str;
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

function updateMap(sourceID,destID,value,toDate){ //09/03
    var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.open ("GET", "outstandingreportLiability.htm?_target1=consolidatedSchedule&unique=" + random+"&sourceID="+sourceID+"&destID="+destID+"&zone="+value+"&toDate="+toDate,true); //09/03
        http.send (null) ; 
    }
    var http1 = getHTTPObject () ;
    if (http1 != null)
    {
        var random = Math.random () ;
        http1.onreadystatechange = function () { handleHttpUpdateContractMap (http1,sourceID) ; } ;
        http1.open ("GET", "outstandingreportLiability.htm?_target2=consolidatedSchedule&unique=" + random+"&zone="+value+"&toDate="+toDate,true);  //09/03
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
        		if(sourceID=="zone"){
            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            	 var code = xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue;
                 var newOption = new Option(xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue,xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue);
                          newOption.ondblclick = function(){ alert(this.text); };
                          contract.options[contract.options.length] = newOption;
            }
         }
        		if(sourceID=="selected_zone"){
        		for (i=0;i<xmldoc.getElementsByTagName('contract').length;  i++) {
        			for(j=0;j<contract.options.length;j++){
        			  if (contract.options[j].value.trim()==xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue.trim()) {
        			     contract.remove(j);
        			  }
        		}
        	}
        		for (i=0;i<xmldoc.getElementsByTagName('contract').length;  i++) {
        			for(j=0;j<selected_contract.options.length;j++){
        			  if (selected_contract.options[j].value.trim()==xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue.trim()) {
        			     selected_contract.remove(j);
        			  }
        		}
        	}
         }
        }             
	}
}

function updateContractMap(sourceID,destID,value,toDate,fromDate){
    var http = getHTTPObject () ;
    if (http != null)
    {
  //  	alert(sourceID);
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateMap (http) ; } ;
        http.open ("GET", "outstandingreportLiability.htm?_target3=consolidatedSchedule&unique=" + random+"&sourceID="+sourceID+"&destID="+destID+"&value="+value,true);
        http.send (null) ; 
    }
}

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
	        http.open ("GET", "outstandingreportLiability.htm?_target15=consolidatedSchedule&unique=" + random,true);
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
	        http.open ("GET", "outstandingreportLiability.htm?_target16=consolidatedSchedule&unique=" + random,true);
	        http.send (null) ; 
	    }
	}
	if(sourceId=='contract' ){
		var toDate=document.getElementById('toDate').value;
		var http = getHTTPObject () ;
	//	alert(sourceId);
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpUpdateContractMapAll (http) ; } ;
	        http.open ("GET", "outstandingreportLiability.htm?_target17=consolidatedSchedule&unique=" + random+"&toDate="+toDate,true);  //09/03
	        http.send (null) ; 
	    }
	}
	if(sourceId=='selected_contract'){
		var http = getHTTPObject () ;
		var toDate=document.getElementById('toDate').value;
	//	alert(sourceId);
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpRemoveContractMapAll (http) ; } ;
	        http.open ("GET", "outstandingreportLiability.htm?_target18=consolidatedSchedule&unique=" + random+"&toDate="+toDate,true);//09/03
	        http.send (null) ; 
	    }
	}
	if(sourceId=='supplier'){
		  var radioButtons = document.getElementsByName("supplierRadio");
		  for (var x = 0; x < radioButtons.length; x ++) {
		        if (radioButtons[x].checked) {
		            var radioValue = radioButtons[x].value
		        }
		         if(radioValue = 'name'){
		        		if(document.getElementById('supplierName').value.length > 2){
		        			var name=document.getElementById('supplierName').value;
		        			populareSupplierOnNameDoubleClick(name,sourceId);
		        	}
		         }
		         if(radioValue = 'code'){
		        	 if(document.getElementById('fromCode').value.length > 3  && document.getElementById('toCode').value.length > 3){
		        			var fromCode=document.getElementById('fromCode').value;
		        			var toCode=document.getElementById('toCode').value;
		        			populateSupplierOnCodeDoubleClick(fromCode,toCode,sourceId);
		              }
		         }
	     }
	}
	if(sourceId=='selected_supplier'){
		  var radioButtons = document.getElementsByName("supplierRadio");
		  for (var x = 0; x < radioButtons.length; x ++) {
		        if (radioButtons[x].checked) {
		            var radioValue = radioButtons[x].value
		        }
		         if(radioValue = 'name'){
		        		if(document.getElementById('supplierName').value.length > 2){
		        			var name=document.getElementById('supplierName').value;
		        			populareSupplierOnNameDoubleClick(name,sourceId);
		        	}
		         }
		         if(radioValue = 'code'){
		        	 if(document.getElementById('fromCode').value.length > 3  && document.getElementById('toCode').value.length > 3){
		        			var fromCode=document.getElementById('fromCode').value;
		        			var toCode=document.getElementById('toCode').value;
		        			populateSupplierOnCodeDoubleClick(fromCode,toCode,sourceId);
		              }
		         }
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
        	   var selected_contract = document.getElementById('selected_contract') ;
            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            	selected_contract.options[selected_contract.options.length] = 
                    new Option(xmldoc.getElementsByTagName('CName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue) ;
            }
            }            
        }		
}

function handleHttpRemoveContractMapAll(http_req){
	   var selected_contract = document.getElementById('selected_contract') ;
	   var contract = document.getElementById('contract') ;
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
        clearSelectedContractGroupDetails();
        clearContractGroupDetails();
           if(http_req.status  == 200) {
            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            	contract.options[contract.options.length] = 
                    new Option(xmldoc.getElementsByTagName('CName')[i].firstChild.nodeValue, 
                xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue) ;
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
         }            
     }
	while (selected_allocation.options.length)
 	selected_allocation.options[0] = null ;
}


function searchInfo(){
	var toDate=document.getElementById('toDate').value;
	var searchContract = document.forms[0].contractSearch.value;  //09/03
	if(searchContract.length >= 0)
		{
		var http = getHTTPObject () ;
	    if (http != null)
	    {
	        var random = Math.random () ;
	        http.onreadystatechange = function () { handleHttpSearchContract (http,searchContract) ; } ;
	        http.open ("GET", "outstandingreportLiability.htm?_target155=consolidatedSchedule&unique=" + random+"&toDate="+toDate+"&searchContract="+searchContract,true); //09/03
	        http.send (null) ; 
	    }
		}
}

function supplierSearchInfo(){
	  var radioButtons = document.getElementsByName("supplierRadio");
	  var supplierSearch = document.forms[0].supplierSearch.value;  //09/03
	  for (var x = 0; x < radioButtons.length; x ++) {
	        if (radioButtons[x].checked) {
	            var radioValue = radioButtons[x].value
	        }
	         if(radioValue = 'name'){
	        		if(document.getElementById('supplierName').value.length > 2){
	        			var name=document.getElementById('supplierName').value;
	        			populareSupplierOnNameSearch(name,supplierSearch);
	        	}
	         }
	         if(radioValue = 'code'){
	        	 if(document.getElementById('fromCode').value.length > 3  && document.getElementById('toCode').value.length > 3){
	        			var fromCode=document.getElementById('fromCode').value;
	        			var toCode=document.getElementById('toCode').value;
	        			populateSupplierOnCodeSearch(fromCode,toCode,supplierSearch);
	              }
	         }
     }
}

//09/03
function handleHttpSearchContract(http_req,searchContract){
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
        clearContractGroupDetails();
           if(http_req.status  == 200) {

           	   var contract = document.getElementById('contract') ;

            for (i = 0; i < xmldoc.getElementsByTagName('contract').length; i++) {
            	 var code = xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue;
                 var newOption = new Option(xmldoc.getElementsByTagName('CName')[i].firstChild.nodeValue,xmldoc.getElementsByTagName('CCode')[i].firstChild.nodeValue);
                          newOption.ondblclick = function(){ alert(this.text); };
                          if(searchContract==code){
                        	  newOption.setAttribute("selected", "selected");
                          }
                          contract.options[contract.options.length] = newOption;
            }
            }            
        }
}

//09/03
function populareSupplierOnName(name){
	var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateSupplierMap(http) ; } ;
        http.open ("GET", "outstandingreportLiability.htm?_target4=consolidatedSchedule&unique=" + random+"&name="+name,true);
        http.send (null) ; 
	}
}

function handleHttpUpdateSupplierMap(http_req){
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
  //      clearSelectedSupplierDetails();
        clearSupplierGroupDetails();
           if(http_req.status  == 200) {

           	   var supplier = document.getElementById('supplier') ;

            for (i = 0; i < xmldoc.getElementsByTagName('supplier').length; i++) {
          	
            	 var code = xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue;
                 var newOption = new Option(xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue+":"+xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue,xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue);
                          newOption.ondblclick = function(){ alert(this.text); };
                          supplier.options[supplier.options.length] = newOption;
            }
            }            
        }
}

function populateSupplierOnCode(fromCode,toCode){
	var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateSupplierMap(http) ; } ;
        http.open ("GET", "outstandingreportLiability.htm?_target5=consolidatedSchedule&unique=" + random+"&fromCode="+fromCode+"&toCode="+toCode,true);
        http.send (null) ; 
	}
}

function clearSupplierGroupDetails(){
	var supplier = document.getElementById('supplier') ;

    while (supplier.options.length)
    	supplier.options[0] = null ;
}

function clearSelectedSupplierDetails(){
	var selected_supplier = document.getElementById('selected_supplier') ;

    while (selected_supplier.options.length)
    	selected_supplier.options[0] = null ;
}

function updateSupplierMap(sourceID,destID,value){

    var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateMap (http) ; } ;
        http.open ("GET", "outstandingreportLiability.htm?_target6=consolidatedSchedule&unique=" + random+"&sourceID="+sourceID+"&destID="+destID+"&value="+value,true);
        http.send (null) ; 
    }
}

function populareSupplierOnNameDoubleClick(name,sourceId){
	var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateSupplierMapDoubleClick(http,sourceId) ; } ;
        if(sourceId=='supplier'){
        http.open ("GET", "outstandingreportLiability.htm?_target7=consolidatedSchedule&unique=" + random+"&name="+name,true);
        }
        else if(sourceId=='selected_supplier'){
        	 http.open ("GET", "outstandingreportLiability.htm?_target4=consolidatedSchedule&unique=" + random+"&name="+name,true);
        }
        http.send (null) ; 
	}
}

function handleHttpUpdateSupplierMapDoubleClick(http_req,sourceId){

	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
       
        clearSelectedSupplierDetails();
        clearSupplierGroupDetails();
           if(http_req.status  == 200) {
        	   if(sourceId=='supplier'){
           	   var supplier = document.getElementById('selected_supplier') ;
        	   }
        	   else if(sourceId=='selected_supplier'){
           	   var supplier = document.getElementById('supplier') ;
        	   }
            for (i = 0; i < xmldoc.getElementsByTagName('supplier').length; i++) {
            	 var code = xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue;
                 var newOption = new Option(xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue+":"+xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue,xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue);
                          newOption.ondblclick = function(){ alert(this.text); };
                          supplier.options[supplier.options.length] = newOption;
            }
            }            
        }
}

function populateSupplierOnCodeDoubleClick(fromCode,toCode,sourceId){
	var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateSupplierMapDoubleClick(http,sourceId) ; } ;
        if(sourceId=='supplier'){
        http.open ("GET", "outstandingreportLiability.htm?_target8=consolidatedSchedule&unique=" + random+"&fromCode="+fromCode+"&toCode="+toCode,true);
        }
        else if(sourceId=='selected_supplier'){
        	 http.open ("GET", "outstandingreportLiability.htm?_target5=consolidatedSchedule&unique=" + random+"&fromCode="+fromCode+"&toCode="+toCode,true);
        }
        http.send (null) ; 
	}
}

function handleHttpUpdateSupplierMapDoubleClick(http_req,sourceId){
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
        clearSelectedSupplierDetails();
        clearSupplierGroupDetails();
           if(http_req.status  == 200) {
        	   if(sourceId=='supplier'){
           	   var supplier = document.getElementById('selected_supplier') ;
        	   }
        	   else if(sourceId=='selected_supplier'){
               	   var supplier = document.getElementById('supplier') ;
            	   }
            for (i = 0; i < xmldoc.getElementsByTagName('supplier').length; i++) {
            	 var code = xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue;
                 var newOption = new Option(xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue+":"+xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue,xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue);
                          newOption.ondblclick = function(){ alert(this.text); };
                          supplier.options[supplier.options.length] = newOption;
            }
            }            
        }
}

function populareSupplierOnNameSearch(name,supplierSearch){
	var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateSupplierMapSearch(http,supplierSearch) ; } ;
        http.open ("GET", "outstandingreportLiability.htm?_target20=consolidatedSchedule&unique=" + random+"&name="+name+"&supplierSearch="+supplierSearch,true);
        http.send (null) ; 
	}
}

function handleHttpUpdateSupplierMapSearch(http_req,supplierSearch){
	if (http_req.readyState == 4) {
        var xmldoc = http_req.responseXML ;
        clearSupplierGroupDetails();
           if(http_req.status  == 200) {
           	   var supplier = document.getElementById('supplier') ;
            for (i = 0; i < xmldoc.getElementsByTagName('supplier').length; i++) {
            	 var code = xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue;
                 var newOption = new Option(xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue+":"+xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue,xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue);
                          newOption.ondblclick = function(){ alert(this.text); };
                          if(supplierSearch==xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue){
                        	  newOption.setAttribute("selected", "selected");  
                          }
                          supplier.options[supplier.options.length] = newOption;
            }
            }            
        }
}

function populateSupplierOnCodeSearch(fromCode,toCode,supplierSearch){
	var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpUpdateSupplierMap(http) ; } ;
        http.open ("GET", "outstandingreportLiability.htm?_target21=consolidatedSchedule&unique=" + random+"&fromCode="+fromCode+"&toCode="+toCode+"&supplierSearch="+supplierSearch,true);
        http.send (null) ; 
	}
}

function locateContractInfo(){
	 var contract = document.getElementById('contract') ;
	 for (i = 0; i < contract.options.length; i++) {
		 if(document.getElementById('locateContract').value==contract.options[i].value){
         contract.options[i].selected=true;
		 }
	 }
}

function listbox_moveacrossAllSuppType(sourceID, destID)
{
	var src = document.getElementById(sourceID);
	var dest = document.getElementById(destID);
	for (var count = 0; count < src.options.length; count++) {
		var option = src.options[count];
		var newOption = document.createElement("option");
		newOption.value = option.value;
		newOption.text = option.text;
		newOption.selected = true;
		try {
			dest.add(newOption, null);
			src.remove(count, null);
		} catch (error) {
			dest.add(newOption);
			src.remove(count);
		}
		count--;
	}
	// ------ Populate Contract Description Map of selected contract.
	if (sourceID=='contract' || sourceID=='selected_contract')
		populateContract(sourceID, destID, src, dest);
	else
		populateSuppType(sourceID, destID, src, dest);
}

function populateContract(sourceID, destID, src, dest) {
	// ------ Populate selectected contract Map of selected supplier types.
	var contractAll = "";
	
	if (sourceID == 'contract') {
		for (var count = 0; count < dest.options.length; count++) {
			contractAll += "'" + dest.options[count].value + "',";
		}
	} else {
		for (var count = 0; count < src.options.length; count++) {
			contractAll += "'" + src.options[count].value + "',";
		}
	}
	//alert(supplierTypeAll);
	if (contractAll != "") {
		contractAll = supplierTypeAll.substring(0, contractAll.length - 1);
		//alert(supplierTypeAll);
		$.ajax({
			type : "POST",
			url : "outstandingreportLiability.htm",
			data : "contractAll =" + contractAll + "&_target10=contract",
			success : function(response) {
				var data = $.parseJSON(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		}); // End of data fetching.
	} 
}


function populateSuppType(sourceID, destID, src, dest) {
	// ------ Populate Supplier Type Map of selected supplier types.
	var supplierTypeAll = "";
	
	if (sourceID == 'supplierType') {
		for (var count = 0; count < dest.options.length; count++) {
			supplierTypeAll += "'" + dest.options[count].value + "',";
		}
	} else {
		for (var count = 0; count < src.options.length; count++) {
			supplierTypeAll += "'" + src.options[count].value + "',";
		}
	}
	
	//alert(supplierTypeAll);
	
	if (supplierTypeAll != "") {
		supplierTypeAll = supplierTypeAll.substring(0,
				supplierTypeAll.length - 1);

		//alert(supplierTypeAll);
		 
		$.ajax({
			type : "POST",
			url : "outstandingreportLiability.htm",
			data : "supplierType=" + supplierTypeAll + "&_target9=suppliertype",
			success : function(response) {
				var data = $.parseJSON(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		}); // End of data fetching.
	} 
}
