package be.technobel.domain.repository.interfaces;



import java.util.List;

public interface GenericRepository<T> {

	T find(int id);
	
	List<T> findAll();
	
	T save(T obj);

	void delete(T obj);

	void delete(int id);
	
	int count();
	
}
