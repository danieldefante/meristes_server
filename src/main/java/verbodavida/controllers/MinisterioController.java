package verbodavida.controllers;

import java.util.List;
import verbodavida.eao.MinisterioEAO;
import verbodavida.entities.Ministerio;

public class MinisterioController implements IController<Ministerio>{

	private MinisterioEAO ministerioEAO = new MinisterioEAO();

	@Override
	public String insert(Ministerio ministerio) {
		return ministerioEAO.insert(ministerio);
	}

	@Override
	public String update(Ministerio ministerio) {
		return ministerioEAO.update(ministerio);
	}

	@Override
	public String delete(Long id) {
		return ministerioEAO.delete(id);
	}

	@Override
	public Ministerio find(Long id) {
		return ministerioEAO.find(Ministerio.class, id);
	}

	@Override
	public List<Ministerio> findAll() {
		return ministerioEAO.findAll(Ministerio.class);
	}

}