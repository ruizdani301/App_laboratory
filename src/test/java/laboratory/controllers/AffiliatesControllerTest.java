package laboratory.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import laboratory.entity.Affiliate;
import laboratory.service.AffiliatesService;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class AffiliatesControllerTest {

	@InjectMocks
	private AffiliatesController affiliateControler = new AffiliatesController();
	
	@Mock
	private AffiliatesService affiliateServiceMock;
	
	@Test
	void listall_ReturnStatus204_whenListReturnedIsEmpty() {
		when(affiliateServiceMock.getlist()).thenReturn(Collections.emptyList());
		var response = affiliateControler.affiliatesList();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	@Test
	void listall_ReturnStatus200_whenListReturnedIsEmpty() {
		var list = new ArrayList<Affiliate>();
		list.add(new Affiliate());
		when(affiliateServiceMock.getlist()).thenReturn(list);
		var response = affiliateControler.affiliatesList();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	void listbyid_Return404_whenNotFoundContent() {
		when(affiliateServiceMock.getbyid(anyLong())).thenReturn(null);
		var response = affiliateControler.objbyid(anyLong());
		Assertions.assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());
	}
	@Test
	void listbyid_Return200_whenFoundContent() {
		when(affiliateServiceMock.getbyid(anyLong())).thenReturn(new Affiliate());
		var response = affiliateControler.objbyid(anyLong());
		Assertions.assertEquals(HttpStatus.OK , response.getStatusCode());
	}
	
	@Test
	void listbyid_throwException_404_whenNotFoundContent() {
		doThrow(new RuntimeException()).when(affiliateServiceMock).getbyid(null);
		var response = affiliateControler.objbyid(anyLong());
		Assertions.assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());
	}
	
	@Test
	void postAffiliate_Return404_whenInsertionNotSuccessful() {
		when(affiliateServiceMock.post(new Affiliate())).thenReturn(null);
		var response = affiliateControler.postAffiliate(new Affiliate());
		Assertions.assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());
	}
	@Test
	void postAffiliate_Return200_whenInsertionSuccessful() {
		var affiliate = new Affiliate();
		when(affiliateServiceMock.post(affiliate)).thenReturn(affiliate);
		var response = affiliateControler.postAffiliate(affiliate);
		Assertions.assertEquals(HttpStatus.CREATED , response.getStatusCode());
	}
	
	@Test
	void putAffiliate_Return404_whenInsertionNotSuccessful() {
		var affiliate = new Affiliate();
		when(affiliateServiceMock.put(affiliate)).thenReturn(Optional.empty());
		var response = affiliateControler.putAffiliate(affiliate);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void putAffiliate_Return201_whenFoundContent() {
		var affiliate = new Affiliate();
		when(affiliateServiceMock.put(affiliate)).thenReturn(Optional.of(affiliate));
		var response = affiliateControler.putAffiliate(affiliate);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void deleteAffiliate_Return200_whenDeleteSuccessful() {
		doNothing().when(affiliateServiceMock).delete(anyLong());
		var response = affiliateControler.deleteAffiliate(anyLong());
		Assertions.assertEquals(HttpStatus.OK , response.getStatusCode());
	}
	
	@Test
	void deleteAffiliate_Return204_whenDeleteNotSuccessful() {
		doThrow(new RuntimeException()).when(affiliateServiceMock).delete(anyLong());
		var response = affiliateControler.deleteAffiliate(anyLong());
		Assertions.assertEquals(HttpStatus.NO_CONTENT , response.getStatusCode());
	}
}
