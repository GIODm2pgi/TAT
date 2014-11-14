package fr.ujf.hashcode.monitor;

public enum Event {
	modification("modification"), setModifiable("setModifiable"), setNotModifiable("setNotModifiable");
	
	private String name;
	Event (String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
