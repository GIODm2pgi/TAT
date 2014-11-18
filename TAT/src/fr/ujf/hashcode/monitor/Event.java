package fr.ujf.hashcode.monitor;

public enum Event {
	modificationColl("modificationColl"), addSet("addSet"), removeSet("removeSet");
	
	private String name;
	Event (String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
