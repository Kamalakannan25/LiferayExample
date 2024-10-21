create table BUILD_Student (
	uuid_ VARCHAR(75) null,
	stuId LONG not null primary key,
	stuName VARCHAR(75) null,
	stuAddress VARCHAR(75) null,
	stuAge INTEGER,
	stuJoinDate DATE null,
	stuPhoneNo LONG
);