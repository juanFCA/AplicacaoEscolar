/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import dominio.Aluno;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juan
 */
public class RelatorioDao {
    
    private final EntityManager em;

    public RelatorioDao() {
        this.em = Conexao.getEntityManager();
    }
     
   
    public List<Aluno> listarAlunosTurma(String nomeTurma, String opcaoOrdem) {
        return em.createQuery("select a from Aluno a join a.turma t where t.nome like"+"'"+nomeTurma+"' order by a."+opcaoOrdem).getResultList();
    }
    
}
