package com.ione88.myJersey.services;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;

public interface FilterService {
    ContainerRequest modifyRequest(ContainerRequest clientRequest);
    ContainerResponse modifyResponse(ContainerResponse clientResponse);
}
