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

	public Verdict dispatchEvent(String concreteEventName, Integer c, Integer i) {

		Verdict v = null;

		if (!this.collectionMap.containsKey(c)) {
			VerificationMonitor monitor = new VerificationMonitor (c.hashCode());
			collectionMap.put(c, monitor);
		}

		switch (concreteEventName) {
		case "modificationColl":
			v = collectionMap.get(c).receiveEvent(Event.modificationColl, i);
			break;
		case "addSet":
			v = collectionMap.get(c).receiveEvent(Event.addSet, i);
			break;
		case "removeSet":
			v = collectionMap.get(c).receiveEvent(Event.removeSet, i);
			break;
		default:
			//unrecognized event => do nothing
			break;
		}
		return v;
	}

	pointcut addSet(Set t, Collection a): call (* Set.add( * )) && target(t) && args(a) && if(enabled) && !within(AjHashCode) && within(fr.ujf.hashcode.*);
	pointcut removeSet(Set t, Collection a): call (* Set.remove( * )) && target(t) && args(a) && if(enabled) && !within(AjHashCode) && within(fr.ujf.hashcode.*);
	pointcut addCollection(Collection t, Object a): call (* Collection.add( * )) && target(t) && args(a) && if(enabled) && !within(AjHashCode) && within(fr.ujf.hashcode.*);
	pointcut removeCollection(Collection t, Object a): call (* Collection.remove( * )) && target(t) && args(a) && if(enabled) && !within(AjHashCode) && within(fr.ujf.hashcode.*);

	before(Collection t, Object a) : addCollection(t,a) {
		if (!(t instanceof Set))
			dispatchEvent("modificationColl", System.identityHashCode(t), null);
	}

	before(Collection t, Object a) : removeCollection(t,a) {
		if (!(t instanceof Set))
			dispatchEvent("modificationColl", System.identityHashCode(t), null);
	}

	before(Set t, Collection a) : addSet(t,a) {
		dispatchEvent("addSet", System.identityHashCode(a), System.identityHashCode(t));
	}

	before(Set t, Collection a) : removeSet(t,a) {
		dispatchEvent("removeSet", System.identityHashCode(a), System.identityHashCode(t));
	}
}
