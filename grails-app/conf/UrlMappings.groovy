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

        "/api/domains/emails"(controller: "api") {
            action = [GET:"getValidEmailsGroupedByUserDomain"]
        }

		"/"(view:"/user/create")
		"500"(view:'/error')
	}
}
