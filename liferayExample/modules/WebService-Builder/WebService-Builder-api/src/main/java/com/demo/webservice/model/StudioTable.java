/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Studio_Studio&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Studio
 * @generated
 */
public class StudioTable extends BaseTable<StudioTable> {

	public static final StudioTable INSTANCE = new StudioTable();

	public final Column<StudioTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudioTable, Long> studioId = createColumn(
		"studioId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StudioTable, String> cameraName = createColumn(
		"cameraName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudioTable, String> cameraModel = createColumn(
		"cameraModel", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudioTable, Long> cameraPrice = createColumn(
		"cameraPrice", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private StudioTable() {
		super("Studio_Studio", StudioTable::new);
	}

}