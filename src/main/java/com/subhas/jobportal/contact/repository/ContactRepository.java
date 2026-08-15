package com.subhas.jobportal.contact.repository;

import com.subhas.jobportal.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}