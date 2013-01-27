package com.test.registrationlibrary

import com.test.registrationlibrary.validation.UserCommand


/* Controller to permits user registration from front-end application */
class UserController {

    public static final USER_VALIDATION_ERROR = "user.controller.error.validation"

    def index() {  return redirect(action:'create') }


    def create() {

        render(view: 'create')

    }

    def register(UserCommand userCommand) {

        if (userCommand.hasErrors()) {
            log.error "Errors Found validating user data ${userCommand.errors}"
            flash.error = USER_VALIDATION_ERROR
            render (view:'create', model:[userCommand:userCommand])
            return
        }

        render(view: 'show', model:[userCommand: userCommand])
    }


}
