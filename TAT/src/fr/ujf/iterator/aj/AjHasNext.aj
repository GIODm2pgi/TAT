package fr.ujf.iterator.aj;

import fr.ujf.iterator.monitor.Event;
import fr.ujf.iterator.monitor.Verdict;
import fr.ujf.iterator.monitor.VerificationMonitor;

public aspect AjHasNext {
	
	public final static boolean enabled = true;

	VerificationMonitor monitor = new VerificationMonitor ();

	public Verdict dispatchEvent(String concreteEventName) {
		
		Verdict v = null;
		
		switch (concreteEventName) {
		case "hasNext":
			v = this.monitor.receiveEvent(Event.hasNext);
			break;
		case "next":
			v = this.monitor.receiveEvent(Event.next);
			break;
		default:
			//unrecognized event => do nothing
			v = this.monitor.currentVerdict();
			break;
		}
		return v;
	}

	pointcut hasNext(): call (boolean java.util.Iterator.hasNext()) && if(enabled);
	pointcut next(): call (Object java.util.Iterator.next()) && if(enabled);

	before() : hasNext() {
		dispatchEvent("hasNext");
	}

	before() : next() {
		dispatchEvent("next");
	}

}
