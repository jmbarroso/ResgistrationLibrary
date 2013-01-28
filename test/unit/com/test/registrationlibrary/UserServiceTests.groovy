package com.test.registrationlibrary



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
class UserServiceTests {

    def validDomainsConfigured = ['English':['org.uk', 'co.uk', '.biz']]

    @Before
    void setUp() {
       grailsApplication.config.userRegistration.validEmailsPerUserDomain = validDomainsConfigured
       service.afterPropertiesSet()
    }

    @Test
    void "Valid user domains configured in Config should be returned by service"() {

        def validDomains = service.getValidsUserDomain()

        assert validDomainsConfigured.keySet().contains('English')

    }

    @Test
    void "an email is valid if exists for a specific valid domain"() {

        def validDomain = 'English'

        assert service.isValidEmail("email@provider.org.uk",validDomain)
        assert service.isValidEmail("email@provider.co.uk",validDomain)
        assert service.isValidEmail("email@provider.biz",validDomain)

        assertFalse(service.isValidEmail("email@org.uk.other",validDomain))

    }

    @Test
    void "An invalid domain trying to validate email should be false"() {

        def validDomain = 'English'

        assert service.isValidEmail("email@provider.org.uk",validDomain)
        assert service.isValidEmail("email@provider.co.uk",validDomain)
        assert service.isValidEmail("email@provider.biz",validDomain)

        def invalidDomain = 'InexistentDomain'
        assertFalse(service.isValidEmail("email@org.uk.other",invalidDomain))
    }
}
