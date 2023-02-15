package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Computers;



public class ComputerHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ComputerInfo");
	
	
	public void insertItem(Computers ci) {
		
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(ci);
		
		em.getTransaction().commit();
		
		em.close();
		
		
	}

	public void deleteItem(Computers toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Computers> typedQuery = em.createQuery("select ci from Computers ci where ci.manufacturer = :selectedManufacturer and ci.type = :selectedType and ci.os = :selectedOS", Computers.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedManufacturer", toDelete.getManufacturer());
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedOS", toDelete.getOs());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		Computers result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em
		.close();
		
	}

	public List<Computers> searchForItemByManufacturer(String manufacturerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Computers> typedQuery = em.createQuery("select ci from Computers ci where ci.manufacturer = :selectedManufacturer", Computers.class);
		typedQuery.setParameter("selectedManufacturer", manufacturerName);
		List<Computers> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Computers> searchForItemByType(String typeName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Computers> typedQuery = em.createQuery("select ci from Computers ci where ci.type = :selectedType", Computers.class);
		typedQuery.setParameter("selectedType", typeName);
		List<Computers> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Computers> searchForItemByOS(String osName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Computers> typedQuery = em.createQuery("select ci from Computers ci where ci.os = :selectedOS", Computers.class);
		typedQuery.setParameter("selectedOS", osName);
		List<Computers> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public Computers searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Computers found = em.find(Computers.class, idToEdit);
		em.close();
		return found;
	}

	public List<Computers> showAllComputers() {
		EntityManager em = emfactory.createEntityManager();
		List<Computers> allItems = em.createQuery("SELECT i FROM Computers i").getResultList();
		return allItems;
	}

	public void cleanUp() {
		emfactory.close();
		
	}

	public void updateComputer(Computers toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

}
