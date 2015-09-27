
package petclinic.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import petclinic.Petclinic4SpringbootApplication;

/**
 * <p> Integration test using the 'Spring Data' profile.
 * @see AbstractClinicServiceTests AbstractClinicServiceTests for more details. </p>
 * @author Michael Isvy
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Petclinic4SpringbootApplication.class)
@WebAppConfiguration
public class ClinicServiceSpringDataJpaTests extends AbstractClinicServiceTests {

}