package laboratory.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import laboratory.entity.TestLab;
import laboratory.service.imple.TestsServiceImple;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class TestsControllerTest {
	
	@InjectMocks
	private TestsController testControler;
	
	@Mock
	private TestsServiceImple testServiceMock;
		
		
	@Test
	void listall_ReturnStatus204_whenListReturnedIsEmpty() {
		when(testServiceMock.getList()).thenReturn(Collections.emptyList());
		var response = testControler.testList();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	@Test
	void listall_ReturnStatus200_whenListReturnedIsEmpty() {
		var list = new ArrayList<TestLab>();
		list.add(new TestLab());
		when(testServiceMock.getList()).thenReturn(list);
		var response = testControler.testList();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	void listbyid_Return404_whenNotFoundContent() {
		when(testServiceMock.getById(anyLong())).thenReturn(null);
		var response =testControler.objbyid(anyLong());
		Assertions.assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());
	}
	@Test
	void listbyid_Return200_whenFoundContent() {
		when(testServiceMock.getById(anyLong())).thenReturn(new TestLab());
		var response = testControler.objbyid(anyLong());
		Assertions.assertEquals(HttpStatus.OK , response.getStatusCode());
	}
	
	@Test
	void listbyid_Return_404_whenNotFoundContent() {
		doThrow(new RuntimeException()).when(testServiceMock).getById(null);
		var response =testControler.objbyid(anyLong());
		Assertions.assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());
	}
	
	@Test
	void postTest_Return404_whenInsertionNotSuccessful() {
		when(testServiceMock.post(new TestLab())).thenReturn(null);
		var response =  testControler.postTest(new TestLab());
		Assertions.assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());
	}
	@Test
	void postAffiliate_Return200_whenInsertionSuccessful() {
		var testLab = new TestLab();
		when(testServiceMock.post(testLab)).thenReturn(testLab);
		var response = testControler.postTest(testLab);
		Assertions.assertEquals(HttpStatus.CREATED , response.getStatusCode());
	}
	
	@Test
	void putTest_Return404_whenInsertionNotSuccessful() {
		var testLab = new TestLab();
		when(testServiceMock.put(testLab)).thenReturn(Optional.empty());
		var response = testControler.putTest(testLab);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void putTest_Return201_whenFoundContent() {
		var testLab = new TestLab();
		when(testServiceMock.put(testLab)).thenReturn(Optional.of(testLab));
		var response = testControler.putTest(testLab);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void deleteTest_Return200_whenDeleteSuccessful() {
		doNothing().when(testServiceMock).delete(anyLong());
		var response = testControler.deleteTest(anyLong());
		Assertions.assertEquals(HttpStatus.OK , response.getStatusCode());
	}
	
	@Test
	void deleteTest_Return204_whenDeleteNotSuccessful() {
		doThrow(new RuntimeException()).when(testServiceMock).delete(anyLong());
		var response =testControler.deleteTest(anyLong());
		Assertions.assertEquals(HttpStatus.NO_CONTENT , response.getStatusCode());
	}

}
