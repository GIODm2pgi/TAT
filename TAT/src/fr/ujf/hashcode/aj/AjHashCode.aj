package fr.ujf.hashcode.aj;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import fr.ujf.hashcode.monitor.Event;
import fr.ujf.hashcode.monitor.Verdict;
import fr.ujf.hashcode.monitor.VerificationMonitor;

@SuppressWarnings("rawtypes")
public aspect AjHashCode {

	public final static boolean enabled = true;

	HashMap<Integer, VerificationMonitor> collectionMap = new HashMap<Integer, VerificationMonitor>();
	
	public Verdict dispatchEvent(String concreteEventName, Integer c) {

		Verdict v = null;

		if (!this.collectionMap.containsKey(c)) {
			VerificationMonitor monitor = new VerificationMonitor (c.hashCode());
			collectionMap.put(c, monitor);
		}

		switch (concreteEventName) {
		case "setModifiable":
			v = collectionMap.get(c).receiveEvent(Event.setModifiable);
			break;
		case "setNotModifiable":
			v = collectionMap.get(c).receiveEvent(Event.setNotModifiable);
			break;
		case "modification":
			v = collectionMap.get(c).receiveEvent(Event.modification);
			break;
		default:
			//unrecognized event => do nothing
			break;
		}
		return v;
	}

	pointcut addToSet(Set s, Collection c): call (boolean Set.add(*)) && target(s) && args(c) && if(enabled);
	pointcut removeFromSet(Set s, Collection c): call (boolean Set.remove(*)) && target(s) && args(c) && if(enabled);
	pointcut modificationToCollection1(Collection c, String s): call (boolean Collection.add(*)) && target(c) && args(s) && if(enabled);
	pointcut modificationToCollection2(Collection c, String s): call (boolean Collection.remove(*)) && target(c) && args(s) && if(enabled);
	
	before(Set s, Collection c) : addToSet(s,c) {
		dispatchEvent("setNotModifiable", System.identityHashCode(c));
	}
	
	before(Set s, Collection c) : removeFromSet(s,c) {
		dispatchEvent("setModifiable", System.identityHashCode(c));
	}
	
	before(Collection c, String s) : modificationToCollection1(c,s) {
		dispatchEvent("modification", System.identityHashCode(c));
	}
	
	before(Collection c, String s) : modificationToCollection2(c,s) {
		dispatchEvent("modification", System.identityHashCode(c));
	}
	
}
