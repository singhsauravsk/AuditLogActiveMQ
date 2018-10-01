package com.zycus.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.dto.AuditLog;
import com.zycus.entity.AuditLogEntity;
import com.zycus.repository.LogRepository;

@Service
@Transactional
public class AuditLogService implements LogService {

	@Autowired
	LogRepository logRepository;
	
	public boolean update(AuditLog logDetails) {
		
		try {
			AuditLogEntity logEntity = new AuditLogEntity();
			
			logEntity.setAccount(logDetails.getAccount());
			logEntity.setDate(logDetails.getDate());
			logEntity.setMessage(logDetails.getMessage());
			logEntity.setUser(logDetails.getUser());
			logEntity.setId(System.currentTimeMillis() % 1000000l);
			logRepository.save(logEntity);
			
			return true;
		} catch(Exception e) {
			return false;
		} 
	}
}
