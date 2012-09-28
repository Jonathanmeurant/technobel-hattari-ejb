package be.technobel.domain.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;


import be.technobel.domain.entity.Score;
import be.technobel.domain.exceptions.RepositoryException;
import be.technobel.domain.repository.interfaces.score.ScoreRepositoryLocal;
import be.technobel.domain.repository.jpa.generic.GenericRepositoryJpa;

/**
 * @author jonmeu
 *
 */
/**
 * Session Bean implementation class ScoreRepository
 */
@Stateless(name = "ScoreRepositoryBean")
public class ScoreRepository extends GenericRepositoryJpa<Score>  implements ScoreRepositoryLocal {

    /**
     * Default constructor. 
     */
    public ScoreRepository() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public List<Score> findRange(int start, int length) {
		if(start == 0 || length ==0){
			throw new RepositoryException("REPOSITORY findRange("+pcName+" obj) - Invalid parameter");
		}
		TypedQuery<Score> tq = em.createQuery("SELECT T FROM "+pcName+" AS T Limit"+ start+","+ length , persistenceClass);
		return tq.getResultList();
	}

	@Override
	public List<Score> findScoreRange(int minGames, int start, int length) {
		if(start == 0 || length ==0|| minGames==0){
			throw new RepositoryException("REPOSITORY findRange("+pcName+" obj) - Invalid parameter");
		}
		TypedQuery<Score> tq = em.createQuery("SELECT T FROM "+pcName+" AS T where T.nbrPlay="+minGames+" Limit"+ start+","+ length, persistenceClass);
		return tq.getResultList();
	}
}
