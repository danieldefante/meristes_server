package verbodavida.utils;

public class CrudRespost {
	
	public static String respost(String msg, Boolean respost, Long idReturn) {
		return "{\"message\":\""+ msg +"\", \"success\":"+ respost +", \"idReturn\":\"" + idReturn +"\"}";
	}
	
}
