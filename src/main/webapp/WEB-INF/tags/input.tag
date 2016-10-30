<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ attribute name="label" required="true" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="type" required="true" %>
<%@ attribute name="name" required="true" %>
<tr>
	<th>${label}</th>
	<td><input id="${id}" type="${type}" name="${name}" /></td>
</tr>
