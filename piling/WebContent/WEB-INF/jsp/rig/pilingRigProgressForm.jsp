<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../menu/commonHead.jsp"></jsp:include>
<script type="text/javascript" src="js/pilingRigProgressForm/pilingRigProgress.js"></script>
<script type="text/javascript" src="js/pilingRigProgressForm/ajax.js"></script>
<script language="javascript" src="js/common/table_creation_api.js"></script>

<title>Piling Rig Progress</title>
<script type="text/javascript">
function autofill(){
	 var tType="CONTRACT";

	 $( "#contract_no" ).autocomplete({	    	
	        source: '${pageContext. request. contextPath}/pilingRigProgressForm/pilingRigProgressFormAjax.htm?senderType='+tType,
	        minLength: 3,
	        select: function(e, ui) {
	        	getContractDetails(ui.item.value);
	        	
  	  }
    });
}
function autofillRig(){
	 var tType=document.getElementById("contract_no").value;
	 $( "#rig_no" ).autocomplete({	    	
	        source: '${pageContext. request. contextPath}/pilingRigProgressForm/pilingRigProgressFormRig.htm?senderType='+tType,
	        minLength: 3,
	        select: function(e, ui) {
	        	getRigDetails(ui.item.value);
	        	
   }
	    });
}
function autofillPile(){
	 var tType=document.getElementById("contract_no").value;
	 $( "#pileNo").autocomplete({	    	
	        source: '${pageContext. request. contextPath}/pilingRigProgressForm/pilingRigProgressFormPile.htm?senderType='+tType,
	        minLength: 3,
	        select: function(e, ui) {
	        	getPileDetails(ui.item.value);
	        	
    }
	    });
}
</script>
<style type="text/css">
<!--
.style6 {
	color: #666666
}

.style7 {
	color: #FF0000
}

.style8 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
}

.style9 {
	font-size: 12px
}
</style>
</head>
<body>
<div style="height: 100px"><jsp:include page="../menu${sessUserID}.jsp" ></jsp:include></div> 
<div align="center"><h2>Piling Rig Progress Form</h2></div>
<spring:form commandName="pilingRigProgressForm">
<div class="mainDiv">
 <fieldset class="dottedborder">
 <legend class="fieldsetheader"> Piling Rig Progress Form</legend>
 <table>
 	<tr>
 		<td class="labeltext">Select Contract</td>
 		<td><spring:input id="contract_no" path="contract_no" onkeyup="autofill();"   size="30"/>
 			<spring:errors path="contract_no" cssClass="error"></spring:errors>
  		</td>
 		<td><spring:input path="contractName" size="80"/> </td>
 		<td></td>
 	</tr>
 </table>
 <table>	
 	<tr>
 		<td class="labeltext">Site Code</td>
 		<td><spring:input path="site_no" /></td>
	</tr>
	<tr>
 		<td class="labeltext">Rig</td>
 		<td><spring:input path="rig_no" onkeyup="autofillRig();"   size="40"/>
 			<spring:errors path="rig_no" cssClass="error"></spring:errors>
  		</td>
 		<td><spring:input path="rig_name" size="60"/> </td>
 	</tr>
  </table>
  <table> 
 
 	<tr>
 		<td class="labeltext">Pile</td>
 		<td><spring:input path="pileNo" onkeyup="autofillPile();"   size="40"/>
 			<spring:errors path="pileNo" cssClass="error"></spring:errors>
		</td>


 		<td  align="left" class="labeltext">Piling Date </td>
 		<td align="left"><spring:input path="dataDate" readonly="true" tabindex="-1"/><A
					HREF='javascript:showCalendarControl (document.forms[0].dataDate)'>
						<IMG src="js/calendar/calendar1.gif" border=0 align=middle>
						</A>  
		</td>
	</tr>	
 <!-- 
 	<tr>
 		<td class="labeltext">Select Zone</td>
 		<td>
 			<spring:select path="zoneCode" onchange="getSiteDetails(this.value);">
 			<spring:option value="0">--Select Zone--</spring:option>
 			<spring:options items="${pilingRigProgressForm.zoneMap }"/>
 			</spring:select>
 			<spring:errors path="zoneCode" cssClass="error"></spring:errors>
 	 	</td>
 	</tr>
 	<tr>
 		<td class="labeltext">Select Site </td>
 		<td ><spring:select path="siteCode" onchange="getContractDetails(this.value)">
 			<spring:option value="0">--Select Site--</spring:option>
 			</spring:select>
 			<spring:errors path="siteCode" cssClass="error"></spring:errors>
 	 	</td>
 	</tr>
  	<tr>
 		<td class="labeltext">Select Contract</td>
 		<td><spring:select path="contractCode" >
 			<spring:option value="0">--Select Contract--</spring:option>
 			</spring:select>
 			<spring:errors path="contractCode" cssClass="error"></spring:errors>
 	 	</td>
 	</tr>
  -->



 
 
 
 
