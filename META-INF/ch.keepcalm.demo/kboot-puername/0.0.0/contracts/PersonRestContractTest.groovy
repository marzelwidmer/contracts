import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/api/persons'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        headers{
            contentType(applicationJson())
        }
        body '''\
		[
          {
            "firstName": "John"
          }
        ]
	    '''
    }
}
