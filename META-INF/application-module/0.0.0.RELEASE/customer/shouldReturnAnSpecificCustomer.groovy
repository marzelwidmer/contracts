org.springframework.cloud.contract.spec.Contract.make {
  request {
    method 'GET'
    urlPath $(server("/customers/1"), client(regex("/customers/[0-9a-zA-Z]+")))
  }
  response {
    status 200
    body '''{
            "id": 1, "name": "John"
        }'''
  }
}
