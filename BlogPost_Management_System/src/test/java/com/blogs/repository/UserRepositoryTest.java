package com.blogs.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blogs.entities.User;

@DataJpaTest //Annotation to tell Spring boot test framework to enable 
//Data JPA layer (i.e service | controller |
//modelmapper ..beans will not be activated)
@AutoConfigureTestDatabase(replace = Replace.NONE)
//Tells Spring boot test frameWork -not to replace original data source(i.e 
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test //JUnit annotation to indicate a test method 
	void testFindByEmailAndPassword() {
		Optional<User> optional=userRepository.findByEmailAndPassword("a2@gmail.com", "2234");
	    //assert method args-expected,actual
		//test case passes when expected matches the actual
		//otherwise fails
		assertEquals(2l, optional.get().getId());
	}

}
