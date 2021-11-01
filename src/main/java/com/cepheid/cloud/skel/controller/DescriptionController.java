package com.cepheid.cloud.skel.controller;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.service.DescriptionService;

import io.swagger.annotations.Api;

@Component
@Api()
@Path("/api/1.0/descriptions")
public class DescriptionController {

	@Autowired
	private DescriptionService descriptionService;

	// CURL GET http:/localhost:9443/app/api/1.0/descriptions
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Collection<Description> getDescriptions() {
		return descriptionService.findAll();
	}
}
