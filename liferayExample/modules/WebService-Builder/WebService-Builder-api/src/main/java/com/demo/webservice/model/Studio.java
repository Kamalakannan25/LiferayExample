/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Studio service. Represents a row in the &quot;Studio_Studio&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StudioModel
 * @generated
 */
@ImplementationClassName("com.demo.webservice.model.impl.StudioImpl")
@ProviderType
public interface Studio extends PersistedModel, StudioModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.demo.webservice.model.impl.StudioImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Studio, Long> STUDIO_ID_ACCESSOR =
		new Accessor<Studio, Long>() {

			@Override
			public Long get(Studio studio) {
				return studio.getStudioId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Studio> getTypeClass() {
				return Studio.class;
			}

		};

}