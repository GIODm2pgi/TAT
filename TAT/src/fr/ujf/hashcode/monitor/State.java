package fr.ujf.hashcode.monitor;

public enum State {
	Modifiable("Modifiable"), NotModifiable("NotModifiable"), Error("Error");
	
	private String name;
	State (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
