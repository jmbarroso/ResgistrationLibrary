package com.test.registrationlibrary



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
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
}
