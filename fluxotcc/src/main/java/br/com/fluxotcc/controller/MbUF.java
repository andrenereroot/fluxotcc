
package br.com.fluxotcc.controller;


import br.com.fluxotcc.model.dao.HibernateDAO;
import br.com.fluxotcc.model.dao.InterfaceDAO;
import br.com.fluxotcc.model.entities.UF;
import br.com.fluxotcc.util.FacesContextUtil;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


//anatoção para ter suporte ao jsf
@ManagedBean(name="mbUF")
//escopo do MbCidade vai ser escopo de sessão
@SessionScoped

public class MbUF implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private UF uf = new UF();
    private List<UF> ufs;

    public MbUF() {
    }
    
    private InterfaceDAO<UF> ufDAO(){
    InterfaceDAO<UF> ufDAO = new HibernateDAO<UF>(UF.class, FacesContextUtil.getRequestSession());
    return ufDAO;
     }
    
    
     public String limpUF() {
        uf = new UF();
        return editUF();
    }
    
    
    //abre a pagina de edição de cidade que está me /restrict/cadastrarestado.faces
     public String editUF() {
        return "/restrict/cadastrarestado.faces";
    }
    
      public String addUF() {
        if (uf.getIdUF()== null || uf.getIdUF()== 0) {
            insertUF();
        } else {
            updateUF();
        }
       
        limpUF();
        return null;
    }
      

    private void insertUF() {
        ufDAO().save(uf);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateUF() {
        ufDAO().update(uf);
        FacesContext.getCurrentInstance().addMessage(null,
               new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

  public void deleteUF(){
  ufDAO().remove(uf);
  }
  
    public List<UF> getUFs() {
        ufs = ufDAO().getEntities();
        return ufs;
    }

    public void setUFs(List<UF> ufs) {
        this.ufs = ufs;
    }

    public UF getUF() {
        return uf;
    }

    public void setUF(UF uf) {
        this.uf = uf;
    }

 
}
