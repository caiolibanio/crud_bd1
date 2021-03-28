package crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * 
 * @author caio 
 * Os métodos de acesso aos dados aqui no DAO ficarão em branco, para ir discutindo e 
 * escrevendo eles com os alunos durante a aula
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

       @SuppressWarnings("unchecked")
       public List<Aluno> findAll() {
         return entityManager.createQuery("FROM " +
         Aluno.class.getName()).getResultList();
       }

       public void persist(Aluno aluno) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public Aluno update(Aluno aluno) {
    	 Aluno upd_Cliente = null;
         try {
            entityManager.getTransaction().begin();
            upd_Cliente = entityManager.merge(aluno);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
         return upd_Cliente;
       }

       public void remove(Aluno aluno) {
         try {
            entityManager.getTransaction().begin();
            aluno = entityManager.find(Aluno.class, aluno.getMatricula());
            entityManager.remove(aluno);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(int id) {
         try {
            Aluno aluno = getById(id);
            remove(aluno);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}
