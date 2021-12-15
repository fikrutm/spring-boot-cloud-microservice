package com.demo.user.srevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.user.entity.User;
import com.demo.user.reposisory.UserRepository;
import com.demo.user.response.Account;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

//    public ResponseTemplate getUserWithDepartment(Long userId) {
//        log.info("Inside getUserWithDepartment of UserService");
//        ResponseTemplate vo = new ResponseTemplate();
//        User user = userRepository.findByUserId(userId);
//
//        Account department =
//                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
//                        ,Account.class);
//
//        vo.setUser(user);
//        vo.setDepartment(department);
//
//        return  vo;
//    }

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public List<Account> getAccounts(Integer userId) {

		return restTemplate.getForObject("http://ACCOUNT-SERVICE/accounts/accounts/user/" + userId, List.class);

	}

}
