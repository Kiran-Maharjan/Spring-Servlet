<%@include file="../shared/header.jsp" %>
<h1>Customers</h1>
<div>
    <c:if test="${param.action!=null}">
        <c:if test="${param.success!=null}">
            <div class="alert alert-success" role="alert">
                Data Updated Successfully
            </div>
        </c:if>
    </c:if>
</div>

<table class="table table-bordered table-hover table-striped"> 
    <tr>
        <th>Id                  
        </th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName} ${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>${customer.contactNo}</td>
            <td>${customer.status}</td>
            <td>
                <a href="${SITE_URL}/admin/customer/edit/${customer.id}" class="btn btn-xs btn-success"> 
                    <span class="glyphicon glyphicon-pencil" /> 
                </a>

                <a href="${SITE_URL}/admin/customer/delete/${customer.id}" class="btn btn-xs btn-danger" onclick="return confirm('Are you sure to Delete?')"> 
                    <span class="glyphicon glyphicon-trash" /> 
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="../shared/footer.jsp" %>   