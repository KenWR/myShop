package com.green.nowon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.nowon.domain.entity.MemberEntityRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyUserDetailsService implements UserDetailsService{

	//DB의 테이블에서 인증처리하기 위한 메소드
	@Autowired
	private MemberEntityRepository meRe;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//log.info(">>>>>>>> login page : email -> username : " + username);
		//meRe.findById(null);
		//Optional<MemberEntity> mEntity=meRe.findByEmailAndSocialAndDeleted(username, false, false);
		//MemberEntity mEntity=meRe.findByEmailAndSocialAndDeleted(username, false, false)
				//.orElseThrow(()->new UsernameNotFoundException("존재하지 않는 이메일"));//NoSuchElementException
		
		//email, pass, roles(Collection<? extends GrantedAuthority> authorities)
		//enum -> SimpleGrantedAuthority
		//Set<SimpleGrantedAuthority> authorities = mEntity.getRoles() //Set<MyRole> --> Set<GrantedAuthority>
				//.stream() //Stream<MyRole>
				//.map(myRole->new SimpleGrantedAuthority(myRole.getRole())) //Stream<GrantedAuthority>
				//.collect(Collectors.toSet());
		
		//return new MyUserDetails(username, mEntity.getPass(), authorities);
		return new MyUserDetails(meRe.findByEmailAndSocialAndDeleted(username, false, false)
				.orElseThrow(()->new UsernameNotFoundException("존재하지 않는 이메일") ));
		}

}
