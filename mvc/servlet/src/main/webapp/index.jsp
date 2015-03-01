<%@page import="com.blogspot.na5cent.connectdb.util.CollectionUtils"%>
<%@page import="com.blogspot.na5cent.model.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servlet</title>
        <link href="style.css" rel="stylesheet"/>
        <script src="jquery.min.js"></script>
        <script src="script.js"></script>
    </head>
    <body>
        <h1>Employees</h1>
        <form method="post" action="${pageContext.request.servletContext.contextPath}/employees">
            <input type="text" name="q" value="${pageContext.request.getParameter("q")}"/>
            <input type="hidden" name="by" value="${pageContext.request.getParameter("search_by")}"/>
            <select name="search_by">
                <option value="name">name</option>
                <option value="email">email</option>
                <option value="phone">phone</option>
                <option value="salary">salary</option>
            </select>
            <button type="submit">Search</button>
            <button type="submit" class="clear-button">clear</button>
        </form>
        <table>
            <thead>
                <tr>
                    <td>no.</td>
                    <td>employee id</td>
                    <td>first name</td>
                    <td>last name</td>
                    <td>email</td>
                    <td>phone number</td>
                    <td>salary</td>
                    <td>show data</td>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                    if (!CollectionUtils.isEmpty(employees)) {
                        for (int i = 0; i < employees.size(); i++) {
                            Employee employee = employees.get(i);
                %>            
                <tr>
                    <td><%= (i + 1)%></td>
                    <td><%= employee.getId()%></td>
                    <td><%= employee.getFirstName()%></td>
                    <td><%= employee.getLastName()%></td>
                    <td><%= employee.getEmail()%></td>
                    <td><%= employee.getPhoneNumber()%></td>
                    <td><%= employee.getSalary()%></td>
                    <td>
                        <a href="javascript:void(0)">show data</a>
                    </td>
                </tr>   
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
