package com.solstice.common.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.solstice.common.constants.AppBaseConstantsWeb;
import com.solstice.contact.web.representations.ContactRepresentation;

public abstract class AbstractRepresentation {

	@XmlElement(name = "link", namespace = "")
	protected List<Link> links;

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(Link... links) {
		this.links = Arrays.asList(links);
	}

	public void createLinks(String... params) {
		this.links = new ArrayList<>();
		if (this instanceof ContactRepresentation) {
			this.links.add(new Link("application/json", "DELETE", "delete",
					AppBaseConstantsWeb.SERVICES_URL + "contact/" + params[0]));
			this.links.add(new Link("application/json", "GET", "refresh",
					AppBaseConstantsWeb.SERVICES_URL + "contact/" + params[0]));
			this.links.add(new Link("application/json", "PUT", "modify",
					AppBaseConstantsWeb.SERVICES_URL + "contact/" + params[0]));
		}
	}
}
