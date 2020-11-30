package de.dhbwka.database.bigdata.pagerank;

import java.util.*;

public class WebPage {
	private final String irl;
	private final Set<WebPage> linksTo = new HashSet<>();

	public WebPage(String irl) {
		this.irl = irl;
	}

	public String getIrl() {
		return this.irl;
	}

	public void addLinkTo(WebPage object) {
		linksTo.add(object);
	}

	public boolean islinkedTo(WebPage object) {
		return linksTo.contains(object);
	}

	public int getLinkCount() {
		return linksTo.size();
	}

}
