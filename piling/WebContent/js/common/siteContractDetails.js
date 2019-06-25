/**
 * 
 */

function getSiteDeatils(){
	
	var http = getHTTPObject();

	if (http != null) {
		var random = Math.random();
		http.onreadystatechange = function() {
			handleHttpResponseSiteDetails(http);
		};
		http.open("GET", "siteDetails.htm?random=" + random, true);
		http.send(null);
	}
	
}

function handleHttpResponseSiteDetails(http_req) {
	if (http_req.readyState == 4) {

		var xmldoc = http_req.responseXML;
		var site = document.getElementById('site_no');
		clearDropDown(site);
		if (http_req.status == 200) {
			site.options[site.options.length] = new Option(
					"--Select--", "0");
			for (i = 0; i < xmldoc.getElementsByTagName('roottag').length; i++) {
				site.options[site.options.length] = new Option(
						xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue,
						xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue);
			}
		} else
			site.options[site.options.length] = new Option("Error");
	}
	http_req.Close;
}

function getContractDeatils(siteNo){
	
	var http = getHTTPObject();

	if (http != null) {
		var random = Math.random();
		http.onreadystatechange = function() {
			handleHttpResponseContractDetails(http);
		};
		http.open("GET", "contractDetails.htm?random=" + random + "&siteNo="
				+ siteNo, true);
		http.send(null);
	}
	
}

function handleHttpResponseContractDetails(http_req) {
	if (http_req.readyState == 4) {

		var xmldoc = http_req.responseXML;
		var contract = document.getElementById('contract_no');
		clearDropDown(contract);
		if (http_req.status == 200) {
			contract.options[contract.options.length] = new Option(
					"--Select--", "0");
			for (i = 0; i < xmldoc.getElementsByTagName('roottag').length; i++) {
				contract.options[contract.options.length] = new Option(
						xmldoc.getElementsByTagName('name')[i].firstChild.nodeValue,
						xmldoc.getElementsByTagName('code')[i].firstChild.nodeValue);
			}
		} else
			contract.options[contract.options.length] = new Option("Error");
	}
	http_req.Close;
}