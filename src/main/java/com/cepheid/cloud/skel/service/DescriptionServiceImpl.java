package com.cepheid.cloud.skel.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.repository.DescriptionRepository;

@Service
public class DescriptionServiceImpl implements DescriptionService {

	@Autowired
	DescriptionRepository descriptionRepository;

	public Collection<Description> findAll() {
		return descriptionRepository.findAll();
	}

	public void saveOrUpdate(Description description) {
		descriptionRepository.save(description);
	}
}