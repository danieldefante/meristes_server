package verbodavida.validators;

public interface IValidador<T> {

	Boolean camposObrigatorios(T entity);
}
