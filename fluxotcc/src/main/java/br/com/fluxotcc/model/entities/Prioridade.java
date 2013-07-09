
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name = "prioridade")
public class Prioridade implements Serializable{
      
private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  @Column(name = "IdPrioridade",nullable = false)
  private Integer idPrioridade;
  
  @Column(name = "Nome", nullable = true, length = 10)
  private String nome;
  
  
   //relacionamento entre  processo e prioridade
    @OneToMany(mappedBy = "prioridade", fetch = FetchType.LAZY)
    @ForeignKey(name = "PrioridadeProcesso")
    private List<Processo> processos;

    public Prioridade() {
    }

    public Integer getIdPrioridade() {
        return idPrioridade;
    }

    public void setIdPrioridade(Integer idPrioridade) {
        this.idPrioridade = idPrioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.idPrioridade != null ? this.idPrioridade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prioridade other = (Prioridade) obj;
        if (this.idPrioridade != other.idPrioridade && (this.idPrioridade == null || !this.idPrioridade.equals(other.idPrioridade))) {
            return false;
        }
        return true;
    }
  
  
  
}
