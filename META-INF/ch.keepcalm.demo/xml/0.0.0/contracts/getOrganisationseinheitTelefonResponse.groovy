import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/getOrganisationseinheitTelefon'
//        headers {
//            contentType(applicationXml())
//        }
    }
    response {
        status OK()
        headers{
            contentType(applicationXml())
            header 'Cache-Control' : 'no-cache,no-store'
        }
        body '''<?xml version="1.0" encoding="UTF-8"?>
        <getOrganisationseinheitTelefonResponse>
            <organisationseinheitTelefon>
                <telefon>
                    <telefonDefId>
                        <id>-9</id>
                    </telefonDefId>
                    <telefonNummer>+41 58 340 00 00</telefonNummer>
                </telefon>
                <telefon>
                    <telefonDefId>
                        <id>-55</id>
                    </telefonDefId>
                    <telefonNummer>+41 58 340 00 55</telefonNummer>
                </telefon>
            </organisationseinheitTelefon>
        </getOrganisationseinheitTelefonResponse>
	    '''
    }
}
