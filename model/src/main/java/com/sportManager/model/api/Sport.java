package com.sportManager.model.api;

import com.sportManager.infrastructure.model.Entity;

public interface Sport extends Entity {
	String getName();
	void setName(String name);
}
