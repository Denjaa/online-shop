package com.shop.Shop;

import com.shop.Shop.service.MyUserDetailsService;
import com.shop.Shop.util.JwtUtil;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@AutoConfigureMockMvc
@SpringBootTest
class ShopApplicationTests<token> {

	@Autowired
	private MockMvc mockMvc;

	private String generated_tokenizer = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY0NzA0ODI5MCwiaWF0IjoxNjQ3MDEyMjkwfQ.0xgD4KKH0dKj8qDy01UotX_gBDXRoRJ37kMnhrR8oUY";

	@Test
	public void allCustomers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/allCustomers")
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getCustomer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/getById/1")
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void addOrUpdateCustomer() throws Exception {
		String customer = "{\"id\":3,\"name\":\"Tester\",\"surname\":\"Tester Surname\",\"address\":\"Testing Sample Address\",\"email\":\"test@test.com\",\"product_id\":100}";
		mockMvc.perform(MockMvcRequestBuilders.post("/customers/addOrUpdate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(customer)
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void deleteCustomer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/customers/delete/5")
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void allProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/products/allProducts")
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getProduct() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/products/getById/1")
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void addOrUpdateProduct() throws Exception {
		String customer = "{\"id\":3,\"name\":\"Tester\",\"brand\":\"Tester Surname\",\"availability\":\"Testing\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/products/addOrUpdate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(customer)
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void deleteProduct() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/products/delete/3")
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getCustomerValues() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customers/getById/1")
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();

		String stringResult = result.getResponse().getContentAsString();
		assertEquals("{\"id\":1,\"name\":\"Denis\",\"surname\":\"Morozov\",\"address\":\"Dunville Green, Navan\",\"email\":\"denis@student.ait.ie\",\"productId\":1,\"products\":{\"id\":1,\"name\":\"Magic House \",\"brand\":\"L.O.L\",\"availability\":\"yes\"}}", stringResult);
	}

	@Test
	public void addOrUpdateCustomerValues() throws Exception {
		String customer = "{\"id\":3,\"name\":\"Tester\",\"surname\":\"Tester Surname\",\"address\":\"Testing Sample Address\",\"email\":\"test@test.com\",\"productId\":0,\"products\":null}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/customers/addOrUpdate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(customer)
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();

		String stringResult = result.getResponse().getContentAsString();
		assertEquals("{\"id\":3,\"name\":\"Tester\",\"surname\":\"Tester Surname\",\"address\":\"Testing Sample Address\",\"email\":\"test@test.com\",\"productId\":0,\"products\":null}", stringResult);
	}

	@Test
	public void getProductsValues() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/getById/1")
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();

		String stringResult = result.getResponse().getContentAsString();
		assertEquals("{\"id\":1,\"name\":\"Magic House \",\"brand\":\"L.O.L\",\"availability\":\"yes\"}", stringResult);
	}

	@Test
	public void addOrUpdateProductValues() throws Exception {
		String customer = "{\"id\":3,\"name\":\"Tester\",\"brand\":\"Tester Surname\",\"availability\":\"Testing\"}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/addOrUpdate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(customer)
						.accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, generated_tokenizer))
				.andExpect(status().isOk())
				.andReturn();

		String stringResult = result.getResponse().getContentAsString();
		assertEquals("{\"id\":3,\"name\":\"Tester\",\"brand\":\"Tester Surname\",\"availability\":\"Testing\"}", stringResult);
	}





}
