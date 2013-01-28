package com.test.registrationlibrary

import com.test.registrationlibrary.validation.UserCommand
import com.test.registrationlibrary.domain.*


/* Controller to permits user registration from front-end application */
class UserController {

    public static final USER_VALIDATION_ERROR = "user.controller.error.validation"
    public static final USER_CREATION_ERROR = "user.controller.error.creation"

    def userService


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

        def userSavedId = userService.saveUser(userCommand)
        log.info "User registrer with id ${userSavedId}"

        if (userSavedId) {
            render(view: 'show', model:[user: User.get(userSavedId)])
            return
        } else {
            flash.error = USER_CREATION_ERROR
            render (view:'create', model:[userCommand:userCommand])
            return
        }
    }


}
