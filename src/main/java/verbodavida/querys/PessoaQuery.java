package verbodavida.querys;

public class PessoaQuery {

	public static String getQueryCountRegisters() {
		
		return new StringBuilder()
				.append(" SELECT COUNT(*) FROM pessoa ")
				.toString();
	}

	public static String getPaged() {
		return new StringBuilder()
				.append(" SELECT idpessoa AS \"idPessoa\", nome , sobrenome FROM pessoa ORDER BY nome ASC ")
				.toString();
	}

}