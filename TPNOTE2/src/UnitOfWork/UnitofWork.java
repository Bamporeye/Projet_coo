package UnitOfWork;

import java.util.HashSet;
import java.util.Set;


public class UnitofWork {
	Set<IDomainObject> dirty; 
	static UnitofWork inst = null;
	public UnitofWork() {
		dirty = new HashSet<IDomainObject>();
	}
	public static UnitofWork getInstance() {
		if (inst == null)
			inst = new UnitofWork();
		return inst;
	}
	// on peut specifier d autre methodes ici par exemple si une liste d object on va gerer ca dans cette methode de action
	public void action(IDomainObject o) {
		dirty.add(o);
	}
	public void commit() {
		Visiteur v = new Commit();
		for (IDomainObject o : dirty) {
			v.visiter(o);
		}
		dirty.clear();
	}
}
