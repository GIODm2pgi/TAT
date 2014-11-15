package fr.ujf.hashcode.monitor;


public class VerificationMonitor {

	private static final int DEFAULT_ID = -1;
	private int id;

	private State currentState = State.Modifiable;
	
	public VerificationMonitor() {
		this.id = DEFAULT_ID;
	}

	public VerificationMonitor (int id) {
		this.id = id;
	}

	public void updateState(Event e) {
		switch (this.currentState) {
		case Modifiable:
			switch (e) {
			case setNotModifiable: 
				this.currentState = State.NotModifiable;
				break;
			case setModifiable:
			case modification:
				break;
			}
			break;
		case NotModifiable:
			switch (e) {
			case setModifiable:
				this.currentState = State.Modifiable;
				break;			
			case modification:
				this.currentState = State.Error;
				break;
			case setNotModifiable:
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

	public Verdict receiveEvent(Event e) {
		System.out.println("=> Monitor "+this.id+": received event "+e);
		updateState(e);
		emitVerdict();
		return currentVerdict();
	}
}
