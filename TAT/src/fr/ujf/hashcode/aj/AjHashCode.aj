package fr.ujf.hashcode.aj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import fr.ujf.hashcode.monitor.Event;
import fr.ujf.hashcode.monitor.Verdict;
import fr.ujf.hashcode.monitor.VerificationMonitor;

@SuppressWarnings("rawtypes")
public aspect AjHashCode {

	public final static boolean enabled = true;

	HashMap<Integer, VerificationMonitor> collectionMap = new HashMap<Integer, VerificationMonitor>();

	HashMap<Integer, List<Integer>> mapCollToColls = new HashMap<Integer, List<Integer>>();

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

	pointcut addSet(Set t, Collection a): call (* Set.add( * )) && target(t) && args(a) && if(enabled) && !within(AjHashCode);
	pointcut removeSet(Set t, Collection a): call (* Set.remove( * )) && target(t) && args(a) && if(enabled) && !within(AjHashCode);
	pointcut addCollection(Collection t, Object a): call (* Collection.add( * )) && target(t) && args(a) && if(enabled) && !within(AjHashCode);
	pointcut removeCollection(Collection t, Object a): call (* Collection.remove( * )) && target(t) && args(a) && if(enabled) && !within(AjHashCode);

	before(Collection t, Object a) : addCollection(t,a) {
		dispatchEvent("modification", System.identityHashCode(t));
	}
	
	before(Collection t, Object a) : removeCollection(t,a) {
		dispatchEvent("modification", System.identityHashCode(t));
	}

	before(Set t, Collection a) : addSet(t,a) {
		if (mapCollToColls.containsKey(System.identityHashCode(a))){
			mapCollToColls.get(System.identityHashCode(a)).add(System.identityHashCode(t));
		}
		else {
			mapCollToColls.put(System.identityHashCode(a), new ArrayList<Integer>());
			mapCollToColls.get(System.identityHashCode(a)).add((Integer) System.identityHashCode(t));
			dispatchEvent("setNotModifiable", System.identityHashCode(a));
		}

	}

	before(Set t, Collection a) : removeSet(t,a) {
		mapCollToColls.get(System.identityHashCode(a)).remove((Integer) System.identityHashCode(t));
		if (mapCollToColls.get(System.identityHashCode(a)).size() == 0)		
			dispatchEvent("setModifiable", System.identityHashCode(a));

	}
}