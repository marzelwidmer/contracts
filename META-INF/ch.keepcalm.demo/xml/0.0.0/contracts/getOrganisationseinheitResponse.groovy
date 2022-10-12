import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/getOrganisationseinheit'
//        headers {
//            contentType(applicationXml())
//        }
    }
    response {
        status OK()
        headers{
            contentType(applicationXml())
        }
        body '''\
		<?xml version="1.0" encoding="UTF-8"?>
        <getOrganisationseinheitResponse>
            <organisationseinheit>
                <kurzBezeichnung>IFB</kurzBezeichnung>
                <zusatz>Team BB2</zusatz>
            </organisationseinheit>
        </getOrganisationseinheitResponse>
	    '''
    }
}
