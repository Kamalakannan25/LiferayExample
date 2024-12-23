package com.demo.sam.portlet;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

public class MyFormService {

	 public DDMFormInstance getFormInstanceById(long formInstanceId) throws PortalException {
	        return DDMFormInstanceLocalServiceUtil.getFormInstance(formInstanceId);
	    }
}
