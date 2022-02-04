package services;

public class LoginConfirmacao {

	public static boolean login(String tentativaUser, String tentativaSenha, String cadastroUser, String cadastroSenha) {
		if(tentativaUser.equals(cadastroUser) && tentativaSenha.equals(cadastroSenha)) {
			return true;
		}
		return false;
	}
}
