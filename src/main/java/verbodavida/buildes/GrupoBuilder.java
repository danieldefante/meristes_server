package verbodavida.buildes;

import verbodavida.entities.Grupo;

public class GrupoBuilder {

	private Grupo grupo = new Grupo();
	
	public GrupoBuilder withIdGrupo(Long idGrupo) {
		grupo.setIdGrupo(idGrupo);
		return this;
	}

	public GrupoBuilder withNome(String nome) {
		grupo.setNome(nome);
		return this;
	}

	public GrupoBuilder withDescricao(String descricao) {
		grupo.setDescricao(descricao);
		return this;
	}

	public Grupo build() {
		return grupo;
	}

}
