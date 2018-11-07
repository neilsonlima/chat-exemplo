package controller;

import static spark.Spark.*;

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
			return "email: " + req.queryParams("email") + " senha: " + req.queryParams("password");
		});
	}
}
