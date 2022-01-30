package com.shop.Shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
@AutoConfigureMockMvc
class ShopApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void allCustomers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/allCustomers")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getCustomer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/getById/1")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void addOrUpdateCustomer() throws Exception {
		String customer = "{\"customer_id\":4,\"name\":\"Tester\",\"address\":\"Testing Sample Address\",\"email\":\"test@test.com\",\"age\":102}";
		mockMvc.perform(MockMvcRequestBuilders.post("/customers/addOrUpdate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(customer)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void deleteCustomer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/customers/delete/5")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}




}
