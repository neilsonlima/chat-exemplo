package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Dao {


	protected SessionFactory sf = null;
	public Dao(){
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {

			sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}		
	}
}
