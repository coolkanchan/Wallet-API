package com.ewallet.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ewallet.api.entity.TransactionType;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class WalletControllerIntegrationTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void testCreate() throws Exception {
		mockMvc.perform(post("/api/wallet/create")
				.queryParam("currency", "USDOLLAR_$")
				.queryParam("id", "1")
				.queryParam("name", "kanchan")
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());


	}
	
	@Test
	public void testGetWallet() throws Exception {
		mockMvc.perform(get("/api/wallet/1")
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

	} 
	
	@Test
	public void testWalletList() throws Exception {
		mockMvc.perform(get("/api/wallet/list")
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

	} 
	
	@Test
	public void testUpdateCreditBalance() throws Exception {
		mockMvc.perform(put("/api/wallet/update/1001")
				.queryParam("amount", "300")
				.queryParam("type", "CREDIT")		
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

	}
	
	@Test
	public void testUpdateDebitBalance() throws Exception {
		mockMvc.perform(put("/api/wallet/update/1001")
				.queryParam("amount", "100")
				.queryParam("type", "DEBIT")		
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

	}




}
