package com.test.registrationlibrary.validation

import com.test.registrationlibrary.domain.*

/* User command is used to validate data that should not be in domain object
 * This class is a representation of domain object User
 *
 * */
@grails.validation.Validateable
class UserCommand {

    def userService

    String username
    String email
    Integer zipCode
    String userDomain

    //TODO create custom messages to custom validator
    static constraints = {
        importFrom User
        userDomain(validator: { userDomain, obj ->
            return obj.userService.isValidDomain(userDomain)
        })
        email(nullable: false,blank: false, email: true, validator: { email, obj ->
            def isValid = obj.userService.isValidEmail(email,obj.userDomain)
            return isValid
        })
    }
}
