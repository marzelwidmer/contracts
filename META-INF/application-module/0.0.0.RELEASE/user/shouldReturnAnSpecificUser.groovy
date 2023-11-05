import org.springframework.cloud.contract.spec.Contract

Contract.make {
	name 'should return a specific user'
	request {
		method 'GET'
		url '/users/1'
	}
	response {
		status 200
		body '''{
            "id": 1, "name": "John"
        }'''
	}
}
