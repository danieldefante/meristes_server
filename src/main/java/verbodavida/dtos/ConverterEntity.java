package verbodavida.dtos;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class ConverterEntity {
	
	public static <T,R> R converterEntity(Class<R> clazz, T entity) {
		return new ModelMapper().map(entity, clazz);
	}

	public static <T,R> List<R> converterEntetyToListVO(Class<R> clazz, List<T> entitys) {
		
		List<R> listReturn = new ArrayList<R>();
		ModelMapper modelMapper = new ModelMapper();

		entitys.forEach(entity -> {
			
			listReturn.add(modelMapper.map(entity, clazz));
			
		});
		
		return listReturn;
	}
}


/*
PessoaEntidade pessoaEntidade = obterPessoa();
ModelMapper mapper = new ModelMapper();
mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        
Converter<EnderecoEntidade, String> conversor = new Converter<EnderecoEntidade, String>() {
 
    public String convert(MappingContext<EnderecoEntidade, String> context) {
         EnderecoEntidade entidade = context.getSource();
         return entidade.getRua() + " " + entidade.getNumero() +  " " + 
               entidade.getComplemento() + " " + entidade.getCep();
     }
;
 
mapper.addConverter(conversor);
 
PessoaDTO dto = mapper.map(pessoaEntidade, PessoaDTO.class);
 
System.out.println("Nome: " + dto.getNome());
System.out.println("Endereco: " + dto.getEndereco().getEnderecoCompleto());*/