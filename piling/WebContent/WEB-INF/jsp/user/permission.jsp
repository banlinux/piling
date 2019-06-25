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
		$( "#empCode" ).autocomplete({	    	
	        source: '${pageContext. request. contextPath}/userPermission/employeeDetailAjax.htm?senderType='+tType,
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
					<td class="labeltext">Employee Code :</td>
					<td>
						<spring:input path="empCode" onkeyup="autofill();"/>

					</td>
					<td class="labeltext">User Name :</td>
					<td align="left">
						<spring:input path="userName" />
					</td>
				</tr>
				<tr>
				<td class="labeltext">User Id :</td>
					<td>
						<spring:input path="userId" />

					</td>
				
					<td class="labeltext">Active Status[y/n] :</td>
					<td align="left">
						<spring:input path="status" value="n" size="1" disabled="true"/>
					</td>
				</tr>
				
			</table>
		</fieldset>
		<br>
		<fieldset class="dottedborder">  	
			<LEGEND class="fieldsetheader">Menu Permission</LEGEND>
			<table width="1024" align="center" border="1">
				<tr>
					<td>
 						<spring:checkbox path="m_site" id="m_site" value="Y" />
 					</td>
 					<td class="labeltext">Site Master</td>
 					<td>
 						<spring:checkbox path="m_contract" id="m_contract" value="Y" />
 					</td>
 					<td class="labeltext">Contract Master</td>
 					<td>
 						<spring:checkbox path="m_permission" id="m_permission" value="Y" />
 					</td>
 					<td class="labeltext">User Permission</td>
 					<td>
 						<spring:checkbox path="f_rig_progress" id="f_rig_progress" value="Y" />
 					</td>
 					<td class="labeltext">Rig Progress Form</td>
				</tr>
				<tr>
					<td>
 						<spring:checkbox path="r_rig_progress" id="r_rig_progress" value="Y" />
 					</td>
 					<td class="labeltext">Rig Progress Report</td>
 					<td>
 						<spring:checkbox path="m_rig" id="m_rig" value="Y" />
 					</td>
 					<td class="labeltext">Rig Master</td>
 					<td>
 						<spring:checkbox path="m_pile" id="m_pile" value="Y" />
 					</td>
 					<td class="labeltext">Pile Master</td>
 					<td>
 						
 					</td>
 					<td></td>
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