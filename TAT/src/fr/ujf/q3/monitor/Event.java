package fr.ujf.q3.monitor;

public enum Event {
	openWrite ("openWrite"), openRead ("openRead"), write("wirte"), read("read"), close("close");
	
	private String name;
	Event (String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
