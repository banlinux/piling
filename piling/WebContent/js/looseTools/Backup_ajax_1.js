function findCont()
{
	var cont=document.getElementById("findContractCode").value;
	var e = document.getElementById("contract");  // contains contract list
	var len = $("#contract option").length;
	
	for(var i=0; i<len; i++) {
	  if ( e.options[i].value == cont ) {
		e.selectedIndex = i;
	    break;
	  }
	}
}

function findSch()
{
	var sch=document.getElementById("findScheduleCode").value;
	var e = document.getElementById("schedule");  // contains schedule list
	var len = $("#schedule option").length;
	
	for(var i=0; i<len; i++) {
	  if ( e.options[i].value == sch ) {
		e.selectedIndex = i;
	    break;
	  }
	}
}

function reloadPage() {
	location.reload(true);
}

function downloadFile(sourceID) {
	var src = document.getElementById(sourceID);
	var fd = src.value;

	alert(fd);

	var str = "servlet/DownloadServlet?param1=" + fd;
	document.location.href = str;

	// location.reload(true);

	return true;
}

function validateForm(whichPressed) {
	if (whichPressed == "Generate") {
		var df = document.getElementById("fromDate").value;
		var dt = document.getElementById("toDate").value;
		var sc = $("#selected_contract option").length;
		var ss = $("#selected_schedule option").length;
		// var sc=document.getElementById("selected_contract").value;
		// var ss=document.getElementById("selected_schedule").value;

		if (df == null || df == "") {
			alert("From-Date must be filled in");
			return false;
		}
		if (dt == null || dt == "") {
			alert("To-Date must be filled in");
			return false;
		}
		if (dt != null && dt != "") // && dt < df, this doesn't give proper
									// result.
		{
			var dt1 = parseInt(df.substring(0, 2), 10);
			var mon1 = parseInt(df.substring(3, 5), 10);
			var yr1 = parseInt(df.substring(6, 10), 10);
			var dt2 = parseInt(dt.substring(0, 2), 10);
			var mon2 = parseInt(dt.substring(3, 5), 10);
			var yr2 = parseInt(dt.substring(6, 10), 10);
			var date1 = new Date(yr1, mon1, dt1); // date_from
			var date2 = new Date(yr2, mon2, dt2); // date_to

			if (date2 < date1) {
				alert("To date must be greater than from date");
				return false;
			}
		}
		// if (sc==null || sc==""){
		if (sc <= 0) {
			alert("Contract Code must be selected");
			return false;
		}
		// if (ss==null || ss==""){
		if (ss <= 0) {
			alert("Schedule Code must be selected");
			return false;
		}
	}
	return true;
}

function getGroupDrdn(categoryCode) {
	document.getElementById("categoryCode").value = categoryCode;
	$.ajax({
		type : "POST",
		url : "index.htm",
		data : "categoryCode=" + categoryCode + "&_target6=group",
		success : function(response) {
			var data = $.parseJSON(response);

			var html = '<option value="0">--Select Group--</option>';
			html += '<option value="ALL">ALL GROUP</option>';

			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<option value="' + data[i].groupCode + '">'
						+ data[i].groupName + '</option>';
			}
			html += '</option>';
			$('#groupName').html(html);

		},
		error : function(e) {
			alert('Error: ' + e);
		}

	});
}

function getMajorDrdn(groupCode) {
	var categoryCode = $("#categoryName").val();
	document.getElementById("groupCode").value = groupCode;
	$.ajax({
		type : "POST",
		url : "index.htm",
		data : "categoryCode=" + categoryCode + "&groupCode=" + groupCode
				+ "&_target7=major",
		success : function(response) {
			var data = $.parseJSON(response);

			var html = '<option value="0">--Select Major--</option>';
			html += '<option value="ALL">ALL MAJOR</option>';
			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<option value="' + data[i].majorCode + '">'
						+ data[i].majorName + '</option>';
			}
			html += '</option>';
			$('#majorName').html(html);

		},
		error : function(e) {
			alert('Error: ' + e);
		}

	});
}

