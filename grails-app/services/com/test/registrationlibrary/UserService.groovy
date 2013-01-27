package com.test.registrationlibrary


class UserService {


    def getValidsUserDomain() {
        if (!mappingUserDomainAndValidEmails) {
            mappingUserDomainAndValidEmails = grailsApplication.config.userRegistration.validEmailsPerUserDomain
        }
        return mappingUserDomainAndValidEmails.keySet()
    }


}
