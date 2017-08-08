package verbodavida.querys;

public class PessoaQuery {

	public static String getQueryCountRegisters() {
		
		return new StringBuilder()
				.append(" select count(*) from Pessoa ")
				.toString();
	}

}