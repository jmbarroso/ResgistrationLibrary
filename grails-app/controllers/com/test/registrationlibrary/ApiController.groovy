package com.test.registrationlibrary

import grails.converters.JSON
import com.test.registrationlibrary.validation.UserCommand

/* controller to permits to others app user registration */
class ApiController {

    static allowedMethods = [register: 'POST']

    def register(UserCommand userCommand) {

        if (userCommand.hasErrors()) {
            response.status = 400
            def errors = []
            g.eachError(bean: userCommand) { error ->
                errors.add(["${error.field}": g.message(error: error)])
            }
            return render([errors: errors] as JSON)
        }

        response.status = 200
    }
}
