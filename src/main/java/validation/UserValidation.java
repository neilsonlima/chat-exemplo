package validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.validation.CPFValidator;
import model.UserModel;

public class UserValidation {
	public static boolean validation(UserModel user) throws Exception {
		System.out.println(isCpf(user.getCpf()));
		if(isCpf(user.getCpf())){
			throw new Exception("cpf invalido");
		}
			
		if(isEmail(user.getEmail()) == false) {
			throw new Exception("email invalido");
		}
		
		return true;
	}

	private static boolean isCpf(String cpf) {
		CPFValidator validator = new CPFValidator();
		try {
			validator.assertValid(cpf);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isEmail(String email) {
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}

	public static String imprimeCPF(String cpf) {
		return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
				+ cpf.substring(9, 11));
	}
}
