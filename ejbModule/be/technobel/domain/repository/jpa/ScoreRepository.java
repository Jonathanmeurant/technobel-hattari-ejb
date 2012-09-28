package be.technobel.domain.repository.jpa;

import javax.ejb.Stateless;


import be.technobel.domain.entity.Score;
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

}
