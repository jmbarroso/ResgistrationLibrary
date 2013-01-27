package com.test.registrationlibrary


class UserService {

    def grailsApplication

    Map<String, List<String>> mappingUserDomainAndValidEmails

    def getValidsUserDomain() {
        if (!mappingUserDomainAndValidEmails) {
            mappingUserDomainAndValidEmails = grailsApplication.config.userRegistration.validEmailsPerUserDomain
        }
        return mappingUserDomainAndValidEmails.keySet()
    }



}
