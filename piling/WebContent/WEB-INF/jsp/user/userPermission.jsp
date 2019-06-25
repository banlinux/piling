<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../menu/commonHead.jsp"></jsp:include>
<script type="text/javascript" src="js/user/userPermission.js"></script>
<script type="text/javascript">
	function split(val) {
    	return val.split(/,\s*/);
	}
	function extractLast(term) {
		return split(term).pop();
	}
 	function autofill(){
 		var tType="EMPLOYEE";
		$( "#userId" ).autocomplete({	    	
	        source: '${pageContext. request. contextPath}/outEntry/outEntryAjax.htm?senderType='+tType,
	        minLength: 3,
	        select: function(e, ui) {
	        	getPermissionDetails(ui.item.value);
		}
	    });
 	}
</script>

<title>User Permission Entry</title>

</head>
<body>
	<div style="height:100px"><jsp:include page="../menu${sessUserID}.jsp" ></jsp:include></div>
 	<div align="center"><h2>User Permission Entry</h2></div>
 	<spring:form name="form" commandName="permissionBean" >
 	<div class="mainDiv">
 		<fieldset class="dottedborder">
			<LEGEND class="fieldsetheader">Users Information</LEGEND>
			<table width="1024" align="center">
				<tr>
					<td class="labeltext">User Id :</td>
					<td>
						<spring:input path="userId" onkeyup="autofill();"/>
						<%-- <spring:select path="userId" onchange="getPermissionDetails(this.value);">
							<spring:option value="0" label="--- Select ---"></spring:option>
 							<spring:options items = "${permissionBean.employees}"/>
 						</spring:select> --%>
						<%-- <spring:input path="userId" cssClass="textbox_80" onclick="getPermissionDetails(this.value);" /> --%>
					</td>
					<td class="labeltext">User Name :</td>
					<td align="left">
						<spring:input path="userName" />
					</td>
				</tr>
				<tr>
					<td class="labeltext">Enter New Password :</td>
					<td align="left">
						<spring:input path="password" type="password" size="22" />
					</td>
					<td class="labeltext">Re-enter Password : </td>
					<td align="left">
						<spring:input path="repassword" type="password" size="22" />
					</td>
				</tr>
				<tr>
					<td class="labeltext">Enter Active Status[y/n] :</td>
					<td align="left">
						<spring:input path="status" value="n" size="1"/>
					</td>
				</tr>
				<tr>
					<td class="labeltext">Default Contract :</td>
 				 	<td><spring:input path="contCode" /> </td>
 				 	<td><spring:input path="contractDesc" disabled="true"/></td>
 				</tr>
 				<tr>
 				 	<td class="labeltext">Default Department :</td>
 				 	<td><spring:input path="deptCode" disabled="true"/> </td>
 				 	<td><spring:input path="deptName" disabled="true"/> </td>
				</tr>
			</table>
		</fieldset>
		<br>
		<fieldset class="dottedborder">  	
			<LEGEND class="fieldsetheader">Menu Permission</LEGEND>
			<table width="1024" align="center">
				<tr>
					<td>
 						<spring:checkbox path="empMenuMaster" id="empMenuMaster" value="Y" />
 					</td>
 					<td class="labeltext">Employee Master</td>
 					<td>
 						<spring:checkbox path="outEntryMenu" id="outEntryMenu" value="Y" />
 					</td>
 					<td class="labeltext">Out Entry</td>
 					<td>
 						<spring:checkbox path="inEntryMenu" id="inEntryMenu" value="Y" />
 					</td>
 					<td class="labeltext">InEntry And Distribution</td>
 					<td>
 						<spring:checkbox path="incommingRptMenu" id="incommingRptMenu" value="Y" />
 					</td>
 					<td class="labeltext">Incoming Mail Report</td>
				</tr>
				<tr>
					<td>
 						<spring:checkbox path="usrMenuPermission" id="usrMenuPermission" value="Y" />
 					</td>
 					<td class="labeltext">User Master And Menu Permission</td>
 					<td>
 						<spring:checkbox path="outEntryDispMenu" id="outEntryDispMenu" value="Y" />
 					</td>
 					<td class="labeltext">Out Entry Distribution</td>
 					<td>
 						<spring:checkbox path="courierReturnMenu" id="courierReturnMenu" value="Y" />
 					</td>
 					<td class="labeltext">Courier Returns</td>
 					<td>
 						<spring:checkbox path="outSumRptMenu" id="outSumRptMenu" value="Y" />
 					</td>
 					<td class="labeltext">Outgoing Mail Summary Report</td>
				</tr>
				<tr>
					<td>
 						<spring:checkbox path="dptMenu" id="dptMenu" value="Y" />
 					</td>
 					<td class="labeltext">Department Master</td>
 					<td>
 						<spring:checkbox path="returnEntryModMenu" id="returnEntryModMenu" value="Y" />
 					</td>
 					<td class="labeltext">Return Entry Modification</td>
 					<td>
 						<spring:checkbox path="indAckMenu" id="indAckMenu" value="Y" />
 					</td>
 					<td class="labeltext">Individual Acknowledgment</td>
 					<td>
 						<spring:checkbox path="returnRptMenu" id="returnRptMenu" value="Y" />
 					</td>
 					<td class="labeltext">Outgoing Mail Return Report</td>
				</tr>
				<tr>
					<td>
 						<spring:checkbox path="contractMenu" id="contractMenu" value="Y" />
 					</td>
 					<td class="labeltext">Contract Master</td>
 					<td>
 						<spring:checkbox path="returnMenu" id="returnMenu" value="Y" />
 					</td>
 					<td class="labeltext">Out Entry Return</td>
 					<td>
 						<spring:checkbox path="entryAckMenu" id="entryAckMenu" value="Y" />
 					</td>
 					<td class="labeltext">InEntry Acknowledgment</td>
 					<td>
 						<spring:checkbox path="outDtlRptMenu" id="outDtlRptMenu" value="Y" />
 					</td>
 					<td class="labeltext">Outgoing Mail Details Report</td>
				</tr>
				<tr>
					<td>
 						<spring:checkbox path="contractGroupMenu" id="contractGroupMenu" value="Y" />
 					</td>
 					<td class="labeltext">Contract Group Master</td>
 					<td>
 						<spring:checkbox path="consignModMenu" id="consignModMenu" value="Y" />
 					</td>
 					<td class="labeltext">Unknown Consignment Modification</td>
				</tr>
				<tr>
					<td>
 						<spring:checkbox path="locationMenu" id="locationMenu" value="Y" />
 					</td>
 					<td class="labeltext">Location Master </td>
				</tr>
				<tr>
					<td>
 						<spring:checkbox path="courierMenu" id="courierMenu" value="Y" />
 					</td>
 					<td class="labeltext">Courier Master</td>
				</tr>
				<tr>
					<td>
 						<spring:checkbox path="contMstViewMenu" id="contMstViewMenu" value="Y" />
 					</td>
 					<td class="labeltext">Contract Master View And Print</td>
				</tr>
				<tr>
					<td>
 						<spring:checkbox path="courierRateMenu" id="courierRateMenu" value="Y" />
 					</td>
 					<td class="labeltext">Courier Rate Master</td>
				</tr>
				<tr>
					<td>
						<spring:checkbox path="countryMstMenu" id="countryMstMenu" value="Y"/>
					</td>
					<td class="labeltext">Country Master</td>
				</tr>
				<tr>
					<td>
						<spring:checkbox path="regionMstMenu" id="regionMstMenu" value="Y"/>
					</td>
					<td class="labeltext">Region Master</td>
				</tr>
				<tr>
					<td>
						<spring:checkbox path="stateMstMenu" id="stateMstMenu" value="Y"/>
					</td>
					<td class="labeltext">State Master</td>
				</tr>
				<tr>
					<td>
						<spring:checkbox path="districtMstMenu" id="districtMstMenu" value="Y"/>
					</td>
					<td class="labeltext">District Master</td>
				</tr>
				<tr>
					<td>
						<spring:checkbox path="cityMstMenu" id="cityMstMenu" value="Y"/>
					</td>
					<td class="labeltext">City Master</td>
				</tr>
				<tr>
					<td>
						<spring:checkbox path="contDeptAssociation" id="contDeptAssociation" value="Y"/>
					</td>
					<td class="labeltext">Contract Department Association</td>
				</tr>
			</table>
		</fieldset>	
		<table width="90%">
				<tr>
					<td colspan="2" align="center">&nbsp;&nbsp;
						<input type="submit" class="button1" name="_save" id="_save" value="Save" onclick="return validateForm();"/>&nbsp;&nbsp;					
						<input type="reset" class="button1" name="Reset" id="Reset" value="Reset"/>&nbsp;&nbsp;
						<input type="submit" class="button1" name="_modify" id="_modify" value="Modify" onclick="return validateForm();"/>&nbsp;&nbsp;
						<input type="submit" class="button1" name="_cancel" id="_cancel" value="Cancel"/>&nbsp;&nbsp;
						<input type="button" class="button1" name="_selectAll" id="_selectAll" value="SelectAll" onclick="selectall();"/>&nbsp;&nbsp;
						<input type="button" class="button1" name="_withdrawAll" id="_withdrawAll" value="WithdrawAll" onclick="withdrawall();"/>&nbsp;&nbsp;
					</td>
				</tr>
		</table>
	</div>	
 	</spring:form>
</body>
</html>