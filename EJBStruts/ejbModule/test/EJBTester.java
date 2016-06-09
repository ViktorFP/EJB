package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.powermock.api.mockito.PowerMockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import by.epamlab.Utilites;
import by.epamlab.ejbs.ReservationCompSvBean;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utilites.class)
public class EJBTester {
	@Test
	public void test_calling_getRoot_static_method() throws Exception {
		mockStatic(Utilites.class);
		when(Utilites.getRoot(null)).thenReturn(null);
		ReservationCompSvBean reservationCompSvBean = spy(new ReservationCompSvBean());
		reservationCompSvBean.getReservationComponents("", null);
		verifyStatic();
		Utilites.getRoot(null);
	}
}
