<%@page import="com.liferay.dynamic.data.mapping.model.DDMFormInstance"%>
<%@page import="com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<h2>Portlet form override</h2>

<% 
DDMFormInstance formInstance = (DDMFormInstance) request.getAttribute("formInstance");
%>

<script>
jQuery(document).ready(function() {
    var formInstanceId = jQuery("#<portlet:namespace />formInstanceId").val();
    console.log("Form Instance ID: " + formInstanceId);
});
/* $('[data-ddmforminstanceid="32980"] .ddm-form-builder-app').addClass('sampleForm') */

</script>


<%-- <liferay-ddm:form-renderer formInstanceId="<%= formInstanceId %>" namespace="<portlet:namespace />" />


<input type="hidden" id="<portlet:namespace />formInstanceId" value="<%= formInstanceId %>" />

<div data-ddmforminstanceid="<%= formInstanceId %>">
    <div class="sampleForm">
        <%= formInstanceId %>
    </div>
</div>


<script>
jQuery(document).ready(function () {
    var formInstanceId = jQuery("#<portlet:namespace />formInstanceId").val();  
    console.log("Form Instance ID: " + formInstanceId);
    
    var targetForm = jQuery(`[data-ddmforminstanceid="${formInstanceId}"] .sampleForm`);    
    if (targetForm.length > 0) {
        targetForm.css({
            "background": "#f0f8ff",
            "border": "solid 1px #ccc",
            "box-shadow": "0 6px 12px 0 rgba(0, 0, 0, 0.15)",
            "transition": "all 0.3s ease-in-out",
            "width": "40%",
            "border-radius": "15px",
            "margin-top": "30px",
            "padding": "20px"
        });
        
        targetForm.hover(
            function () {
                jQuery(this).css({
                    "box-shadow": "0 8px 16px 0 rgba(0, 0, 0, 0.3)",
                    "transform": "translateY(-5px)"
                });
            },
            function () {
                jQuery(this).css({
                    "box-shadow": "0 6px 12px 0 rgba(0, 0, 0, 0.15)",
                    "transform": "translateY(0)"
                });
            }
        );
    } else {
        console.log("No form found with the specified formInstanceId.");
    }
});


</script>

<style>
.form-input {
    display: block;
    width: calc(100% - 20px);
    margin: 10px 0;
    padding: 10px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

label {
    font-weight: bold;
    margin-bottom: 5px;
    display: block;
}

textarea.form-input {
    resize: vertical;
    height: 100px;
}

</style> --%>
