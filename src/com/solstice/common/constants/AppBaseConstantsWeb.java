package com.solstice.common.constants;

import org.apache.cxf.endpoint.Server;

public class AppBaseConstantsWeb {
	// Application Constants
	public static int BYTES_FOR_ENCRIPTION = 512;
	public static String APPLICATION_NAME = "AppSolsticeDemo";
	public static String DATE_FORMAT = "MM/dd/yyyy";
	public static String DATETIME_FORMAT = "MM/dd/yyyy HH:mm";
	// COMMON VARIABLES
	public static String SERVICES_URL = null;
	public static String PROJECT_URL = null;
	public static String IMAGE_VIEWER_CONTROLLER = "viewContactPicture.html?contactId=";
	// VARIABLES FOR JUNIT
	public final static String ENDPOINT_ADDRESS = "local://services";
	public static Server LOCAL_TEST_SERVER;
	public final static String ENCODED_IMAGE = "iVBORw0KGgoAAAANSUhEUgAAASwAAAC7CAYAAADfaaM6AAAgAE…S0C1cu7qMbCYPRfE+sP4/n3toq+Cvo+EAAAAASUVORK5CYII=";
	// Server Variables
	public final static String RESPONSE_TYPE_TESTING = "application/json";
	public static String SYSTEM_SEPARATOR = System.getProperty("file.separator");
	public static String IMAGES_PATH = SYSTEM_SEPARATOR + "opt" + SYSTEM_SEPARATOR + "img" + SYSTEM_SEPARATOR;
	public static String PROFILE_PICTURE_EXTENSION = ".png";
}
