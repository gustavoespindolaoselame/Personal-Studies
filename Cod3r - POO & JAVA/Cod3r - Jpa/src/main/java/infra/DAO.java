package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.consulta.NotaFilme;

public class DAO<E> {
	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private Class<E> classe;
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("Cod3r - JPA");
		} catch (Exception e) {
			System.out.println("Dumb error here:");
			throw new RuntimeException(e);
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public DAO<E> teste(){
		return this;
	}
	
	public DAO<E> abrirTransacao(){
		entityManager.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharTransacao(){
		entityManager.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		entityManager.persist(entidade);
		return this;
	}
	
	public DAO<E> desacoplar(E entidade){
		entityManager.detach(entidade);;
		return this;
	}
	
	public DAO<E> enviar(E entidade){
		entityManager.merge(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade){
		return this.abrirTransacao().incluir(entidade).fecharTransacao();
	}
	
	public E obterPorID(Object id) {
		return entityManager.find(classe, id);
	}
	
	public List<E> obterTodos(){
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int limit, int offset){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}
		System.out.println("select e from " + classe.getName() + " e");
		TypedQuery<E> query = entityManager.createQuery("select e from " + classe.getName() + " e", classe);
		query.setMaxResults(limit);
		query.setFirstResult(offset);
		return query.getResultList();
	}
	
	public List<E> consultar(String nomeConsulta, Object... params){
		TypedQuery<E> query = entityManager.createNamedQuery(nomeConsulta, classe);
		for(int i = 0; i < params.length; i +=2) {
			System.out.println(params[i].toString() + " - " + params[i+1]);
			query.setParameter(params[i].toString(), params[i+1]);
		}
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params){
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public void fechar(){
		entityManager.close();
	}
}
