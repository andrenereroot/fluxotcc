
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Aluno implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdAluno", nullable=false)
    private Integer idAluno;
    
    @Column (name="Nome", nullable = false, length = 80 )
    private String nome;
    
    @Column(name="Matricula", nullable=false)
    private Integer matricula;
    
    @Column (name="Telefone", nullable = false, length = 15 )//(034)-8888-8888
    private String telefone;
   
    @Column (name="Email", nullable = false, length = 80 )
    private String email;
   
    @Column (name="Periodo", nullable = true, length = 20 )
    private String periodo;

    public Aluno(Integer idAluno, String nome, Integer matricula, String telefone, String email, String periodo) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.periodo = periodo;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.idAluno != null ? this.idAluno.hashCode() : 0);
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
        final Aluno other = (Aluno) obj;
        if (this.idAluno != other.idAluno && (this.idAluno == null || !this.idAluno.equals(other.idAluno))) {
            return false;
        }
        return true;
    }
    
    
}
