
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
   
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "IdUsuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "Login", unique=true, length = 40)
    private String login;
    
    @Column(name = "Senha", length = 40)
    private String senha;

    @Column (name="Email", nullable = false, length = 80 )
    private String email;
  
    @Column (name="Nome", nullable = false, length = 80 )
    private String nome;
    
    @Column (name="CPF", nullable = false, length = 14 )
    private String cpf;
    
    //relacionamento entre  usuario parecer
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @ForeignKey(name = "UsuarioParecer")
    private List<Parecer> pareceres;
    
    @ManyToOne(optional=false)
    @ForeignKey(name = "CidadeUsuario") 
    @JoinColumn(name="IdCidade", referencedColumnName = "IdCidade")
    private Cidade cidade;
    
    //RELACIONAMENTO MUITOS PARA MUITOS ENTRE USUARIOS E FUNCAO
    @ManyToMany(mappedBy ="usuario",fetch = FetchType.LAZY )
    @ForeignKey(name = "UsuarioFuncao")
    @JoinTable(name = "Usuario_Funcao")
    @JoinColumn(name = "IdFuncao",referencedColumnName = "IdFuncao" )
    private List<Funcao> funcoes;

    public Usuario() {
    }

    
    
    public Usuario(Integer idUsuario, String login, String senha, String email, String nome, String cpf, List<Parecer> pareceres, Cidade cidade) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.pareceres = pareceres;
        this.cidade = cidade;
    }
    

   

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Parecer> getPareceres() {
        return pareceres;
    }

    public void setPareceres(List<Parecer> pareceres) {
        this.pareceres = pareceres;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.idUsuario != null ? this.idUsuario.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario && (this.idUsuario == null || !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }
   
    
   
}
