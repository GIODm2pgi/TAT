package fr.ujf.enumeration.monitor;

import java.util.HashMap;

import fr.ujf.enumeration.monitor.State;


public class VerificationMonitor {

	private static final int DEFAULT_ID = -1;
	private int id;

	public static HashMap<Integer, Integer> dsState = new HashMap<Integer, Integer>();
	private Integer state;
	private Integer ds;
	
	private State currentState = State.Normal;
	
	public VerificationMonitor() {
		this.id = DEFAULT_ID;
	}

	public VerificationMonitor (int id) {
		this.id = id;
	}

	public void updateState(Event e, Integer v) {
		switch (this.currentState) {
		case Normal:
			switch (e) {
			case init:
				this.ds = v;
				this.state = dsState.get((Integer) v);
				break;
			case nextElement: {
				Integer state1 = this.state;
				Integer state2 = dsState.get(this.ds);
				if (state1 != state2)
					this.currentState = State.Error;
				break;
			}
			default:
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
		case Normal:
			return Verdict.CURRENTLY_TRUE;
		case Error:
			return Verdict.FALSE;
		default:
			return Verdict.FALSE;
		}
	}

	public void emitVerdict () {
		//System.out.println("Monitor "+this.id+": "+currentVerdict());
	}

	public Verdict receiveEvent(Event e, Integer i) {
		//System.out.println("=> Monitor "+this.id+": received event "+e);
		updateState(e,i);
		emitVerdict();
		return currentVerdict();
	}
}

