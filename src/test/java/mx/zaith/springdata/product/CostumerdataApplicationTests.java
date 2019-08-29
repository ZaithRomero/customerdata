package mx.zaith.springdata.product;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.zaith.springdata.product.entities.Customer;
import mx.zaith.springdata.product.repo.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CostumerdataApplicationTests {

	@Autowired
	private CustomerRepository repo;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void customerCreate()
	{
		Customer custom = new Customer();
		
		custom.setId(1);
		custom.setName("Zaith");
		custom.setEmail("zaith@sngular.com");
		
		assertEquals(1, custom.getId());
		assertEquals("Zaith", custom.getName());
		assertEquals("zaith@sngular.com", custom.getEmail());
		
		repo.save(custom);
	}

	@Test
	public void customerCreateBD()
	{
		Customer custom = new Customer(1,"Zaith","zaith@sngular.com");
		
		System.out.println("Starting save customer constructor with parameters \n");
		
		System.out.println(">>>Customer: " + custom);		
		
		custom.setId(1);
		custom.setName("fernando");
		custom.setEmail("fernando@sngular.com");
		repo.save(custom);
	}
	
	@Test
	public void customerRead()
	{
		Customer exist = repo.findById(1).get();

		if(exist != null)
		{
			assertEquals("fernando", exist.getName());
			assertEquals("fernando@sngular.com", exist.getEmail());		
		}
	}
}
