package dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.UserModel;
import validation.UserValidation;

public class UserDao extends Dao{

	public UserModel create(UserModel user) throws Exception {
		if(UserValidation.validation(user)) {

			Session session = sf.openSession();			
			session.beginTransaction();

			session.save(user);
			session.getTransaction().commit();
			session.close();
		} else {
			return null;
		}
		return user;
	}

	public boolean login(UserModel user) throws Exception {
		boolean isValid = false;
		String hql = "FROM UserModel WHERE email = :email AND cpf = :cpf";
		Session session = sf.openSession();			
		try {
			session.beginTransaction();
			Query<UserModel> query = session.createQuery(hql, UserModel.class);
			query.setParameter("email", user.getEmail());
			query.setParameter("cpf", user.getCpf());
			List<UserModel> list = query.list();

			if(list.size()> 0) {
				isValid = true;
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			isValid = false;
		}finally {
			session.close();			
		}
		return isValid;
	}

}
