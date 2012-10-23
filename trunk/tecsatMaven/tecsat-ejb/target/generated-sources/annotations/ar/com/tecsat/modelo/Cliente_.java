package ar.com.tecsat.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile ListAttribute<Cliente, Transporte> transportes;
	public static volatile SingularAttribute<Cliente, String> cliMail;
	public static volatile ListAttribute<Cliente, Operador> operadors;
	public static volatile SingularAttribute<Cliente, Integer> cliId;
	public static volatile SingularAttribute<Cliente, String> cliNombre;

}

