package crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
         return entityManager.find(Aluno.class, id);
       }


       public void persist(Aluno aluno) {
    	   try {
			entityManager.getTransaction().begin();
			entityManager.persist(aluno);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
       }

       public Aluno update(Aluno aluno) {
    	   Aluno upd_aluno = null;
    	   try {
			entityManager.getTransaction().begin();
			upd_aluno = entityManager.merge(aluno);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
    	   return upd_aluno;
       }
       
       public void removeById(int id) {
    	 try {
			entityManager.getTransaction().begin();
			Aluno aluno = entityManager.find(Aluno.class, id);
			entityManager.remove(aluno);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
       }
       
       public List<Aluno> selectHql(String nome) {
    	   Query query = entityManager.createQuery("FROM Aluno WHERE nome = :nome");
    	   query.setParameter("nome", nome);
    	   List<Aluno> listAluno = query.getResultList();
    	   return listAluno;
       }
}
