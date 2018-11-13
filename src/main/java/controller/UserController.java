package controller;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.google.gson.Gson;

import model.UserModel;
import spark.ResponseTransformer;
/**
 * UserController é um classe responsável por controlar todas as ações dos usuários
 * 
 * @author neilsonlima@gmail.com
 *
 */
public class UserController {

	protected SessionFactory sf = null;

	/**
	 * Todas as rotas de usuários são criados no construtor da classe UserController
	 */
	public UserController() {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}	

		get("/api/user", (req, res) -> "User controller");

		post("/api/user", (req, res) -> {
			String result = "success";
			UserModel user = new UserModel();
			user.setEmail(req.queryParams("email"));
			user.setCpf(req.queryParams("cpf"));
			Session session = sf.openSession();			
			try {
				session.beginTransaction();
				session.save(user);
				session.getTransaction().commit();
			} catch (Exception e) {
				result =e.getMessage();
			}finally {
				session.close();
			}
			return result;
		}, json());

		post("/api/user/login", (req, res) -> {
			UserModel user = new UserModel();
			user.setEmail(req.queryParams("email"));
			user.setCpf(req.queryParams("cpf"));

			String hql = "FROM UserModel WHERE email = :email AND cpf = :cpf";

			Session session = sf.openSession();			
			session.beginTransaction();

			Query<UserModel> query = session.createQuery(hql, UserModel.class);

			query.setParameter("email", user.getEmail());
			query.setParameter("cpf", user.getCpf());
			List<UserModel> list = query.list();

			session.getTransaction().commit();
			session.close();			

			if(list.size() > 0) {
				return "success";
			} else {
				return "error";
			}

		}, json());		
	}

	// Private 
	
	/**
	 * Método responsável em passar um string para json
	 * 
	 * @param object
	 * @return
	 */
	private static String toJson( final Object object) {
		return new Gson().toJson(object);
	}	
	/**
	 *  Método responsável em transforma a resposta em json 
	 * @return
	 */
	private static ResponseTransformer json() {
		return UserController::toJson;
	}	
}
