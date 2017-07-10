package com.hrapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hrapp.domain.core.InUser;
import com.hrapp.domain.core.UserStatus;



@Repository
public interface UserRepository extends JpaRepository<InUser, String> {


	@Modifying
	@Transactional
	public int deleteById(Long id);

	public InUser findById(Long id);

	@Modifying
	@Transactional
	@Query("Update InUser s SET s.status=:status WHERE s.id=:id")
	public int userActivate(@Param("id") Long id, @Param("status") UserStatus status);

	@Query("Select s from  InUser s WHERE s.username=:username AND s.password=:password")
	public InUser doLogin(@Param("username") String username, @Param("password") String password);

	@Query("Select s from  InUser s WHERE s.password=:password")
	public InUser findByPassword(@Param("password") String password);

	@Modifying
	@Transactional
	@Query("Update InUser s SET s.password=:password WHERE s.id=:id AND s.password=:oldpassword")
	public int resetPassword(@Param("oldpassword") String oldpassword, @Param("password") String password, @Param("id") Long id);

	@Query("Select s from  InUser s WHERE s.username=:username")
	public InUser findByUsername(@Param("username") String username);

	@Query("Select s from  InUser s WHERE s.username=:username ")
	public InUser findByUsername_security(@Param("username") String username);

	@Query("Select s from  InUser s WHERE s.id=:id")
	public InUser findResume(@Param("id") Long id);
	

}
