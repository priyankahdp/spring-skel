package com.cepheid.cloud.skel.controller;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cepheid.cloud.skel.exception.IncorrectStateException;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.service.ItemService;

import io.swagger.annotations.Api;

@Component
@Api()
@Path("/api/1.0/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	// Assign additional business layer

	// CURL GET http:/localhost:9443/app/api/1.0/items
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Collection<Item> getItems() {
		return itemService.findAll();
	}

	// CURL GET http:/localhost:9443/app/api/1.0/items/1
	@GET
	@Path("/{itemId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItemsById(@PathParam("itemId") Long itemId) {
		Item item = itemService.getItemsById(itemId);
		return item;
	}
	
	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Item> getItemsByName(@PathParam("name") String name) {
		return itemService.findByName(name);
	}
	
	@GET
	@Path("/state/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Item> getItemsByState(@PathParam("state") String state) {
		return itemService.findByState(state);
	}

	// CURL DELETE http:/localhost:9443/app/api/1.0/items/1
	@DELETE
	@Path("/{itemId}")
	public void deleteItem(@PathParam("itemId") Long itemId) {
		itemService.deleteById(itemId);
	}

	// CURL POST http:/localhost:9443/app/api/1.0/items
	@POST
	public Long saveItem(@RequestBody Item item) throws IncorrectStateException {
		itemService.saveOrUpdate(item);
		return item.getId();
	}

	// CURL PUT http:/localhost:9443/app/api/1.0/items
	@PUT
	public Long updateItem(@RequestBody Item item) throws IncorrectStateException {
		itemService.saveOrUpdate(item);
		return item.getId();
	}


}
