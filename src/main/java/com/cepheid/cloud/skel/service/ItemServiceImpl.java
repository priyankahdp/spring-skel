package com.cepheid.cloud.skel.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cepheid.cloud.skel.exception.IncorrectStateException;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	public Item getItemsById(Long itemId) {
		return itemRepository.findById(itemId).get();
	}

	public Collection<Item> findAll() {
		return itemRepository.findAll();
	}

	public void deleteById(Long itemId) {
		itemRepository.deleteById(itemId);
	}

	public void saveOrUpdate(Item item) throws IncorrectStateException {
		if(item.getState().equals("undefined")||item.getState().equals("valid")||item.getState().equals("invalid")) {
			itemRepository.save(item);
		}else {
			throw new IncorrectStateException("Invalid State Type");
		}
	}

	@Override
	public Optional<Item> findItemById(Long itemId){
		return itemRepository.findById(itemId);
	}

	public List<Item> findByName(String name) {
		return itemRepository.findByName(name);
	}

	public List<Item> findByState(String state) {
		return itemRepository.findByState(state);
	}
}