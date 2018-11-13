package validation;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.UserModel;

public class UserValidation {
	public static boolean validation(UserModel user) throws Exception {

		if(isCpf(user.getCpf()) == false){

			throw new Exception("cpf invalido");
		}
		
		if(isEmail(user.getEmail()) == false) {
			throw new Exception("email invalido");
		}
		
		return true;
	}



	private static boolean isCpf(String cpf) {
		if (cpf.equals("00000000000") ||
				cpf.equals("11111111111") ||
				cpf.equals("22222222222") || cpf.equals("33333333333") ||
				cpf.equals("44444444444") || cpf.equals("55555555555") ||
				cpf.equals("66666666666") || cpf.equals("77777777777") ||
				cpf.equals("88888888888") || cpf.equals("99999999999") ||
				(cpf.length() != 11))
			return(false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {              
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0         
				// (48 eh a posicao de '0' na tabela ASCII)         
				num = (int)(cpf.charAt(i) - 48); 
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
				num = (int)(cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else dig11 = (char)(r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return(true);
			else return(false);
		} catch (InputMismatchException erro) {
			return(false);
		}
	}
	public static boolean isEmail(String email)
    {
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
		return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
				cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
	}
}
