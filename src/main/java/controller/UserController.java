package controller;

//import static spark.Spark.after;
//import static spark.Spark.exception;
import static spark.Spark.*;
//import static spark.Spark.post;
//import static spark.Spark.put;

public class UserController {
	public UserController() {
		get("/api/user", (req, res) -> "User controller");
	}
}
