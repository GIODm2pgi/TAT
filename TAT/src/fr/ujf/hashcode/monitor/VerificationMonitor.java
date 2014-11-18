package fr.ujf.hashcode.monitor;

import java.util.ArrayList;
import java.util.List;


public class VerificationMonitor {

	private static final int DEFAULT_ID = -1;
	private int id;

	private List<Integer> listSet = new ArrayList<Integer>();
	
	private State currentState = State.Modifiable;
	
	public VerificationMonitor() {
		this.id = DEFAULT_ID;
	}

	public VerificationMonitor (int id) {
		this.id = id;
	}

	public void updateState(Event e, Integer i) {
		switch (this.currentState) {
		case Modifiable:
			switch (e) {
			case modificationColl:
				break;
			case addSet:
				listSet.add(i);
				this.currentState = State.NotModifiable;
				break;
			default: 
				break;
			}
			break;
		case NotModifiable:
			switch (e) {		
			case modificationColl:
				this.currentState = State.Error;
				break;
			case addSet:
				listSet.add(i);
				break;
			case removeSet:
				listSet.remove((Integer) i);
				if (listSet.isEmpty())
					this.currentState = State.Modifiable;
				break;
			}
			break;
		case Error:
			// No need to execute any code.
			break;
		}
	}

	public Verdict currentVerdict () {
		switch(this.currentState) {
		case Modifiable:
		case NotModifiable:
			return Verdict.CURRENTLY_TRUE;
		case Error:
			return Verdict.FALSE;
		default:
			return Verdict.FALSE;
		}
	}

	public void emitVerdict () {
		System.out.println("Monitor "+this.id+": "+currentVerdict());
	}

	public Verdict receiveEvent(Event e, Integer i) {
		System.out.println("=> Monitor "+this.id+": received event "+e);
		updateState(e, i);
		emitVerdict();
		return currentVerdict();
	}
}

