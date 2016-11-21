package Mapper;

import java.util.ArrayList;
import java.util.Iterator;

import Domaine.Personne;

public class PersonneProxy extends ArrayList<Personne> {
	ArrayList<Personne> inst = null;
	int id;
	
	public PersonneProxy(int id){
		this.id=id;
	}
	static PersonneMapper pm = PersonneMapper.getInstance();

	public void initialized(){
		if(inst == null){
			System.out.println("On recupere tous les fils de " + id);
			inst = pm.findChilds(id);
			id++;
		}
	}
	public Iterator<Personne> iterator() {
		initialized();
		return inst.iterator();
	}
}
