import org.springframework.cloud.contract.spec.Contract

Contract.make {
	name 'should return all users'
	request {
		method 'GET'
		url '/users'
	}
	response {
		status 200
		body '''[
            {"id": 1, "name": "John"},
            {"id": 2, "name": "Jane"}
        ]'''
	}
}
