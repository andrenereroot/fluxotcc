
package br.com.fluxotcc.model.dao;



import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

// interface que vai ser implementada por todas as classes que forem acessar o banco
public interface InterfaceDAO<T> {
    
    //metodos básicos para efetuar o crud
    void save (T entity);
    void update (T entity);
    void remove (T entity);
    void merge (T entity);
    
    // getEntity vai recuperar um objeto e vai receber como paremetro um id serializado
    T getEntity(Serializable id);
    
    //vai pegar uma entidade, e recebe como parametro DetachedCriteria criteria
    T getEntityByDetachedCriteria(DetachedCriteria criteria);
    T getEntityByHQLQuery(String stringQuery);
    
    // Lista do tipo T que vai referir a qualquer entidade e o getEntities pega todas as entidades. Exatamente todas, sem restiçõa.
    List<T> getEntities();
    
    
    List<T> getListByDetachedCriteria(DetachedCriteria criteria);    
    
}
