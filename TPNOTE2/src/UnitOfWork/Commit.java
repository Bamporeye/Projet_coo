package UnitOfWork;

import Domaine.Personne;
import Mapper.PersonneMapper;

public class Commit extends Visiteur{
	
	public void visiter(Personne p) {
			PersonneMapper.getInstance().update(p);
		}
	}