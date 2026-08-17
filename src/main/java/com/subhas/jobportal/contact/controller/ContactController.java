package com.subhas.jobportal.contact.controller;

import com.subhas.jobportal.contact.dto.ContactRequestDto;
import com.subhas.jobportal.contact.service.ContactService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMessage(@RequestBody @Valid ContactRequestDto contactRequestDto) {
        boolean isSaved = contactService.saveContact(contactRequestDto);
        if(isSaved) {
            return new ResponseEntity<>("Contact saved successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Contact could not be saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(version = "1.0")
    public ResponseEntity<String> fetchOpenContacts(@RequestParam
                                                        @Validated @NotBlank(message = "status can not be blank")
                                                        @Size(min = 5, message = "status should be minimum of 5 character") String status){
        return ResponseEntity.ok("This are the contacts with the given status: "+status);
    }
}
