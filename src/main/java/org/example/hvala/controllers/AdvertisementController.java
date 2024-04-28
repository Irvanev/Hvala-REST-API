package org.example.hvala.controllers;

import org.example.hvala.dtos.advertisements.AddAdvertisementDto;
import org.example.hvala.dtos.AddCharacteristicDto;
import org.example.hvala.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {
    private AdvertisementService advertisementService;

    @Autowired
    public void setAdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addAdvertisement(@RequestBody AddAdvertisementDto addAdvertisementDto, @RequestBody AddCharacteristicDto addCharacteristicDto) {
        advertisementService.addAdvertisement(addAdvertisementDto, addCharacteristicDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
