package com.subhas.jobportal.contact.service;

import com.subhas.jobportal.contact.dto.ContactRequestDto;
import com.subhas.jobportal.contact.entity.Contact;

public interface ContactService {
    boolean saveContact(ContactRequestDto contactRequestDto);
}
