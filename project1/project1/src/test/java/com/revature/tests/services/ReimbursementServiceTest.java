package com.revature.tests.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.impl.ReimbursementServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ReimbursementServiceTest {
	@Mock
	private static ReimbursementDAO daoMock;
	@InjectMocks
	private static ReimbursementService rs = new ReimbursementServiceImpl(daoMock);

	@BeforeClass
	public static void setUpBeforeClass() { }
	
	// submit()
	@Test
	public void submitTest() {
		doNothing().when(daoMock).create(any(Reimbursement.class));
		rs.submit(new Reimbursement());
		verify(daoMock, times(1)).create(any(Reimbursement.class));
	}
	
	// getResolvedReimbursements()
	@Test
	public void getResolvedReimbursementsTest() {
		when(daoMock.getResolvedReimbursementsByAuthorId(any(Integer.class))).thenReturn(new ArrayList<Reimbursement>());
		assertNotNull(rs.getResolvedReimbursementsByAuthor(new User()));
	}
	
	// getResolvedReimbursements()
	@Test
	public void getPendingReimbursementsTest() {
		when(daoMock.getPendingReimbursementsByAuthorId(any(Integer.class))).thenReturn(new ArrayList<Reimbursement>());
		assertNotNull(rs.getPendingReimbursementsByAuthor(new User()));
	}
}