package UnitOfWork;


public class UowPersonne {
	public static interface Observateur {
		void action(IDomainObject o);
	}
	public static interface Observable {
		void add(Observateur o);
		void notifier();
	}
	public static interface Visitable {
		void accepter(Visiteur v);
	}
}