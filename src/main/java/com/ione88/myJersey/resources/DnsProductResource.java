
package com.ione88.myJersey.resources;

import com.google.inject.Inject;
import com.ione88.myJersey.model.DnsProduct;
import com.ione88.myJersey.service.DnsProductService;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

// The Java class will be hosted at the URI path "/employee"
@Path("/product")
public class DnsProductResource {

    @Inject
    private DnsProductService dnsProductService;

    @PUT
    @Path("add")
    @Produces("application/json")
    @Consumes("application/json")
    public DnsProduct createDnsProduct(DnsProduct dnsProduct) {
        return dnsProductService.createDnsProduct(dnsProduct);
    }

}
