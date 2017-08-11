package verbodavida.querys;

public class PessoaQuery {

	public static String getQueryCountRegisters() {
		
		return new StringBuilder()
				.append(" SELECT COUNT(*) FROM pessoa ")
				.toString();
	}

}