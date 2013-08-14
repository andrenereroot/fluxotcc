
package br.com.fluxotcc.controller;


import br.com.fluxotcc.model.dao.HibernateDAO;
import br.com.fluxotcc.model.dao.InterfaceDAO;
import br.com.fluxotcc.model.entities.Cidade;
import br.com.fluxotcc.util.FacesContextUtil;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


//anatoção para ter suporte ao jsf
@ManagedBean(name="mbCidade")
//escopo do MbCidade vai ser escopo de sessão
@SessionScoped

public class MbCidade implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;

    public MbCidade() {
    }
    
    private InterfaceDAO<Cidade> cidadeDAO(){
    InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
    return cidadeDAO;
     }
    
    
     public String limpCidade() {
        cidade = new Cidade();
        return editCidade();
    }
    
    
    //abre a pagina de edição de cidade que está me /restrict/cadastrarcidade.faces
     public String editCidade() {
        return "/restrict/cadastrarcidade.faces";
    }
    
      public String addCidade() {
        if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0) {
            insertCidade();
        } else {
            updateCidade();
        }
       
        limpCidade();
        return null;
    }
      

    private void insertCidade() {
        cidadeDAO().save(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateCidade() {
        cidadeDAO().update(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
               new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

  public void deleteCidade(){
  cidadeDAO().remove(cidade);
  }
  
    public List<Cidade> getCidades() {
        cidades = cidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

 
}
