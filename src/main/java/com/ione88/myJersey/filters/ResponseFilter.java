package com.ione88.myJersey.filters;

import com.google.inject.Inject;
import com.ione88.myJersey.services.FilterService;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

import javax.ws.rs.ext.Provider;

@Provider
public class ResponseFilter implements ContainerResponseFilter {
    @Inject
    private FilterService filterService;

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {

        filterService.modifyRequest(request);
        return filterService.modifyResponse(response);
    }
}