package com.abc.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abc.entities.SchoolEntity;
import com.abc.entities.StudentEntity;

public class StudentRepository {

	private SessionFactory sessionFactory;

	public void save(SchoolEntity student) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	public StudentEntity getById(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		StudentEntity p = (StudentEntity) session.get(StudentEntity.class, id);

		session.getTransaction().commit();
		session.close();
		return p;
	}

	public List<StudentEntity> getByRollNum(String rollNum) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select p from StudentEntity p where p.rollNum =:rollNum");
		query.setParameter("rollNum", rollNum);

		List<StudentEntity> students = query.list();

		session.getTransaction().commit();
		session.close();

		return students;
	}

	public void update(StudentEntity student) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.merge(student);
		session.getTransaction().commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
