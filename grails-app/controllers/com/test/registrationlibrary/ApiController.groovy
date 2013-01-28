package com.test.registrationlibrary

import grails.converters.JSON
import com.test.registrationlibrary.validation.UserCommand

/* controller to permits to others app user registration */
class ApiController {

    def userService

    static allowedMethods = [register: 'POST',getValidEmailsGroupedByUserDomain: 'GET']

    def register(UserCommand userCommand) {

        if (userCommand.hasErrors()) {
            response.status = 400
            def errors = []
            g.eachError(bean: userCommand) { error ->
                errors.add(["${error.field}": g.message(error: error)])
            }
            return render([errors: errors] as JSON)
        }

        def userId = userService.saveUser(userCommand)

        if (userId) {
            response.status = 200
            return render([id:userId] as JSON)
        } else {
            response.status = 500
            return render ([error: 'Internal error'] as JSON)
        }
    }

    def getValidEmailsGroupedByUserDomain() {

        def validEmailGroupedByDomain = userService.getValidEmailsGroupByUserDomain()

        response.status = 200
        return render (validEmailGroupedByDomain as JSON)
    }
}
