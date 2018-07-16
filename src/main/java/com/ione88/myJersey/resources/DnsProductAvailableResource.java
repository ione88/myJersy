
package com.ione88.myJersey.resources;

import com.google.inject.Inject;
import com.ione88.myJersey.models.DnsProductAvailable;
import com.ione88.myJersey.services.DnsProductAvailableService;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

// The Java class will be hosted at the URI path "/employee"
@Path("/available")
public class DnsProductAvailableResource {

    @Inject
    private DnsProductAvailableService dnsProductAvailableService;

    @PUT
    @Path("add")
    @Produces("application/json")
    @Consumes("application/json")
    public DnsProductAvailable createDnsProductAvailable(DnsProductAvailable dnsProductAvailable) {
        return dnsProductAvailableService.createDnsProductAvailable(dnsProductAvailable);
    }

}
