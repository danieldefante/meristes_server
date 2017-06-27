package verbodavida.eao;

import java.util.List;

import org.json.JSONArray;

import verbodavida.utils.ConsultDB;
import verbodavida.utils.ConverterJson;

public class PessoaEAO {

	public static String findAll() {
		
//		List<teste> listPessoas = ConsultDB.findAll(teste.class);
//		String a = ConverterJson.consultDBToJson(listPessoas);
	

	      JSONArray  ja = new JSONArray();

	        ja.put("sdfsd");
	        ja.put("serviço");
	        ja.put("retorno");
	        ja.put("teste");
	        ja.put("bioid");
	        
	        return ja.toString();
	}

}
