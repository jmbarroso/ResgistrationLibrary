import com.test.registrationlibrary.ApiController
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.junit.Test


@TestFor(UrlMappings)
@Mock(ApiController)
class UrlMappingsTests {


    @Test
    void "Verifying URL to register users"()  {

        request.method = 'POST'
        assertForwardUrlMapping("/api/users", controller:'api', action: 'register')
    }

    @Test
    void "Consult valid email per user domain"()  {

        request.method = 'GET'
        assertForwardUrlMapping("/api/domains/emails", controller:'api', action: 'getValidEmailsGroupedByUserDomain')
    }



}
