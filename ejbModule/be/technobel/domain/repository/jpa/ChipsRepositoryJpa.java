package be.technobel.domain.repository.jpa;


import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import be.technobel.domain.entity.Chips;
import be.technobel.domain.exceptions.ValidationException;
import be.technobel.domain.repository.interfaces.chips.ChipsRepositoryLocal;
import be.technobel.domain.repository.jpa.generic.GenericRepositoryJpa;

/**
 * Session Bean implementation class ChipsRepository
 */
@Stateless(name = "ChipsRepositoryBean")
public class ChipsRepositoryJpa extends GenericRepositoryJpa<Chips> implements ChipsRepositoryLocal {

    /**
     * Default constructor. 
     */
    public ChipsRepositoryJpa() {
        
    }

	@Override
	public Chips findByName(String name) {
		if(name ==null || name.trim().length() ==0){
			throw new ValidationException("Invalid name");
		}
		TypedQuery<Chips> query = em.createNamedQuery("Chips.findByName", Chips.class);
		query.setParameter("name", name);		
		return query.getSingleResult();
	}

}
