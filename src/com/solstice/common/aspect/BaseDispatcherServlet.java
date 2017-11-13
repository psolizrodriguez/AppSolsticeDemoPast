package com.solstice.common.aspect;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.web.servlet.DispatcherServlet;

import com.solstice.common.constants.AppBaseConstantsWeb;

public class BaseDispatcherServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		if (AppBaseConstantsWeb.SERVICES_URL == null) {
			InetAddress ip;
			try {
				ip = InetAddress.getLocalHost();
				AppBaseConstantsWeb.PROJECT_URL = "http://" + ip.getHostAddress() + ":8080/"
						+ AppBaseConstantsWeb.APPLICATION_NAME + "/";
				AppBaseConstantsWeb.SERVICES_URL = AppBaseConstantsWeb.PROJECT_URL + "services/";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}