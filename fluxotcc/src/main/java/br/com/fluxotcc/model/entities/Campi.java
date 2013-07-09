
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "campi")
public class Campi implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdCampi", nullable = false)
    private Integer idCampi;
    
    @Column (name="Nome", nullable = false, length = 80 )
    private String nome;
    
  
    //relacionamento entre  campi e aluno
    @OneToMany(mappedBy = "campi", fetch = FetchType.LAZY)
    @ForeignKey(name = "CampiAluno")
    private List<Aluno> alunos;
    
    
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadeCampi")
    @JoinColumn(name = "IdCidade",referencedColumnName = "IdCidade")
    private Cidade cidade;

    public Campi() {
    }

    public Integer getIdCampi() {
        return idCampi;
    }

    public void setIdCampi(Integer idCampi) {
        this.idCampi = idCampi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.idCampi != null ? this.idCampi.hashCode() : 0);
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
        final Campi other = (Campi) obj;
        if (this.idCampi != other.idCampi && (this.idCampi == null || !this.idCampi.equals(other.idCampi))) {
            return false;
        }
        return true;
    }
    
    
}
