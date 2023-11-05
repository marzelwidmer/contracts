package contracts

import org.springframework.cloud.contract.spec.Contract

val contracts = Contract.make {
    description = "Should return info about other endpoints to query"
    request {
        method = Contract.HttpMethods.HttpMethod.GET
        urlPath = value("/partners/{id}")
        urlParameters {
            parameter("id", "1")
        }
    }
    response {
        status = 200
        headers {
            header("Content-Type", "application/json")
        }
        body("""
            {
                "name" : "John"
            }
        """)
        matchers {
            header("Content-Type", "application/json.*")
        }
    }
}
