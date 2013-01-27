package com.test.registrationlibrary



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
class UserServiceTests {

    @Test
    void "Valid user domains configured in Config should be returned by service"() {

        def validDomainsConfigured = ['English':['org.uk', 'co.uk', '.biz']]
        grailsApplication.config.userRegistration.validEmailsPerUserDomain = validDomainsConfigured

        def validDomains = service.getValidsUserDomain()

        assert validDomains == validDomainsConfigured.keySet()

    }

    @Test
    void "an email is valid if exists for a specific valid domain"() {

        def validDomainsConfigured = ['English':['org.uk', 'co.uk', '.biz']]
        grailsApplication.config.userRegistration.validEmailsPerUserDomain = validDomainsConfigured

        def validDomain = 'English'

        assert service.isValidEmail("email@provider.org.uk",validDomain)
        assert service.isValidEmail("email@provider.co.uk",validDomain)
        assert service.isValidEmail("email@provider.biz",validDomain)

        assertFalse(service.isValidEmail("email@org.uk.other",validDomain))

    }

    @Test
    void "An invalid domain trying to validate email should be false"() {

        def validDomainsConfigured = ['English':['org.uk', 'co.uk', '.biz']]
        grailsApplication.config.userRegistration.validEmailsPerUserDomain = validDomainsConfigured

        def validDomain = 'InexistentDomain'

        assert service.isValidEmail("email@provider.org.uk",validDomain)
        assert service.isValidEmail("email@provider.co.uk",validDomain)
        assert service.isValidEmail("email@provider.biz",validDomain)

        assertFalse(service.isValidEmail("email@org.uk.other",validDomain))

    }
}
