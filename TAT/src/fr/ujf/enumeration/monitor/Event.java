package fr.ujf.enumeration.monitor;

public enum Event {
	nextElement("nextElement"), init("init"), update("update");
	
	private String name;
	
	Event (String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
