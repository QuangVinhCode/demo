package register.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.*;

import register.model.User;
import register.utils.JpaUtils;

public class UserDAO {
	public void insert(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			em.persist(user);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
		
	}
	public void updeate(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			em.merge(user);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
		
	}
	public void delete(String userld) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			User user = em.find(User.class, userld);
			
			if (user != null)
			{
				em.remove(user);
			}else {
				throw new Exception("User ko tim thay");
			}
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
		
	}
	public User findByID(String userld) {
		EntityManager em = JpaUtils.getEntityManager();
		
		
		User user = em.find(User.class, userld);
		
		return user;
		
	}
	
	public List<User> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);

		return query.getResultList();
	}
	
	public List<User> findAll(int page,int pagesize) {
		EntityManager em = JpaUtils.getEntityManager();
		
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}
	
	public User checkLogin(String userId,int password) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select u from User u where u.Userld = :userId and u.Password = :password";
		
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		
		query.setParameter("userId", userId);
		query.setParameter("password", password);
		
		return query.getSingleResult();
	}
	
	public List<User> findByFullname(String fullname) {
		EntityManager em = JpaUtils.getEntityManager();
		
		String jqpl = "Select u from User u where u.Fullname like :fullname";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		
		query.setParameter("fullname", "%" + fullname + "%");
		
		return query.getResultList();
	}
	
	public int count() {
		EntityManager em = JpaUtils.getEntityManager();
		
		String jqpl = "Select count(u) from User u";
		Query query = em.createQuery(jqpl) ;
		
		return ((Long)query.getSingleResult()).intValue();
	}

}
