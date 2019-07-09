package data.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import data.beans.User;

public class UserDao {
	
	public User createUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer id = null;
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(user);
			user.setId(id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public User findUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<User> users = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE id = :id");
			query.setParameter("id", id);
			users = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return users != null && !users.isEmpty() ? users.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	public User findByUsername(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<User> users = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE username = :username");
			query.setParameter("username", username);
			users = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return users != null && !users.isEmpty() ? users.get(0) : null;
	}
	
	public User deleteUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		User user = this.findUser(id);
		try {
			tx = session.beginTransaction();
			User userToDelete = (User) session.get(User.class, id);
			session.delete(userToDelete);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		
		} finally {
			session.close();
		}
		return user;
	}
	
	public User updateUser(User user) {
		Session session = HibernateUtil .getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<User> users = null;
		try {
			tx = session.beginTransaction();
			users = session.createQuery("FROM User").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return users;
	}
}
