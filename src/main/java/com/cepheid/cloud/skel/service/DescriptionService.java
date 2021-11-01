package com.cepheid.cloud.skel.service;

import java.util.Collection;

import com.cepheid.cloud.skel.model.Description;

public interface DescriptionService {
	public Collection<Description> findAll();

	public void saveOrUpdate(Description description);
}