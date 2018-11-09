package controller;

import static spark.Spark.get;
import static spark.Spark.post;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

import model.UserModel;
import spark.ResponseTransformer;
/**
 * @author neilsonlima@gmail.com
 *
 */
public class UserController {
	public UserController() {
		get("/api/user", (req, res) -> "User controller");

		post("/api/user", (req, res) -> {
			//            final UsuarioEntity usuarioExistente = usuarioService.getUser(req.queryParams("login"));
			//           if (usuarioExistente != null) {
			//               return "Já existe um usuário com o Login informado: " + req.queryParams("login");
			//           }
			//           usuarioService.criaUsuario(req.queryParams("nome"), req.queryParams("login"),
			//               req.queryParams("senha")
			//           );
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session session = sf.openSession();
			
			session.beginTransaction();
			UserModel user = new UserModel();
			user.setEmail("neilsonlima@gmail.com");
			user.setCpf("1");
			
			session.save(user);
			
			return "email: " + req.queryParams("email") + " senha: " + req.queryParams("password");
		});
		
		post("/api/user/login", (req, res) -> {
			//            final UsuarioEntity usuarioExistente = usuarioService.getUser(req.queryParams("login"));
			//           if (usuarioExistente != null) {
			//               return "Já existe um usuário com o Login informado: " + req.queryParams("login");
			//           }
			//           usuarioService.criaUsuario(req.queryParams("nome"), req.queryParams("login"),
			//               req.queryParams("senha")
			//           );
			return "sucess";
		}, json());		
	}
	
	// Private 
    private static String toJson( final Object object) {
        return new Gson().toJson(object);
    }	
    private static ResponseTransformer json() {
        return UserController::toJson;
    }	
}
