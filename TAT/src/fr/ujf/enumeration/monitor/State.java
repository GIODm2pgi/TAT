package fr.ujf.enumeration.monitor;

public enum State {
	Normal("Normal"), Error("Error");
	
	private String name;
	State (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
