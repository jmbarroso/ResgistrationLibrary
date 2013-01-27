package com.test.registrationlibrary


class UserController {

    def index() {  return redirect(action:'create') }


    def create() {

        render(view: 'create')

    }



}