</table>
		<table width="95%">
			<tr>
				<td height="25" align="left" bgcolor="#E5E5E5" class="page_subbold">
					&nbsp;&nbsp;<fmt:message key="pilingRigProgressForm.pilingTime" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="labeltext">Boring Start Time(HH:MM)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 				<td>	

					
					<spring:select path="boringHour" multiple="false">
        				<c:forEach var="entry" items="${pilingRigProgressForm.boringHourMap}">
        				
            				<spring:option   value="${entry.key}" label="${entry.value}"  />
        				</c:forEach>
    				</spring:select>
					
					
					<spring:select path="boringMinute"  multiple="false">
					 		  <spring:options items="${pilingRigProgressForm.boringMinuteMap}" />
					</spring:select>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="labeltext">Boring End Time(HH:MM)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 				<td>	

					
					<spring:select path="boringHourEnd" multiple="false">
        				<c:forEach var="entry" items="${pilingRigProgressForm.boringHourMap}">
        				
            				<spring:option   value="${entry.key}" label="${entry.value}"  />
        				</c:forEach>
    				</spring:select>
					
					
					<spring:select path="boringMinuteEnd"  multiple="false">
					 		  <spring:options items="${pilingRigProgressForm.boringMinuteMap}" />
					</spring:select>
				</td>
			</tr>
			<tbody id="pilingTime_det"></tbody>	
		</table>	
		<!--  Milan Dutta  May be we do not need to add new start and end time
		<table  width="95%">
			<tr>

				<td align="right"><input type="button" class="button2"
					value="Add More Piling Time" onclick="addPilingTime();"></td>
				<td align="right"><input type="button" class="button1"
					value="Done" onclick="setPilingTime();"></td>
			</tr>
		</table>
		 -->
		<table width="95%">
			<tr>
				<td height="25" align="left" bgcolor="#E5E5E5" class="page_subbold">
					&nbsp;&nbsp;<fmt:message key="pilingRigProgressForm.idleTime" /></td>
			</tr>
		</table>

		<table>
			<tr>
				<td class="labeltext">Idle Time Start(HH:MM)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 				<td>	

					
					<spring:select path="idleHour" multiple="false">
        				<c:forEach var="entry" items="${pilingRigProgressForm.idleHourMap}">
        				
            				<spring:option   value="${entry.key}" label="${entry.value}"  />
        				</c:forEach>
    				</spring:select>
				</td>
				<td>	
					
					<spring:select path="idleMinute"  multiple="false">
					 		  <spring:options items="${pilingRigProgressForm.idleMinuteMap}" />
					</spring:select>
				</td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="labeltext">Idle Time End(HH:MM)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 			<td>	

					
					<spring:select path="idleHourEnd" multiple="false">
        				<c:forEach var="entry" items="${pilingRigProgressForm.idleHourMap}">
        				
            				<spring:option   value="${entry.key}" label="${entry.value}"  />
        				</c:forEach>
    				</spring:select>
			</td>
			<td>		
					
					<spring:select path="idleMinuteEnd"  multiple="false">
					 		  <spring:options items="${pilingRigProgressForm.idleMinuteMap}" />
					</spring:select>
				</td>
			</tr>
			
			<tbody id="pilingIdle_det"></tbody>
				
		</table>
		<table  width="95%">
			<tr>

				<td align="right"><input type="button" class="button2"
					value="Add More Idle Time" onclick="addIdleTime();"></td>
				<td align="right"><input type="button" class="button1"
					value="Done" onclick="setIdleTime();"></td>
			</tr>
		</table>
		<table  width="95%">
			<tr>

				<td >
					<fmt:message key="pilingRigProgressForm.idleReason" /></td>

				<td  align="right"><spring:input path="idleReason" type="text" class="textbox_850"></spring:input>
				
				</td>
				
				
				
				
			</tr>
		</table>
		<table width="95%">
			<tr>
				<td height="25" align="left" bgcolor="#E5E5E5" class="page_subbold">
					&nbsp;&nbsp;<fmt:message key="pilingRigProgressForm.breakdownTime" /></td>
			</tr>
		</table>

		<table>

			<tr>
				<td class="labeltext">Breakdown Time Start(HH:MM)</td>
 				<td>	

					
					<spring:select path="breakdownHour" multiple="false">
        				<c:forEach var="entry" items="${pilingRigProgressForm.breakdownHourMap}">
        				
            				<spring:option   value="${entry.key}" label="${entry.value}"  />
        				</c:forEach>
    				</spring:select>
				</td>
				<td>	
					
					<spring:select path="breakdownMinute"  multiple="false">
					 		  <spring:options items="${pilingRigProgressForm.breakdownMinuteMap}" />
					</spring:select>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="labeltext">Breakdown Time End(HH:MM)</td>
 				<td>	

					
					<spring:select path="breakdownHourEnd" multiple="false">
        				<c:forEach var="entry" items="${pilingRigProgressForm.breakdownHourMap}">
        				
            				<spring:option   value="${entry.key}" label="${entry.value}"  />
        				</c:forEach>
    				</spring:select>
					
				</td>
			    <td>		
					<spring:select path="breakdownMinuteEnd"  multiple="false">
					 		  <spring:options items="${pilingRigProgressForm.breakdownMinuteMap}" />
					</spring:select>
				</td>
				</tr>
				<tbody id="pilingBreakdown_det"></tbody>
		</table>
		<table  width="95%">
			<tr>

				<td align="right"><input type="button" class="button2"
					value="Add More Piling Time" onclick="addBreakdownTime();"></td>
				<td align="right"><input type="button" class="button1"
					value="Done" onclick="setBreakdownTime();"></td>
			</tr>						  	
		</table>
		<table  width="95%">
			<tr>

				<td >
					<fmt:message key="pilingRigProgressForm.breakdownReason" /></td>

				<td  align="right"><spring:input path="breakdownReason" type="text" class="textbox_850"></spring:input>
				
				</td>
			</tr>
		</table>
		<table  width="95%">
			<tr>

				<td >
					<fmt:message key="pilingRigProgressForm.actionTakenAgainstBreakdown" /></td>

				<td  align="right"><spring:input path="actionTakenAgainstBreakdown" type="text" class="textbox_850"></spring:input>
				
				</td>
			</tr>
		</table>
		<table width="95%">
			<tr>
				<td height="25" align="left" bgcolor="#E5E5E5" class="page_subbold">
					&nbsp;&nbsp;<fmt:message key="pilingRigProgressForm.movementTime" /></td>
			</tr>
		</table>

		<table>
			<tr>
				<td class="labeltext">Movement Time Start(HH:MM)&nbsp;</td>
 				<td>	

					
					<spring:select path="movementHour" multiple="false">
        				<c:forEach var="entry" items="${pilingRigProgressForm.movementHourMap}">
        				
            				<spring:option   value="${entry.key}" label="${entry.value}"  />
        				</c:forEach>
    				</spring:select>
				</td>
				<td>	
					
					<spring:select path="movementMinute"  multiple="false">
					 		  <spring:options items="${pilingRigProgressForm.movementMinuteMap}" />
					</spring:select>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="labeltext">Movement Time End(HH:MM)&nbsp;</td>
 				<td>	

					
					<spring:select path="movementHourEnd" multiple="false">
        				<c:forEach var="entry" items="${pilingRigProgressForm.movementHourMap}">
        				
            				<spring:option   value="${entry.key}" label="${entry.value}"  />
        				</c:forEach>
    				</spring:select>
				</td>
				<td>	
					
					<spring:select path="movementMinuteEnd"  multiple="false">
					 		  <spring:options items="${pilingRigProgressForm.movementMinuteMap}" />
					</spring:select>
				</td>
			</tr>
			<tbody id="pilingMovement_det"></tbody>
  		</table>
  		<table  width="95%">
			<tr>

				<td align="right"><input type="button" class="button2"
					value="Add More Movement Time" onclick="addMovementTime();"></td>
				<td align="right"><input type="button" class="button1"
					value="Done" onclick="setMovementTime();"></td>
			</tr>
		</table>
				<table  width="95%">
			<tr>

				<td >
					<fmt:message key="pilingRigProgressForm.rigMovementDetail" /></td>

				<td  align="right"><spring:input path="rigMovementDetail" type="text" class="textbox_850"></spring:input>
				
				</td>
				
				
				
				
			</tr>
		</table>
<div>
		<table align="center">
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr >
				<td >
					<input type="submit" class="button1" name="_save" value="Save">					
					<input type="reset" class="button1" name="Reset" value="Reset">
				</td>
			</tr>
		</table>	
</div>
 </fieldset>
   <table id="result"></table>
 <div id="pager"></div>
 </div>
 </spring:form>

</body>
</html>