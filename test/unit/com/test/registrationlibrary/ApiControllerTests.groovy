package com.test.registrationlibrary

import com.test.registrationlibrary.UserController
import com.test.registrationlibrary.UserService
import com.test.registrationlibrary.validation.UserCommand
import com.test.registrationlibrary.domain.*
import grails.test.mixin.*
import org.junit.*
import groovy.json.JsonOutput

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ApiController)
@Mock([UserService,User])
class ApiControllerTests {

    @Test
    void "Register user successfully should return http status 200"() {

        def username = 'login'
        def email = 'email@email.co.uk'
        def zipCode = 38888

        def userCommand = mockCommandObject(UserCommand)
        userCommand.username = username
        userCommand.email = email
        userCommand.zipCode = zipCode
        userCommand.userDomain = 'English'
        userCommand.validate()

        request.method = "PUT"
        controller.register(userCommand)

        assert 200 == response.status
        assert response.json.id != null
    }


    @Test
    void "Try to register a using with error should return a 400 error and a arror list"() {

        params."username" = null
        params."email" = null
        params."zipCode" = null

        controller.register()

        assert 400 == response.status
        assert response.json.errors.username != null
        assert response.json.errors.email != null
        assert response.json.errors.zipCode != null
    }

    @Test
    void "A list of valid emails  by domian configured could be consulting by api consumers"() {

        request.method = "GET"
        controller.getValidEmailsGroupedByUserDomain()


        println JsonOutput.prettyPrint(response.text)

        assert 200 == response.status
        assert response.json != null

    }

}
