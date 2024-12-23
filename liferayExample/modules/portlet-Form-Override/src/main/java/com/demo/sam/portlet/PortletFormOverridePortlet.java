package com.demo.sam.portlet;

import com.demo.sam.constants.PortletFormOverridePortletKeys;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Suchismita
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PortletFormOverride",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PortletFormOverridePortletKeys.PORTLETFORMOVERRIDE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PortletFormOverridePortlet extends MVCPortlet {
	
	@Reference
    private MyFormService _myFormService;
	
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
        long formInstanceId = ParamUtil.getLong(actionRequest, "formInstanceId");

        DDMFormInstance formInstance = _myFormService.getFormInstanceById(formInstanceId);

        // Do something with the formInstance object
        // For example, set form fields as request attributes
        actionRequest.setAttribute("formInstance", formInstance);
}
}