function getMinorDrdn(majorCode) {
	var categoryCode = $("#categoryName").val();
	var groupCode = $("#groupName").val();
	document.getElementById("majorCode").value = majorCode;

	$.ajax({
		type : "POST",
		url : "index.htm",
		data : "categoryCode=" + categoryCode + "&groupCode=" + groupCode
				+ "&majorCode=" + majorCode + "&_target8=minor",
		success : function(response) {
			var data = $.parseJSON(response);

			var html = '<option value="0">--Select Minor--</option>';
			html += '<option value="ALL">ALL MINOR</option>';
			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<option value="' + data[i].minorCode + '">'
						+ data[i].minorName + '</option>';
			}
			html += '</option>';
			$('#minorName').html(html);

		},
		error : function(e) {
			alert('Error: ' + e);
		}

	});
}

function getSuppDrdn(minorCode) {
	document.getElementById("minorCode").value = minorCode;

}

function getItemDrdn(supplierCode) {
	document.getElementById("supplierCode").value = supplierCode;
	var categoryCode = $("#categoryName").val();
	var groupCode = $("#groupName").val();
	var majorCode = $("#majorName").val();
	var minorCode = $("#minorName").val();

	$.ajax({
		type : "POST",
		url : "index.htm",
		data : "categoryCode=" + categoryCode + "&groupCode=" + groupCode
				+ "&majorCode=" + majorCode + "&minorCode=" + minorCode
				+ "&_target10=item",
		success : function(response) {
			var data = $.parseJSON(response);

			var html = '<option value="0">--Select Item--</option>';
			html += '<option value="ALL">ALL ITEM</option>';

			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<option value="' + data[i].itemCode + '">'
						+ data[i].itemName + '</option>';
			}
			html += '</option>';
			$('#itemName').html(html);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function getItemDetail(itemCode) {
	document.getElementById("itemCode").value = itemCode;

}

var cnt = 0; // global variable.
// Function for single zone transfer in forward direction.
// Step-1: Add the selected zone in the selected_zone map.
// Step-2: Remove the selected zone from zone map.
// Step-3: Populate contract code map of selected zone.
function zoneForward() {
	window.cnt += 1;
	// alert(window.cnt);
	var e = document.getElementById("zone"); // contains zone list.
	var zoneCode = e.options[e.selectedIndex].value;
	var zoneDesc = e.options[e.selectedIndex].text;
	// alert(zoneCode + '---' + zoneDesc);

	// -------- Collection of already selected zone codes.
	var len1 = $("#selected_zone option").length; // length of already
	// selected zone.
	var html = '';

	if (len1 > 0) {
		var e1 = document.getElementById("selected_zone"); // contains
		// selected_zone
		// list

		for (var i = 0; i < len1; i++) {
			html += '<option value="' + e1.options[i].value + '">'
					+ e1.options[i].text + '</option>';
		}
	}
	// Add currently selected zone in the selected_zone map.
	html += '<option value="' + zoneCode + '">' + zoneDesc + '</option>';
	html += '</option>';

	$('#selected_zone').html(html); // populate selected zone map.
	// ------ End.

	// ------ Remove the selected zone from zone map.
	var len2 = $("#zone option").length; // length of zone map.
	var html = '';

	if (len2 > 0) {
		var e2 = document.getElementById("zone"); // contains zone list.

		for (var i = 0; i < len2; i++) {
			if (e2.options[i].value != zoneCode)
				html += '<option value="' + e2.options[i].value + '">'
						+ e2.options[i].text + '</option>';
		}
	}
	html += '</option>';
	$('#zone').html(html); // populate zone map after removal of selected zone.
	zoneCode = "'" + zoneCode + "'"; // e.g. '02'.

	// ------ End.

	// ------ Populate contract code map of selected zone.
	// Fetching contract codes of the selected zone from database,
	// and then add the contracts into the contract drop down list.
	$.ajax({
		type : "POST",
		url : "index.htm",
		data : "zoneCode=" + zoneCode + "&_target11=contract",
		success : function(response) {
			var data = $.parseJSON(response);

			// checking for already populated contracts for previously selected
			// zone.
			var len3 = $("#contract option").length;
			var html = '';

			// display of contract code instead of contract description in the
			// map.
			if (len3 > 0) {
				var e3 = document.getElementById("contract");

				for (var i = 0; i < len3; i++) {
					html += '<option value="' + e3.options[i].value + '">'
							+ e3.options[i].value + '</option>';
				}
			}

			// display of contract code instead of contraction desc in the map.
			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<option value="' + data[i].contractCode + '">'
						+ data[i].contractName + '</option>';
			}
			html += '</option>';
			$('#contract').html(html); // populate contract map.
		},
		error : function(e) {
			// alert('Error: ' + e);
		}
	}); // End of data fetching.
}

// Function for All zones transfer in forward direction.
function zoneForwardAll() {
	// -------- Collection of already selected zone codes.
	var len1 = $("#selected_zone option").length; // length of already
	// selected zone.
	var html = '';
	var zoneCodeAll = "";

	// checking for already selected zones.
	if (len1 > 0) {
		var e1 = document.getElementById("selected_zone"); // contains
		// selected_zone
		// list.

		for (var i = 0; i < len1; i++) {
			html += '<option value="' + e1.options[i].value + '">'
					+ e1.options[i].text + '</option>';
			zoneCodeAll += "'" + e1.options[i].value + "',";
		}
	}
	// ------ End.

	// ------ Population of rest of All zones.
	var e = document.getElementById("zone");
	var len = $("#zone option").length;
	// alert("length of drdn:"+len);

	for (var i = 0; i < len; i++) {
		html += '<option value="' + e.options[i].value + '">'
				+ e.options[i].text + '</option>';
		zoneCodeAll += "'" + e.options[i].value + "',";
	}
	html += '</option>';
	$('#selected_zone').html(html);
	zoneCodeAll = zoneCodeAll.substring(0, zoneCodeAll.length - 1);
	// alert(zoneCodeAll);

	html = '';
	$('#zone').html(html);

	// ------ Populate contract code map of selected zone.
	// Fetching contract codes of the rest of zones from database,
	// and then add the contracts into the contract drop down list.
	$.ajax({
		type : "POST",
		url : "index.htm",
		data : "zoneCode=" + zoneCodeAll + "&_target11=contract",
		success : function(response) {
			var data = $.parseJSON(response);

			// checking for already populated contracts for previously selected
			// zone.
			var len3 = $("#contract option").length;
			var html = '';

			// display of contract code instead of contract description in the
			// map.
			if (len3 > 0) {
				var e3 = document.getElementById("contract");

				for (var i = 0; i < len3; i++) {
					html += '<option value="' + e3.options[i].value + '">'
							+ e3.options[i].value + '</option>';
				}
			}

			// display of contract code instead of contract desc in the map.
			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<option value="' + data[i].contractCode + '">'
						+ data[i].contractName + '</option>';
			}
			html += '</option>';
			$('#contract').html(html); // populate contract map.
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	}); // End of data fetching.
}

// Function for single zone transfer in reverse direction.
// Step-1: Add the selected zone to the existing zones in the zone-map.
// Step-2: Remove the selected zone from selected_zone map.
// Step-3: Populate contract code map of currently selected zones.
function zoneReverse() {
	window.cnt += 1; // global variable.
	// alert(window.cnt);
	var e = document.getElementById("selected_zone"); // contains selected
	// zone list.
	var zoneCode = e.options[e.selectedIndex].value;
	var zoneDesc = e.options[e.selectedIndex].text;
	// alert(zoneCode + '---' + zoneDesc);

	// Step-1:
	// -------- Collection of not selected zone codes from zone map.
	var len1 = $("#zone option").length; // length of not selected zone.
	var html = '';

	if (len1 > 0) {
		var e1 = document.getElementById("zone"); // contains zone list

		for (var i = 0; i < len1; i++) {
			html += '<option value="' + e1.options[i].value + '">'
					+ e1.options[i].text + '</option>';
		}
	}
	// Add currently selected zone in the zone map.
	html += '<option value="' + zoneCode + '">' + zoneDesc + '</option>';
	html += '</option>';

	$('#zone').html(html); // populate zone map.
	// ------ End.

	// Step-2:
	// ------ Remove the selected zone from selected_zone map.
	var len2 = $("#selected_zone option").length; // length of zone map.
	var html = '';
	var zoneCodeAll = "";

	if (len2 > 0) {
		var e2 = document.getElementById("selected_zone"); // contains
		// selected_zone
		// list.

		for (var i = 0; i < len2; i++) {
			if (e2.options[i].value != zoneCode) {
				html += '<option value="' + e2.options[i].value + '">'
						+ e2.options[i].text + '</option>';
				zoneCodeAll += "'" + e2.options[i].value + "',";
			}
		}
	}
	html += '</option>';
	$('#selected_zone').html(html); // populate selected_zone map after
	// removal of selected zone.

	// Step-3.
	if (zoneCodeAll != "") {
		// to remove contract code from already selected_contract map
		// as well as contract map who are under the removed zone code.
		$.ajax({
			type : "POST",
			url : "index.htm",
			data : "zoneCode=" + zoneCode + "&_target11=contract",
			success : function(response) {
				var data = $.parseJSON(response);
				var html = '';

				// display of contract code instead of contract desc in the map.
				var len = data.length;
				for (var i = 0; i < len; i++) {
					contcd = data[i].contractCode;
					var src = document.getElementById('selected_contract');
					for (var count = 0; count < src.options.length; count++) {
						if (src.options[count].value == contcd) {
							try {
								src.remove(count, null);
							} catch (error) {
								src.remove(count);
							}
							count--;
							break;
						}
					}
					var dest = document.getElementById('contract');
					for (var count = 0; count < dest.options.length; count++) {
						if (dest.options[count].value == contcd) // if
						// exists,
						// then delete.
						{
							try {
								dest.remove(count, null);
							} catch (error) {
								dest.remove(count);
							}
							count--;
							break;
						}
					}
				}
				populateContract('selected_contract', 'selected_contract', src,
						src);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		}); // End of data fetching.
	} else {
		$('#contract').html('');
		$('#selected_contract').html('');
		$('#contract_desc').html(html); // Free contract_desc map.
	}

}

// Function for All zone transfer in reverse direction.
// Step-1: Add the selected all zones to the existing zones in the zone-map.
// Step-2: Remove All zones from selected_zone map to make it free/blank.
// Also make Free/Blank contract code map and Selected_contract code map.
function zoneReverseAll() {
	window.cnt += 1; // global variable.
	// alert(window.cnt);

	// Step-1:
	// -------- Collection of existing zone codes from zone map.
	var len1 = $("#zone option").length; // length of not selected zone.
	var html = '';

	if (len1 > 0) {
		var e1 = document.getElementById("zone"); // contains zone list

		for (var i = 0; i < len1; i++) {
			html += '<option value="' + e1.options[i].value + '">'
					+ e1.options[i].text + '</option>';
		}
	}
	// Add all of currently selected zones in the zone map.
	var len2 = $("#selected_zone option").length; // length of selected_zone
	// map.

	if (len2 > 0) {
		var e2 = document.getElementById("selected_zone"); // contains
		// selected_zone
		// list.

		for (var i = 0; i < len2; i++) {
			html += '<option value="' + e2.options[i].value + '">'
					+ e2.options[i].text + '</option>';
		}
	}
	html += '</option>';
	$('#zone').html(html); // populate zone map.
	// ------ End.

	// Step-2:
	// ------ Remove the selected zone from selected_zone map.
	var html = '';
	$('#selected_zone').html(html); // Free selected_zone map.
	$('#contract').html(html); // Free contract map.
	$('#selected_contract').html(html); // Free selected_contract map.
	$('#contract_desc').html(html); // Free contract_desc map.
}

function contractMove(sourceID, destID) {
	var src = document.getElementById(sourceID);
	var dest = document.getElementById(destID);
	for (var count = 0; count < src.options.length; count++) {
		if (src.options[count].selected == true) {
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
	}
	// ------ Populate Contract Description Map of selected contract.
	populateContract(sourceID, destID, src, dest);
}

function populateContract(sourceID, destID, src, dest) {
	// ------ Populate Contract Description Map of selected contract.
	var contractCodeAll = "";
	if (sourceID == 'contract') {
		for (var count = 0; count < dest.options.length; count++) {
			contractCodeAll += "'" + dest.options[count].value + "',";
		}
	} else {
		for (var count = 0; count < src.options.length; count++) {
			contractCodeAll += "'" + src.options[count].value + "',";
		}
	}
	// alert(contractCodeAll);
	if (contractCodeAll != "") {
		contractCodeAll = contractCodeAll.substring(0,
				contractCodeAll.length - 1);
		// alert(scheduleCodeAll);
		$.ajax({
			type : "POST",
			url : "index.htm",
			data : "contractCode=" + contractCodeAll + "&_target13=contract",
			success : function(response) {
				var data = $.parseJSON(response);
				var html = '';

				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i].contractCode + '">'
							+ data[i].contractName + '</option>';
				}
				html += '</option>';
				$('#contract_desc').html(html); // populate contract
				// description map.
				updateContractMap();
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		}); // End of data fetching.
	} else
		$('#contract_desc').html('');
}

function updateContractMap(sourceID, destID, value) {

	var http = getHTTPObject();
	if (http != null) {
		var random = Math.random();
		http.onreadystatechange = function() {
			handleHttpUpdateMap(http);
		};
		http.open("GET", "index.htm?_target3=securityDeposit&unique=" + random
				+ "&sourceID=" + sourceID + "&destID=" + destID + "&value="
				+ value, true);

		http.send(null);

	}

}

function contractMoveAll(sourceID, destID) {
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
	populateContract(sourceID, destID, src, dest);
}

function scheduleMove(sourceID, destID) {
	var src = document.getElementById(sourceID);
	var dest = document.getElementById(destID);
	for (var count = 0; count < src.options.length; count++) {
		if (src.options[count].selected == true) {
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
	}
	// ------ Populate Schedule Description Map of selected schedule.
	var scheduleCodeAll = "";
	if (sourceID == 'schedule') {
		for (var count = 0; count < dest.options.length; count++) {
			scheduleCodeAll += "'" + dest.options[count].value + "',";
		}
	} else {
		for (var count = 0; count < src.options.length; count++) {
			scheduleCodeAll += "'" + src.options[count].value + "',";
		}
	}
	if (scheduleCodeAll != "") {
		scheduleCodeAll = scheduleCodeAll.substring(0,
				scheduleCodeAll.length - 1);
		// alert(scheduleCodeAll);
		$.ajax({
			type : "POST",
			url : "index.htm",
			data : "scheduleCode=" + scheduleCodeAll + "&_target12=schedule",
			success : function(response) {
				var data = $.parseJSON(response);
				var html = '';

				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i].scheduleCode + '">'
							+ data[i].scheduleName + '</option>';
				}
				html += '</option>';
				// $('#schedule_desc').html(html); // populate schedule
				// description map.
			},
			error : function(e) {
				// alert('Error: ' + e);
			}
		}); // End of data fetching.
	} else
		$('#schedule_desc').html('');
}

function scheduleMoveAll(sourceID, destID) {
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

	// ------ Populate Schedule Description Map of selected schedule.
	if (sourceID == 'schedule') {
		var scheduleCodeAll = "";
		for (var count = 0; count < dest.options.length; count++) {
			scheduleCodeAll += "'" + dest.options[count].value + "',";
		}
		scheduleCodeAll = scheduleCodeAll.substring(0,
				scheduleCodeAll.length - 1);
		// alert(scheduleCodeAll);
		$.ajax({
			type : "POST",
			url : "index.htm",
			data : "scheduleCode=" + scheduleCodeAll + "&_target12=schedule",
			success : function(response) {
				var data = $.parseJSON(response);
				var html = '';

				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i].scheduleCode + '">'
							+ data[i].scheduleName + '</option>';
				}
				html += '</option>';
				// $('#schedule_desc').html(html); // populate schedule
				// description map.
			},
			error : function(e) {
				// alert('Error: ' + e);
			}
		}); // End of data fetching.
	} else
		$('#schedule_desc').html('');
}

