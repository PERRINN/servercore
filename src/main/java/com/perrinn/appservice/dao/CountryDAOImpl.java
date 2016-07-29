package com.perrinn.appservice.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.perrinn.appservice.geo.Country;

public class CountryDAOImpl {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
        if( sessionFactory == null)
            throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
        return sessionFactory;
    }
    
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Country c) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(c);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Country> list() {
		Session session = this.sessionFactory.openSession();
		List<Country> countryList = session.createQuery("from country").list();
		session.close();
		return countryList;
	}
}