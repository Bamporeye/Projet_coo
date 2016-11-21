package Main;

import java.util.ArrayList;

import Domaine.Personne;
import Mapper.PersonneMapper;

public class Main {
	PersonneMapper PM= new PersonneMapper();
	ArrayList<Personne> lespersonnes= PM.findChilds(1);
	for(Personne p : lespersonnes)
		System.out
}
