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
}
