package com.zycus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.dto.AuditLog;
import com.zycus.services.LogService;

@RestController
public class AuditController {

	@Autowired
	LogService service;

	@JmsListener(destination = "Audit Logging")
	public void updateLog(@RequestBody AuditLog log) {

		try {
			service.update(log);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
