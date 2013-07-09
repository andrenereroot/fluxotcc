
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcao")
public class Funcao implements Serializable{
    
private static final long serialVersionUID = 1L;   

@Id
@GeneratedValue
@Column(name="IdFuncao", nullable=false)
private Integer idFuncao;

@Column (name="Funcao", nullable = false, length = 30 )
private String funcao;

    public Funcao() {
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.idFuncao != null ? this.idFuncao.hashCode() : 0);
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
        final Funcao other = (Funcao) obj;
        if (this.idFuncao != other.idFuncao && (this.idFuncao == null || !this.idFuncao.equals(other.idFuncao))) {
            return false;
        }
        return true;
    }
    
    

}
