package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorgebavaresco@ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TesteRemoverEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("PW2022-2-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {

            Estado e = em.find(Estado.class, 1);
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("\n\nErro: " + 
                    e.getCause().getCause().getCause().getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }

}
