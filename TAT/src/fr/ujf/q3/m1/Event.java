package fr.ujf.q3.m1;

public enum Event {
	hasNext ("hasNext"), next("next");
	
	private String name;
	Event (String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
