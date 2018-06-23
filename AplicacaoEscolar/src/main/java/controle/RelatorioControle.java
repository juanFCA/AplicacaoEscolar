/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.RelatorioDao;
import dominio.Aluno;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author juan
 */
public class RelatorioControle {
    
    private final PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);  
    
    private final RelatorioDao relatorioDao;
    
    private String nomeTurma;
    private List<Aluno> alunosTabelas;
    
    public RelatorioControle() {
        relatorioDao = new RelatorioDao();
        alunosTabelas = ObservableCollections.observableList(new ArrayList<>());
    }
    
    public final void listarAlunosTurma(String opcaoOrdem) {
       alunosTabelas.clear();
       alunosTabelas.addAll(relatorioDao.listarAlunosTurma(nomeTurma, opcaoOrdem));
    }

    public List<Aluno> getAlunosTabelas() {
        return alunosTabelas;
    }

    public void setAlunosTabelas(List<Aluno> alunosTabelas) {
        this.alunosTabelas = alunosTabelas;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.addPropertyChangeListener(e);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
}
