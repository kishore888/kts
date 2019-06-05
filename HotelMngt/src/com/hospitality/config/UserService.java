package com.hospitality.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospitality.core.Role;
import com.hospitality.core.UserRole;
import com.hospitality.core.Users;

@Service("UserService")
public class UserService implements UserDetailsService{

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	 public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
		 UserDetails userDetails = null;
		 try {
			 System.out.println("userName = "+userName);
			 
			 Users user = null;
			 String queryString = "select u from Users u where u.userName =:userName";
//			 Query query = entityManager.createQuery(queryString);
//			 query.setParameter("userName", userName);
//			 if(query.getResultList().size()>0) {
//				 System.out.println("query.getResultList().size() = "+query.getResultList().size());
//				 user = (Users) query.getResultList().get(0);
//			 }
			 
			 user = (Users) entityManager.createQuery(queryString).setParameter("userName", userName).getSingleResult();
			
			 if(user!=null) {
				 System.out.println("user "+user.getUserName());
				 
				 List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
				 @SuppressWarnings("unchecked")
//				List<String> privilegeCodeList = entityManager.createQuery("select p.privilegeCode from Privilege p join fetch p.rolePrivileges rp join fetch rp.role r join fetch r.userRoles ur join fetch ur.user u where u.userName =:userName")
//						 					.setParameter("userName", userName).getResultList();
				 
//				 UserRole userRole = (UserRole) entityManager.createQuery("select ur from UserRole ur join fetch ur.role r join fetch r.rolePrivileges rp join fetch ur.user u where u.userName =:userName")
//		 					.setParameter("userName", userName).setMaxResults(1).getResultList();
//						 
//				 List<String> privilegeCodeList = userRole.getRole().getRolePrivileges().stream().map(rolePrivilege->rolePrivilege.getPrivilege().getPrivilegeCode()).collect(Collectors.toList());
				 
				
				 List<String> privilegeCodeList =  entityManager.createNativeQuery("select p.privilege_code from privilege p, role_privilege rp, role r, user_role ur, users u where p.privilege_id=rp.privilege_id and rp.role_id=r.role_id and r.role_id=ur.role_id and ur.user_id=u.user_id and u.user_name=:userName")
		 					.setParameter("userName", userName).getResultList();
				 
				 for (String privilegeCode : privilegeCodeList) {
				    grantedAuthorities.add(new SimpleGrantedAuthority(privilegeCode));
				  }
				 userDetails = new User(user.getUserName(), user.getPassword(), grantedAuthorities);
			 }else {
				 System.out.println("user not found");
			 }
		 }catch(UsernameNotFoundException nfe) {
			 nfe.printStackTrace();
		 }
		 return userDetails;
	 }
}
