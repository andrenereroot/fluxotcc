
package br.com.fluxotcc.model.entities;

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
@Table(name="cidade")
public class Cidade {
    
    private static final long serialVersionUID =  1L; 
    
    @Id
    @GeneratedValue
    @Column(name="IdCidade", nullable=false)
    private Integer idCidade;
    
    @Column(name="Nome", length=80, nullable=false)
    private String nome;
    
    //relacionamento entre cidade e usuarios
    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadeUsuario")
    private List<Usuario> usuarios;
    
    
    //relacionamento entre cidade e campi
    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadeCampi")
    private List<Campi> campis;
    
    //relacionamento entre cidade e uf
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadeUF") 
    @JoinColumn(name="IdUF", referencedColumnName = "IdUF")
    private UF uf;

    public Cidade() {
    }

   

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public List<Campi> getCampis() {
        return campis;
    }

    public void setCampis(List<Campi> campis) {
        this.campis = campis;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
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
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }
    
    
}
