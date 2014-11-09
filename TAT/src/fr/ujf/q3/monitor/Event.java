package fr.ujf.q3.monitor;

public enum Event {
	open ("open"), close("close"), write("wirte"), read("read");
	
	private String name;
	Event (String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
