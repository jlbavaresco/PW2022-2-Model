package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorgebavaresco@ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TesteListarCidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("PW2022-2-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Cidade> lista = 
                em.createQuery("from Cidade order by nome").getResultList();
        for (Cidade c : lista) {
            System.out.println("ID: " + c.getId() + " Nome: " + c.getNome()
                    + " Estado: " + c.getEstado().getNome());
        }        
        em.close();
        emf.close();
    }

}
