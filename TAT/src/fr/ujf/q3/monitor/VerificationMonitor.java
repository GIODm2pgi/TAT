package fr.ujf.q3.monitor;


public class VerificationMonitor {

	private static final int DEFAULT_ID = -1;
	private int id;
	
	private State currentState = State.NotStarted;
	
	public VerificationMonitor() {
		this.id = DEFAULT_ID;
	}
	
	public VerificationMonitor (int id) {
		this.id = id;
	}

	public void updateState(Event e) {
		switch (this.currentState) {
		case NotStarted:
			switch (e) {
			case open:
				this.currentState = State.Opened;
				break;
			default: 
				this.currentState = State.Error;
				break;
			}
			break;
		case Opened:
			switch (e) {
			case close:
				this.currentState = State.Closed;
				break;
			default:
				break;
			}
			break;
		case Closed:
			switch (e) {
			case open:
				this.currentState = State.Opened;
				break;
			default:
				this.currentState = State.Error;
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
		case NotStarted:
		case Opened:
		case Closed:
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

