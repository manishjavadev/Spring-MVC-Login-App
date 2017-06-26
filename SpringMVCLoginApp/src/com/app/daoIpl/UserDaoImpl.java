package com.app.daoIpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.UserDao;
import com.app.entity.UserRegistration;

@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int register(UserRegistration userregistration) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int count = (Integer) session.save(userregistration);
		tx.commit();
		return count;
	}

	public UserRegistration login(String mail) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		UserRegistration ur = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from UserRegistration where mail='" + mail + "'");
			ur = (UserRegistration) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ur;
	}

	public List<UserRegistration> allUser() {

		List<UserRegistration> list = new ArrayList<UserRegistration>();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		UserRegistration ur1 = null;
		tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from UserRegistration");
		list = (List<UserRegistration>) query.list();
		return list;
	}
}
