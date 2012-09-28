/**
 * 
 */
package be.technobel.domain.repository.jpa.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.technobel.domain.exceptions.RepositoryException;
import be.technobel.domain.repository.interfaces.GenericRepository;


public abstract class GenericRepositoryJpa<T> implements GenericRepository<T> {

	@PersistenceContext(unitName="HattaryEJB") // unitName specified in persistence.xml
	protected EntityManager em;
	
	protected Class<T> persistenceClass;
	protected String pcName;
	
	@SuppressWarnings("unchecked")
	public GenericRepositoryJpa() {
		
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.pcName = persistenceClass.getSimpleName();
		
	}
	

	public T find(int id){
		
		return em.find(persistenceClass, id); // EntityManager find method, not ours
		
	}
	
	public List<T> findAll() {
		
		TypedQuery<T> tq = em.createQuery("SELECT T FROM "+pcName+" AS T", persistenceClass);
		return tq.getResultList();
		
	}
	
	public void delete(int id) {
		
		T entity = em.find(persistenceClass, id);
		em.remove(entity);
		
	}
	
	public T save(T t) {
		
		if(t == null) throw new RepositoryException("REPOSITORY save("+pcName+" obj) - Invalid parameter");
		
		return em.merge(t);
	
	}

	public void delete(T t) {
		
		if(t == null) throw new RepositoryException("REPOSITORY delete("+pcName+" obj) - Invalid parameter");
		
		em.remove(em.merge(t));
		
	}
	
	public int count() {
		
		Query q = em.createQuery( "SELECT COUNT FROM "+pcName);
		
		Integer r = (Integer) q.getSingleResult();
		
		return r.intValue();
		
	}
}
