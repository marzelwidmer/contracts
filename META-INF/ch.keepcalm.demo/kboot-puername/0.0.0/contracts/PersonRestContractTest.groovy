import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/api/persons'
        headers {
            header(accept(), $(consumer(regex("application/(hal\\+)?json")), producer("application/hal+json")))
        }
    }
    response {
        status OK()
        body '''\
		[
          {
            "firstName": "John"
          }
        ]
	    '''
    }
}
