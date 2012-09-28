package be.technobel.domain.repository.jpa;


import be.technobel.domain.entity.Chips;
import be.technobel.domain.repository.interfaces.chips.ChipsRepositoryLocal;
import be.technobel.domain.repository.jpa.generic.GenericRepositoryJpa;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ChipsRepository
 */
@Stateless(name = "ChipsRepositoryBean")
public class ChipsRepository extends GenericRepositoryJpa<Chips> implements ChipsRepositoryLocal {

    /**
     * Default constructor. 
     */
    public ChipsRepository() {
        // TODO Auto-generated constructor stub
    }

}
