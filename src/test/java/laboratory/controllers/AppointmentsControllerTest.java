package laboratory.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;

import laboratory.entity.Affiliate;
import laboratory.entity.Appointment;
import laboratory.service.imple.AppointmentsServiceImpl;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class AppointmentsControllerTest {

	
		@InjectMocks
		private AppointmentsController appoController = new AppointmentsController();
		
		@Mock
		private AppointmentsServiceImpl appoServiceMock;
		
		@Test
		void listall_ReturnStatus204_whenListReturnedIsEmpty() {
			when(appoServiceMock.getlist()).thenReturn(Collections.emptyList());
			var response = appoController.appointmentsList();
			Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		}
		@Test
		void listall_ReturnStatus200_whenListReturnedIsEmpty() {
			var list = new ArrayList<Appointment>();
			list.add(new Appointment());
			when(appoServiceMock.getlist()).thenReturn(list);
			var response = appoController.appointmentsList();
			Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		}
		@Test
		void listbyid_Return404_whenNotFoundContent() {
			when(appoServiceMock.getbyid(anyLong())).thenReturn(null);
			var response = appoController.objbyid(anyLong());
			Assertions.assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());
		}
		@Test
		void listbyid_Return200_whenFoundContent() {
			when(appoServiceMock.getbyid(anyLong())).thenReturn(new Appointment());
			var response = appoController.objbyid(anyLong());
			Assertions.assertEquals(HttpStatus.OK , response.getStatusCode());
		}
		
		@Test
		void listbyid_throwException_404_whenNotFoundContent() {
			doThrow(new RuntimeException()).when(appoServiceMock).getbyid(null);
			var response = appoController.objbyid(anyLong());
			Assertions.assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());
		}
		
		@Test
		void postAppo_Return404_whenInsertionNotSuccessful() {
			when(appoServiceMock.post(new Appointment())).thenReturn(null);
			var response = appoController.postAppo(new Appointment());
			Assertions.assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());
		}
		@Test
		void postAppo_Return200_whenInsertionSuccessful() {
			var appointment = new Appointment();
			when(appoServiceMock.post(appointment)).thenReturn(appointment);
			var response = appoController.postAppo(appointment);
			Assertions.assertEquals(HttpStatus.CREATED , response.getStatusCode());
		}
		@Test
		void putAppo_Return404_whenInsertionNotSuccessful() {
			var appointment = new Appointment();
			when(appoServiceMock.put(appointment)).thenReturn(Optional.empty());
			var response = appoController.putAppo(appointment);
			Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		}
		
		@Test
		void putAffiliate_Return201_whenFoundContent() {
			var appointment = new Appointment();
			when(appoServiceMock.put(appointment)).thenReturn(Optional.of(appointment));
			var response = appoController.putAppo(appointment);
			Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		}
		
		@Test 
		void getbyAffiliate_ReturnStatus200_whenReturnAppointmentLIst() {
			List<Appointment> sample = new ArrayList<Appointment>();
			sample.add(new Appointment());
			var affiliate = new Affiliate();
			when(appoServiceMock.getbyaffiliate(affiliate)).thenReturn(sample);
			var response =  appoController.listAffiliates(affiliate);
			Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		}
		
		@Test 
		void getbyAffiliate_ReturnStatus204_whenReturnAppointmentLIst() {
			var affiliate = new Affiliate();
			when(appoServiceMock.getbyaffiliate(affiliate)).thenReturn(Collections.emptyList());
			var response =  appoController.listAffiliates(affiliate);
			Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		}
		
		@Test 
		void getbyDate_ReturnStatus200_whenReturnAppointmentLIst() {
			var valu = new String();
			List<Appointment> listAppo = new ArrayList<Appointment>();
			listAppo.add(new Appointment());
			when(appoServiceMock.getbyDate(valu)).thenReturn(listAppo);
			var response =  appoController.listGroup(valu);
			Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		}
		
		@Test 
		void getbyDate_ReturnStatus204_whenNotReturnAppointmentLIst() {
			var valu = new String();
			when(appoServiceMock.getbyDate(valu)).thenReturn(Collections.emptyList());
			var response =  appoController.listGroup(valu);
			Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		}
		
		@Test
		void deleteAffiliate_Return200_whenDeleteSuccessful() {
			doNothing().when(appoServiceMock).delete(anyLong());
			var response = appoController.deleteAppo(anyLong());
			Assertions.assertEquals(HttpStatus.OK , response.getStatusCode());
		}
		
		@Test
		void deleteAffiliate_Return204_whenDeleteNotSuccessful() {
			doThrow(new RuntimeException()).when(appoServiceMock).delete(anyLong());
			var response = appoController.deleteAppo(anyLong());
			Assertions.assertEquals(HttpStatus.NO_CONTENT , response.getStatusCode());
		}
}

