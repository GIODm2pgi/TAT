package fr.ujf.q3.monitor;

public enum State {
	NotStarted("NotStarted"), Opened("Opened"), Closed("Closed"), Error("Error");
	
	private String name;
	State (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
