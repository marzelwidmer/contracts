import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/getPartnerOeZuteilung'
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
        <getPartnerOeZuteilungResponse>
            <partnerGbereichListOeZuteilung>
                <partnerId>M1001</partnerId>
                <partnerGbereichOeZuteilung>
                    <oeZuteilung>
                        <organisationseinheitArt>admin</organisationseinheitArt>
                        <organisationseinheitId>9999</organisationseinheitId>
                    </oeZuteilung>
                    <oeZuteilung>
                        <organisationseinheitArt>leistung</organisationseinheitArt>
                        <organisationseinheitId>9999</organisationseinheitId>
                    </oeZuteilung>
                </partnerGbereichOeZuteilung>
            </partnerGbereichListOeZuteilung>
        </getPartnerOeZuteilungResponse>
	    '''
    }
}
