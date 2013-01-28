package com.test.registrationlibrary.domain

class User {

    String username
    String email
    Integer zipCode
    Date registerDate

    static constraints = {
        username(nullable: false,blank: false)
        email(nullable: false,blank: false, email: true)
        zipCode(nullable: false,blank: false)
        registerDate(nullable: true)
    }

}
