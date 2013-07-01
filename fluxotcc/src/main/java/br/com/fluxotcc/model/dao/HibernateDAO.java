
package br.com.fluxotcc.model.dao;


import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;


// classe que está implementado todos os metodos da interfaceDAO passando um T como parametro
public class HibernateDAO<T> implements InterfaceDAO<T>, Serializable {

    //atributo estático final(não pode mudar) do tipo long
    private static final long serialVersionUID = 1L;
    
    //atributo de tipo Class com parametro T para receber a classe
    private Class<T> classe;
    //atriburo do tipo Session para receber a sessão do hibernate
    private Session session;

    /*metodo construtor do HibernateDAO que recebe como paremetro a classe e a sessão do hibernate
    para poder inicializar junto com a classe.
    sempre que voce fazer uma instáncia dessa classe você vai ser obrigado a passar uma classe do tipo T que pode ser qualquer
    entidade e uma sessão*/
    public HibernateDAO(Class<T> classe, Session session) {
        super(); //super por que estou herdando
        this.classe = classe;
        this.session = session;
    }
    
    
    @Override
    public void save(T entity) {
        session.save(entity);
    }

    @Override
    public void update(T entity) {
        session.update(entity);
    }

    @Override
    public void remove(T entity) {
        session.delete(entity); 
    }

    @Override
    public void merge(T entity) {
        session.merge(entity);
    }

    //getEntity vai obter uma entidade
    @Override
    public T getEntity(Serializable id) {
        T entity = (T)session.get(classe, id);
        return entity;
    }

    //vai receber uma sessão e vai me trazer um único resultado
    @Override
    public T getEntityByDetachedCriteria(DetachedCriteria criteria) {
        T entity = (T)criteria.getExecutableCriteria(session).uniqueResult();
        return entity;
    }

        
    @Override
    public T getEntityByHQLQuery(String stringQuery) {
        Query query = session.createQuery(stringQuery);        
        return (T) query.uniqueResult();
    }

    @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
    }
    
    @Override
    public List<T> getEntities() {
        List<T> enties = (List<T>) session.createCriteria(classe).list();
        return enties;
    }    
    
}
