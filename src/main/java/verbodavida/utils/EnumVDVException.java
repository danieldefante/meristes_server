package verbodavida.utils;

public enum EnumVDVException {
	ESCALA_EM_CONFLITO("DSFSDFSDF"),
	ESCALA_SAVE_SUCCESS("Escala salva com Sucesso!"),
	ESCALA_SAVE_ERROR("Erro ao cadastrar a Escala!"),
	
	MINISTERIO_SAVE_SUCCESS("O Ministério foi salvo com Sucesso!"),
	MINISTERIO_SAVE_ERROR("Erro ao cadastrar o Ministério!"),
	MINISTERIO_DELETE_SUCCESS("O Ministério foi excluído com Sucesso!"),
	MINISTERIO_DELETE_ERROR("Erro ao excluir o Ministério!"),
	
	PESSOA_SAVE_SUCCESS("A Pessoa foi salva com Sucesso!"),
	PESSOA_SAVE_ERROR("Erro ao cadastrar a Pessoa!"),
	PESSOA_DELETE_SUCCESS("A Pessoa foi excluído com Sucesso!"),
	PESSOA_DELETE_ERROR("Erro ao excluir a Pessoa!"),

	VINCULOPESSOAGRUPO_SAVE_SUCCESS("A Pessoa foi vinculada com sucesso ao Ministério!"),
	VINCULOPESSOAGRUPO_DESVINCULAR_SUCCESS("A Pessoa foi desvinculada com sucesso do Ministério!"),
	VINCULOPESSOAGRUPO_SAVE_ERROR("Erro ao vinculada a Pessoa ao Ministério!"),
	
	GRUPO_SAVE_SUCCESS("A Pessoa foi vinculada com sucesso ao Ministério!"),
	GRUPO_SAVE_ERROR("Erro ao vinculada a Pessoa ao Ministério!"),
	
	
	
	;
	
	private final String msg;       

    private EnumVDVException(String msg) {
        this.msg = msg;
    }
    
    public String getMsg(){
    	return msg;
    }

}
