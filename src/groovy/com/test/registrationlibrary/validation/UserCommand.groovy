package com.test.registrationlibrary.validation

@grails.validation.Validateable
class UserCommand {

    def userService

    String username
    String email
    Integer zipCode
    String userDomain

    //TODO create custom messages to custom validator
    static constraints = {
        userDomain(validator: { userDomain, obj ->
            return obj.userService.isValidDomain(userDomain)
        })
        username(nullable: false,blank: false)
        email(nullable: false,blank: false, email: true, validator: { email, obj ->
            def isValid = obj.userService.isValidEmail(email,obj.userDomain)
            return isValid
        })
        zipCode(nullable: false,blank: false)
    }
}
