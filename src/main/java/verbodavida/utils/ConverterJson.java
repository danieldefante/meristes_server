package verbodavida.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.Column;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class ConverterJson {

	public static <T> String consultDBToJson(List<T> listConsult) {

		JsonArray dataJson = new JsonArray();
		Gson gson = new Gson();

		listConsult.forEach(campo -> {
			dataJson.add(gson.toJson(campo));
		});

		return dataJson.toString();

	}

	public static void jsonToParams(JsonArray dataJson) {
	}

	public static JSONObject entityToJson(Object obj) {
		JSONObject jo = new JSONObject();
		
		try {

			Class clazz = obj.getClass();

			for (Method m : clazz.getDeclaredMethods()) {
				if (m.isAnnotationPresent(Column.class) && m.invoke(obj) != null) {
					String name = ((m.getName().substring(0, 4).toLowerCase()).substring(3))
							.concat(m.getName().substring(4));

					jo.put(name, m.invoke(obj).toString());

				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return jo;
	}

	public static <T> T jsonToEntity(Class<T> clazz, String data) {
		JSONObject jo = new JSONObject(data);

		 
		String[] namesFields = JSONObject.getNames(jo);
		 
		
		for (String name : namesFields) {
			
			
			System.out.println("set".concat((name.substring(0,1).toUpperCase()).concat(name.substring(1))));
		}
		
		Method[] methods = clazz.getMethods();
		
		
		
		for (Method method : methods) {
			
			if (!method.isAnnotationPresent(Column.class) && method.getName().substring(0, 3).equals("set") ) {
				System.out.println(method.getName());
				
			}
		}

		
		return null;
	}
	
	
//	public static void main(String[] args) {
//		JSONObject data = new JSONObject();
//		
//		data.put("teste1", "1");
//		data.put("teste2", "2");
//		data.put("teste3", "3");
//		data.put("teste4", "4");
//		
//		jsonToEntity(Ministerio.class, data.toString());
//	}
}