package com.IPLFantasy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.IPLFantasy.dao.BidderDao;
import com.IPLFantasy.entities.Bidder;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BidderDaoTest {
	@Autowired
	private BidderDao dao;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		Bidder bidder= new Bidder();
		bidder.setUserName("Anu");
		bidder.setPassword("anu@167");
		bidder.setName("Anu Kumari");
		bidder.setEmail("k.anu@gmail.com");
		bidder.setPhoneNo("9876543210");
		
		Bidder savedBidder=dao.save(bidder);
		
		Bidder existBidder=	entityManager.find(Bidder.class, savedBidder.getBidderId());
		assertThat(existBidder.getEmail()).isEqualTo(bidder.getEmail());
	}
	
	
}
