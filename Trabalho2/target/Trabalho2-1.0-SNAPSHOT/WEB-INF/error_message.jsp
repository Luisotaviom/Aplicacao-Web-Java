<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Object error = session.getAttribute("error");
    if (error != null) {%>
<p style="color:red;"><%= error%></p>
<%
        session.removeAttribute("error");
    }
%>