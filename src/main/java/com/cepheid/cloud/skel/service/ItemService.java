package com.cepheid.cloud.skel.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.cepheid.cloud.skel.exception.IncorrectStateException;
import com.cepheid.cloud.skel.model.Item;

public interface ItemService {
	public Item getItemsById(Long id);

	public Collection<Item> findAll();

	public void deleteById(Long itemId);

	public void saveOrUpdate(Item item) throws IncorrectStateException;

	public Optional<Item> findItemById(Long itemId)throws IncorrectStateException;
	
	public List<Item> findByName(String name);
	
	public List<Item> findByState(String state);
}