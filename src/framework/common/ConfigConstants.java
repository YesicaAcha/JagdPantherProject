package framework.common;

import framework.utils.XmlReader;


public class ConfigConstants {
	static XmlReader xmlReader = new XmlReader();
	public static final String USER_MAIL = xmlReader.getData("FrameworkInformation","USER_MAIL");
	public static final String BROWSER = xmlReader.getData("FrameworkInformation","BROWSER");
	public static final String PASSWORD = xmlReader.getData("FrameworkInformation","PASSWORD");
	public static final String URL = xmlReader.getData("FrameworkInformation","URL");
	public static final String DB_URL = xmlReader.getData("DBInformation","DB_URL");
	public static final String DB_USER = xmlReader.getData("DBInformation","DB_USER");
	public static final String DB_PASSWORD = xmlReader.getData("DBInformation","DB_PASSWORD");
}