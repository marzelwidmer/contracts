import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "Posts "
    request {
        method "GET"
        urlPath "/customers"
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body file("customers_response.json")
    }
}
