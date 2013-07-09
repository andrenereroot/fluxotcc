
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "processo")
public class Processo implements Serializable{
    
private static final long serialVersionUID =  1L;  

@Id
@GeneratedValue 
@Column(name = "IdProcesso", nullable = false)
private Integer idProcesso;

@Column(name = "Justificativa", length = 2000)
private String justificativa;

}
