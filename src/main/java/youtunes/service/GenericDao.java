package youtunes.service;

import java.util.List;

public interface GenericDao<E, K> 
{
	void add (E entity); // create 
	
	List<E> list(); // read 
	
	E find(K key); // read 
	
	void update (E entity); // update
	
	void remove(K key); // delete 
}
