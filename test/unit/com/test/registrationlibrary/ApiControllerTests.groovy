package com.test.registrationlibrary

import com.test.registrationlibrary.UserController
import com.test.registrationlibrary.UserService
import com.test.registrationlibrary.validation.UserCommand
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ApiController)
@Mock(UserService)
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

        controller.register(userCommand)

        assert 200 == response.status
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

}
