package verbodavida.resouces;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import verbodavida.utils.HibernateUtil;
import verbodavida.utils.PersistDB;
import verbodavida.vos.PessoaVO;

@Path("/teste")
public class TesteResouce{
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String findAll() {
		String name = null;
		
		System.out.println("teste");
		Session s = HibernateUtil.getSessionFactory().openSession();
		try{
			
			
			String sql = "SELECT p.nome as nome " +
					  "FROM Pessoa p ";
			
			
	
			List<PessoaVO> r = null;//PersistDB.executeSQLOneResult(sql, null, null);
			
			
//			List<PessoaVO> resultWithAliasedBean = s.createSQLQuery(sql).setResultTransformer( Transformers.aliasToBean(PessoaVO.class))
//					  .list();

					PessoaVO dto = r.get(0);
			
							 name = dto.getNome();
							
							
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("ERROR PersistDB -> " + e);
		} finally {
			s.clear();
			s.close();
		}
		
		
		
		return name;
	}

}
