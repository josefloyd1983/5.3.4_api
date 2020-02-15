/**
 * 
 */
package cl.liberty.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.model.Flow;
import cl.liberty.services.FlowService;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class FlowServiceTest {

	@Autowired
	FlowService flowService;

	@Test
	public void getFlowTest() {
		List<Flow> flows = flowService.getFlows();
		assertNotNull("Flujo es null", flows);
	}

}
