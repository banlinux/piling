<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true"%>

<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/simplex.css">
<link rel="stylesheet" href="css/fancydropdown.css">
<script type="text/javascript" src="js/common/md5.js"></script>
<script type="text/javascript">
	function encrypt() {
		var dgst = document.getElementById('pwd').value;
		document.getElementById('passwd').value = dgst;
		document.getElementById('pwd').value = '**********************';

		return (true);
	}

	function encryptFirstLogin() {
		var dgst = hex_md5(document.getElementById('old_pwd').value);
		document.getElementById('old_password').value = dgst;
		document.getElementById('old_pwd').value = '**********************';

		var new_password = document.getElementById('new_pwd').value;

		if (new_password != '' && new_password != null) {
			dgst = hex_md5(new_password);
			document.getElementById('new_password').value = dgst;
			document.getElementById('new_pwd').value = '**********************';

			dgst = hex_md5(document.getElementById('new_pwd_confirm').value);
			document.getElementById('new_password_confirm').value = dgst;
			document.getElementById('new_pwd_confirm').value = '**********************';

			return (true);
		} else
			return (false);
	}
</script>
</head>
<body onload="document.forms[0].elements[0].focus()">
	<script language="javascript">
		history.go(1); /* undo user navigation (ex: IE Back Button) */
	</script>

	<c:choose>
		<c:when test="${firstLogin == '1'}">
			<form name="login" method="post" class="formCSS">
				<table width="100%" border="0">
					<tr>
						<td align="center"><h1>
								<fmt:message key="loginForm.firstLogin" />
							</h1>
						</td>
					</tr>
					<tr>
						<td align="center">
							<table border="1" bordercolor="#0a456d" cellspacing=0
								cellpadding="2">
								<tr>
									<td colspan="3" align="center">${message}</td>
								</tr>
								<tr>
									<td>
										<table width="100%" border="0">
											<tr>
												<td class="labeltext">Old Password</td>
												<td><strong>:</strong>
												</td>
												<td><input type="password" id="old_pwd"> <input
													type="hidden" id="old_password" name="old_password">
												</td>
											</tr>
											<tr>
												<td class="labeltext">New Password</td>
												<td><strong>:</strong>
												</td>
												<td><input type="password" id="new_pwd"> <input
													type="hidden" id="new_password" name="new_password">
												</td>
											</tr>
											<tr>
												<td class="labeltext">Confirm Password</td>
												<td><strong>:</strong>
												</td>
												<td><input type="password" id="new_pwd_confirm">
													<input type="hidden" id="new_password_confirm"
													name="new_password_confirm"></td>
											</tr>
										</table></td>
								</tr>
								<tr>
									<td colspan="3" align="center"><input class="button1"
										type="button" value="Logout"
										onclick="location.href='logout.htm'">&nbsp;&nbsp;&nbsp;&nbsp;
										<input class="button1" type="submit" value="Set"
										onclick="encryptFirstLogin () ;"></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<%-- The following code will redirect to the main page if the user
                     has successfully logged in. This process for redirecting is reqired to
                     make sure that the mainpageController is called before the mainpage
                     is displayed.--%>
			<c:if test="${sessUserID != 'none'}">				
						<c:redirect url="/mainMenu.htm" />				
			</c:if>
			
			<table width="100%" border="0" >
                    <tr>
                        <td align="center" style="COLOR: #ff0000;">
                            <h1 style="COLOR: #bd1122; FONT-FAMILY: 'SansSerif'; FONT-STYLE: italic;">Piling Application<br>
                         </h1>
                        </td>
                    </tr>
                    
                </table>
			<br>
			<form name="login" method="post">
			<div align="center">
				<table border=1 width="300px" bordercolor="#0a456d" cellspacing=0
					cellpadding="2" align="center" style="BACKGROUND-COLOR: #f0f0f0;">
					<tr>
						<td colspan="2" class="labeltext" align="center">${message}</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<table border="0">
                                    <tr>
                                        <td width="40%" class="labeltext" align="left">User Id</td>
                                        <td width="60%">
                                            <input class="textbox1" name="uname" type="text" size="20" maxlength="20"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="labeltext" align="left">Password</td>
                                        <td>
                                            <input class="textbox1" id="pwd" type="password" size="22">
                                            <input type="hidden" id="passwd" name="passwd">
                                        </td>
                                    </tr>
                                </table>
							</td>
					</tr>
					<tr>
						<td colspan="2" align="center">&nbsp;&nbsp;&nbsp; <input
							class="button1" type="reset" value="Reset" />&nbsp;&nbsp; <input
							class="button1" type="submit" value="Sign In"
							onclick="encrypt () ;" /></td>
					</tr>
					
				</table>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>
