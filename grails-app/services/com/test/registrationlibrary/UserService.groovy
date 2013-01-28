package com.test.registrationlibrary

import org.springframework.beans.factory.InitializingBean
import com.test.registrationlibrary.domain.*

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

    def getValidEmailsGroupByUserDomain() {
        return mappingUserDomainAndValidEmails
    }


    def isValidDomain(domain) {
        return (mappingUserDomainAndValidEmails.get(domain) != null)
    }

    def isValidEmail(email, domain) {
        def validEmails = getValidEmails(domain)

        def isValid = false
        validEmails.each { validAddress ->
            if (email =~ ".*${validAddress}\$") {   //TODO Extract pattern to constant
                isValid = true;
            }
        }
        return isValid
    }

    def saveUser(userCommand) {
        log.debug " Saving user .."

        def user = new User(username: userCommand.username,email: userCommand.email,zipCode: userCommand.zipCode, registerDate: new Date())
        if (user.save(flush: true)) {
            log.info "user saved"
            return user.id
        }
        log.error "Error saving user"
        return null
    }

    private def getValidEmails(domain) {

        def validEmails = mappingUserDomainAndValidEmails.get(domain)
        if (!validEmails) {
            return []
        }
        return validEmails
    }
}