//Added on 25-03-2017 prior to final upload in LIVE.
function getSelSchDesc(schcd) {
	schcd = "'" + schcd + "'";
	$('#schedule_desc').html('');

	$.ajax({
		type : "POST",
		url : "index.htm",
		data : "scheduleCode=" + schcd + "&_target15=schedule",
		success : function(response) {
			var data = $.parseJSON(response);
			var html = '';

			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<option value="' + data[i].scheduleCode + '">'
						+ data[i].scheduleName + '</option>';
			}
			html += '</option>';
			$('#schedule_desc').html(html); // populate schedule description
			// map.
		},
		error : function(e) {
			// alert('Error: ' + e);
		}
	}); // End of data fetching.

}

function getSelContDesc(contcd) {
	contcd = "'" + contcd + "'";
	$('#contract_desc').html('');

	$.ajax({
		type : "POST",
		url : "index.htm",
		data : "contractCode=" + contcd + "&_target14=selContract",
		success : function(response) {
			var data = $.parseJSON(response);
			var html = '';

			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<option value="' + data[i].contractCode + '">'
						+ data[i].contractName + '</option>';
			}
			html += '</option>';
			$('#contract_desc').html(html); // populate contract description
			// map.
		},
		error : function(e) {
			// alert('Error: ' + e);
		}
	}); // End of data fetching.
}
