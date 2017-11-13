package com.solstice.common.constants;

import java.util.Properties;

import org.apache.cxf.endpoint.Server;

public class AppBaseConstantsWeb {
	// Application Constants
	public static int BYTES_FOR_ENCRIPTION = 512;
	public static String APPLICATION_NAME = "AppSolsticeDemo";
	public static String DATE_FORMAT = "MM/dd/yyyy";
	public static String DATETIME_FORMAT = "MM/dd/yyyy HH:mm";
	// COMMON VARIABLES
	public static Properties LINKS_PROPERTIES = null;
	public static String SERVICES_URL = null;
	// VARIABLES FOR JUNIT
	public final static String ENDPOINT_ADDRESS = "local://services";
	public static Server LOCAL_TEST_SERVER;
	public final static String ENCODED_IMAGE = "UklGRs4EAABXRUJQVlA4IMIEAAAQQQCdASrgASwBPtlkpVCoJSMip1+4EQAbCWlu4XHYn6iNMRczgIVmjeUAkPeTvQ95O9D3k5jKlpKYvfeT3mU/tpyqECubKDOcxses4WhL+qSlwHymsfLomgD2SIsrLcV9KmzhaEv6pKgaoBUPeNHGiQg9O3gUz69xx1DavD8OBUPcCSmoiypWwjnaeO9rAL6JD94FQ94Nsg940qav/OU9LpzsEtnq7EBBaxUFPQL+HAqCnn0RAz6oQ/eWCmoGbTYeEfHPmKTLNKCnjm3QOBUO7ZzxcDN5Gdx7k1iFclYFCVhrvxpU8c26BwKg+DlvXvjBlS1b1gzNoZ2UxER9cT0Du/BtkHvGlMARHlumfBsNKG59z+2JI9GjyB6B3fjR4Foeyp5EPMygqEBqabiZibjAM1DC2y8ZXHegd191N1PQOszv6Ms/+LNlFNnlD4SlXIHAqHuBJTURZUq47vJ2n7hMLoajt18kcVuiypmlBMwaPIHApfWH2J1MCA5tFQU9A65WqoKegXY8otB5Trf2TboRZUzSgmYNHkDgOg2dClUHeO0NMYKQ7yFrQU9A7r7qbqeK5TpXhI96xoqC3rgdNFpNgfuLyaKBwKV9Fik512/9OrkONFQU9A6zfy+qF6KSpyDSpp+YcBJUyP1GLKmaUFPQOs3Rs440tDoG+VbVrGz7VpUzSgp6B3fjFwEH7loxQO4AAP79Hk2Jl08ihYwLCoCvCHrJwFM/xTR6PM40qeaqGMTJh5EpBYEAm89hqNWs82uaxPFjpGiUqHeNuHMRauE7ZEvKIVCSdEk4iNwSRn3TpqHa1BdNEcDUCVfu/eDDyugYCH1rLjybS1W5Ui3ElJ6Knodrh7k7gSCx52wIMM/B7+G2LuRsyXRqudQrDi72lmwNope0GR1QMmvLK7Vfl8ETEq/2vV6T+kMk3Dv/ZupDkYBp2LISz8AcQi3+igDker9q5gQtue+a4KmweFVe+COwFPzLcB/ne0bYHjwKdq5vUUAfGali+V2hxV7YlNUlMZcJjFymAR5jnAsJdsaAfsV2uKbiKCzG76RdVxkEoEj94XtRhIPdLwPOz6yDQ0P1/Wkz/w+YKwyCQ5qaJFRWYVSGnduq1o8EI6+X1iYwCDU7MGaxrHJeqOoWu+XZNC3fFS69KPh/3+ae3MjrtMKUh95N6PbF2GRN4xr0JNrD7l5/dtYtapvfB3WajCHGhV3eMU3j0Q+7ARHV36QsToSvmYOPrpypjMJcDKn21Te71YxEaaWUZ9bzMpj0J4cPtLBGtjF2eUoN/kIhia0+zF3RXOY9iNOGI5om2RdH0g07+UjtPf1lIyg/C60sszOxsioEeD7aGg00F/hNrjE6LBnlk79ny76+0GLejBo1ZF3R3BtJ49SJO9To2VOjbjWalEkhgOf8KQMFLjy57AFISkBmcNrUmqPqKsoq6Fu05p3NruAkWd3un+yZ8wgWxgdAiJWdLIQqEyIAg5tawjSPK7zw97xHnVtSLg6HA1Nk56GigR+HrG6Tb9AOpmkedSAiZtbGeiW4UZE+cMxgRKQ7tPHYoUQtgCF1IvtsBFTTONL449dN02+jU7DSxRyU4pddlV60eAB/GUN7dU4wCgrCxw9afhdAAAA=";
	// Server Variables
	public final static String RESPONSE_TYPE_TESTING = "application/json";
	public static String SYSTEM_SEPARATOR = System.getProperty("file.separator");
	public static String IMAGES_PATH = SYSTEM_SEPARATOR + "opt" + SYSTEM_SEPARATOR + "img" + SYSTEM_SEPARATOR;
	public static String PROFILE_PICTURE_EXTENSION = ".png";
}
