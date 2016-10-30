<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ attribute name="name" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="value1" required="true" %>
<%@ attribute name="value2" required="true" %>
<%@ attribute name="value3" required="true" %>
<%@ attribute name="lblvalue1" required="true" %>
<%@ attribute name="lblvalue2" required="true" %>
<%@ attribute name="lblvalue3" required="true" %>
<tr>
	<th>${label}</th>
	<td>
		<select name="${name}">
			<option value="${value1}">${lblvalue1}</option>
			<option value="${value2}">${lblvalue2}</option>
			<option value="${value3}">${lblvalue3}</option>
		</select>
	</td>
</tr>
