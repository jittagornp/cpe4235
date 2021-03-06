
import com.blogspot.na5cent.resourcelocal.model.Location;
import com.blogspot.na5cent.resourcelocal.repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author anonymous
 */
@ContextConfiguration(locations = {
    "/spring/applicationContext.xml",
    "/spring/applicationContext-eclipseLink.xml"
})
public class LocationT extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private LocationRepo repo;
    
    @Test
    public void findById(){
        Location location = repo.findOne(1000);
        Assert.assertEquals(location.getPostalCode(), "00989");
    }
}
