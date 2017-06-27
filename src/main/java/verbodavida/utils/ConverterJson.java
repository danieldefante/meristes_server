package verbodavida.utils;

import java.util.List;

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
}