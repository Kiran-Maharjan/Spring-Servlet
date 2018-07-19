<%-- 
    Document   : edit
    Created on : Jul 18, 2018, 8:34:59 AM
    Author     : kiran
--%>
<%@include file="../shared/header.jsp" %>
<form method="post" action="${SITE_URL}/admin/customer/save">
    <div class="form-group">
                <label>First Name</label>
                <input type="text" name="firstName"  class="form-control" required="required" value="${customer.firstName}"/>
            </div>
            
            <div class="form-group">
                <label>Last Name</label>
                <input type="text" name="lastName"  class="form-control" required="required" value="${customer.lastName}"/>
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email"  class="form-control" required="required" value="${customer.email}"/>
            </div>
            <div class="form-group">
                <label>Contact No.</label>
                <input type="text" name="contactNo"  class="form-control" required="required" value="${customer.contactNo}"/>
            </div>
            
            <div class="checkbox">
                <label>Status</label>
                <label>  
                    <input type="checkbox" name="status" <c:if test="customer.status">checked="checked"</c:if>/>Active</label>
            </div>
            <input type="hidden" name="id" value="${customer.id}" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    
            <button type="submit" class="btn btn-success">Save</button>
            <a href="${SITE_URL}/admin/customer" class="btn btn-danger">Back</a>
    
</form>
<%@include file="../shared/header.jsp" %>