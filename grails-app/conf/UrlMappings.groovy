class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/api/users/"(controller: "api") {
            action = [POST:"register"]
        }

		"/"(view:"/user/create")
		"500"(view:'/error')
	}
}
