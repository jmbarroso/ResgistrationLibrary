package com.test.registrationlibrary

import org.springframework.beans.factory.InitializingBean


class UserService implements InitializingBean {

    def grailsApplication

    Map<String, List<String>> mappingUserDomainAndValidEmails

    @Override
    void afterPropertiesSet() throws Exception {
        this.mappingUserDomainAndValidEmails = grailsApplication.config.userRegistration.validEmailsPerUserDomain

        if (mappingUserDomainAndValidEmails == null) {
            log.error "Configuration is required"
            throw new InstantiationException("userRegistration.validEmailsPerUserDomain in Config.groovy is requiered")
        }
    }

    def getValidsUserDomain() {
        return mappingUserDomainAndValidEmails.keySet()
    }


    def isValidDomain(domain) {
        return (mappingUserDomainAndValidEmails.get(domain) != null)
    }

    def isValidEmail(email, domain) {
        def validEmails = getValidEmails(domain)

        def isValid = false
        validEmails.each { validAddress ->
            if (email =~ ".*${validAddress}\$") {
                isValid = true;
            }
        }
        return isValid
    }

    private def getValidEmails(domain) {

        def validEmails = mappingUserDomainAndValidEmails.get(domain)
        if (!validEmails) {
            return []
        }
        return validEmails
    }
}
