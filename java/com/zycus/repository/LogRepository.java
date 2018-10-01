package com.zycus.repository;

import org.springframework.data.repository.CrudRepository;

import com.zycus.entity.AuditLogEntity;

public interface LogRepository extends CrudRepository <AuditLogEntity, Long> {
	
}
