package crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * 
 * @author caio 
 * Os métodos de acesso aos dados aqui no DAO estão em branco, para implementacao 
 * durante a aula.
 *
 */
public class AlunoDAO {

       private static AlunoDAO instance;
       protected EntityManager entityManager;

       public static AlunoDAO getInstance(){
         if (instance == null){
            instance = new AlunoDAO();
         }

         return instance;
       }

       private AlunoDAO() {
         entityManager = getEntityManager();
       }

       private EntityManager getEntityManager() {
        EntityManagerFactory factory =
        Persistence.createEntityManagerFactory("crud");
        if (entityManager == null) {
          entityManager = factory.createEntityManager();
        }

        return entityManager;
       }
       
       public Aluno getById(int id) {
    	 //TODO
         return new Aluno();
       }


       public void persist(Aluno aluno) {
    	   //TODO
       }

       public Aluno update(Aluno aluno) {
    	 //TODO
         return new Aluno();
       }

       public void remove(Aluno aluno) {
    	 //TODO
       }

       public void removeById(int id) {
    	 //TODO
       }
}
