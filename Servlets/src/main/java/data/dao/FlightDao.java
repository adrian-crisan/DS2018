package data.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import data.beans.Flight;

public class FlightDao {

	public Flight createFlight(Flight flight) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer id = null;
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(flight);
			flight.setId(id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flight;
	}
	
	@SuppressWarnings("unchecked")
	public Flight findFlight(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Flight> flights = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Flight WHERE id = :id");
			query.setParameter("id", id);
			flights = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return flights != null && !flights.isEmpty() ? flights.get(0) : null;
	}
	
	public Flight deleteFlight(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Flight flight = this.findFlight(id);
		try {
			tx = session.beginTransaction();
			Flight flightToDelete = (Flight) session.get(Flight.class, id);
			session.delete(flightToDelete);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		
		} finally {
			session.close();
		}
		return flight;
	}
	
	public Flight updateFlight(Flight flight) {
		Session session = HibernateUtil .getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(flight);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return flight;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flight> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Flight> flights = null;
		try {
			tx = session.beginTransaction();
			flights = session.createQuery("FROM Flight").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return flights;
	}
}
