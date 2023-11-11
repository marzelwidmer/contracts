import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "Posts "
    request {
        method "GET"
        urlPath "/posts"
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body file("posts_response.json")
    }
}
