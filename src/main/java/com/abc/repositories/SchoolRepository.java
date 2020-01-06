package com.abc.repositories;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abc.entities.SchoolEntity;

public class SchoolRepository {
	private SessionFactory sessionFactory;

	public SchoolEntity getSchoolByName(String name) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query q = session.createQuery("select se from SchoolEntity se where se.name =:name");
		q.setParameter("name", name);

		SchoolEntity se = (SchoolEntity) q.uniqueResult();
		session.getTransaction().commit();
		session.close();

		return se;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}