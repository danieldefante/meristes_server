package verbodavida.validators;

import java.lang.reflect.Field;

import javax.ws.rs.core.Response.Status;

import verbodavida.utils.EnumVDVException;
import verbodavida.utils.OQJFException;

public class ValidatorFields {
	
	public static <T> void fieldsRequired(T entity, String... nameFields) {

		Class<?> clazz = entity.getClass();

		Field[] fieldsClass = clazz.getDeclaredFields();
		try {
			int j = 0;
			for (int i = 0; i < fieldsClass.length; i++) {

				if (fieldsClass[i].getName() == nameFields[j]) {
					fieldsClass[i] = clazz.getDeclaredField(nameFields[j]);
					fieldsClass[i].setAccessible(true);
					j++;
					if (fieldsClass[i].get(entity) == null) {

						throw new OQJFException(Status.NOT_ACCEPTABLE, EnumVDVException.FIELDS_OBRIGATORIOS.getMsg());
					}
				}
			}

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
