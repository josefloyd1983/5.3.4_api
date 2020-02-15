/**
 * 
 */
package cl.liberty.test.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.dao.LogDao;
import cl.liberty.request.LogRequest;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class LogDaoTest {

	@Autowired
	LogDao logDao;

	@Test
	public void addBrokerTest() {
		LogRequest logRequest = new LogRequest();
		logRequest.setWalletId(-1);
		logRequest.setEventId(11);
		logRequest.setUserId(1);
		logRequest.setPolicyNumber(1);
		logRequest.setValueNew("111");
		logRequest.setValueOld("11");
		try {
			logDao.addLog(logRequest);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail("Error -> " + e.getMessage());
		}
	}

}
