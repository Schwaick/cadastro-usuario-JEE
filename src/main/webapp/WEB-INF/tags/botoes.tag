<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ attribute name="nameCancel" required="true" %>
<%@ attribute name="valueCancel" required="true" %>
<%@ attribute name="nameConfirm" required="true" %>
<%@ attribute name="valueConfirm" required="true" %>
<%@ attribute name="method" %>
<tr>
	<th></th>
	<td>
		<input type="reset" name="${nameCancel}" value="${valueCancel}" /> 
		<input type="submit" name="${nameConfirm}" value="${valueConfirm}"
			onClick="${method}" />
	</td>
</tr>
