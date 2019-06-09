package com.vinspier.rabbitmq;

import com.vinspier.rabbitmq.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RabbitmqApplication.class)
public class RabbitmqApplicationTests {

	@Autowired
	private Sender sender;

	@Test
	public void hello() throws Exception{
		sender.send();
	}

	@Test
	public void contextLoads() {
	}


}
