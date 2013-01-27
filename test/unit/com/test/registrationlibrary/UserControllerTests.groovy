package com.test.registrationlibrary



import grails.test.mixin.*
import org.junit.*
import com.test.registrationlibrary.validation.UserCommand

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock(UserService)
class UserControllerTests {

    @Test
    void "Default action should be create new user"() {

        controller.index()

        assert response.redirectedUrl == '/user/create'
    }

    @Test
    void "Create action should render create user view"() {

        controller.create()

        assert view == '/user/create'
    }

    @Test
    void "Register user successfully should redirect to show view with user registration details"() {

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

        model.userCommand != null
        model.userCommand.username == username
        model.userCommand.email == email
        model.userCommand.zipCode == zipCode

        assert view == '/user/show'
    }

    @Test
    void "All Fields are mandatory when an user is registered, null fields should return an error"() {

        params."input.username" = null
        params."input.email" = null
        params."input.zipCode" = null

        controller.register()

        assert view == '/user/create'
        assert flash.error == UserController.USER_VALIDATION_ERROR

        assert model.userCommand != null
        assert model.userCommand.hasErrors() != null
    }

}
