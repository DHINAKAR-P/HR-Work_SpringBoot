package com.hrapp.module.bootsecurity.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.hrapp.domain.core.InUser;
import com.hrapp.module.bootsecurity.idao.IGpUserDao;



@Repository
@Transactional
public class GpBootSecurityUserDao implements IGpUserDao {

	private Log log = LogFactory.getLog(getClass());

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public InUser findUser(String username){
		try{

			String login = "select * from InUser where username=:username";
			Query result = entityManager.createNativeQuery(login,InUser.class)
					.setParameter("username", username);
			List<InUser> list  = result.getResultList();
			System.out.println("size of user list : " + list.size());
			if (list.size() > 0) {
				InUser user_from_db = list.get(0);
				return user_from_db;
			}

		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InUser insert(InUser gpUser) throws Exception {

		entityManager.createNativeQuery(
			    "INSERT INTO InUser (username, password,startdate,newuser) VALUES (?, ?, ?, ?)")
			    //.setParameter(1, keyHolder.getKey().longValue())
			    .setParameter(1, gpUser.getUsername())
			    .setParameter(2, gpUser.getPassword())
			    .setParameter(3, new Date())
			    .setParameter(4, true)
			    .executeUpdate();

		return gpUser;

	}
}
