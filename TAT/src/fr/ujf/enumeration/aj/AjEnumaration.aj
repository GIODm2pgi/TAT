package fr.ujf.enumeration.aj;

import java.util.HashMap;
import java.util.Vector;

import fr.ujf.enumeration.monitor.Event;
import fr.ujf.enumeration.monitor.Verdict;
import fr.ujf.enumeration.monitor.VerificationMonitor;
import fr.ujf.enumeration.resource.Enumeration;

@SuppressWarnings("rawtypes")
public aspect AjEnumaration {

	public final static boolean enabled = true;

	HashMap<Integer, VerificationMonitor> enumerationMap = new HashMap<Integer, VerificationMonitor>();

	public Verdict dispatchEvent(String concreteEventName, Integer e, Integer i) {

		Verdict v = null;

		if (!this.enumerationMap.containsKey(e)) {
			VerificationMonitor monitor = new VerificationMonitor (e.hashCode());
			enumerationMap.put(e, monitor);
		}

		switch (concreteEventName) {
		case "init":
			v = enumerationMap.get(e).receiveEvent(Event.init, i);
			break;
		case "nextElement":
			v = enumerationMap.get(e).receiveEvent(Event.nextElement, i);
			break;
		case "update":
			v = enumerationMap.get(e).receiveEvent(Event.update, i);
			break;
		default:
			//unrecognized event => do nothing
			break;
		}
		return v;
	}

	pointcut addDs(Vector t): call (* Vector.add( * )) && target(t) && if(enabled) && within(fr.ujf.enumeration.*);
	pointcut removeDs(Vector t): call (* Vector.remove( * )) && target(t) && if(enabled) && within(fr.ujf.enumeration.*);
	pointcut createEnum(Enumeration t, Vector a): call (* Enumeration.create( * )) && target(t) && args(a) && if(enabled) && within(fr.ujf.enumeration.*);
	pointcut nextEnum(Enumeration t): call (* Enumeration.nextElement()) && target(t) && if(enabled) && within(fr.ujf.enumeration.*);

	before(Vector t) : addDs(t) {
		dispatchEvent("update", (Integer) System.identityHashCode(t), (Integer) System.identityHashCode(t));
	}

	before(Vector t) : removeDs(t) {
		dispatchEvent("update", (Integer) System.identityHashCode(t), (Integer) System.identityHashCode(t));
	}

	before (Enumeration t, Vector a) : createEnum(t,a) {
		dispatchEvent("init", (Integer) System.identityHashCode(t), (Integer) System.identityHashCode(a));
	}

	before (Enumeration t) : nextEnum(t){
		dispatchEvent("nextElement", (Integer) System.identityHashCode(t), null);
	}
}
