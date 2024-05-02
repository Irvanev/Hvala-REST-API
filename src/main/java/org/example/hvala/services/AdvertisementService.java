package org.example.hvala.services;

import org.example.hvala.dtos.advertisements.AddAdvertisementCharacteristicDto;
import org.example.hvala.dtos.advertisements.AddAdvertisementDto;
import org.example.hvala.dtos.AddCharacteristicDto;

public interface AdvertisementService {
    void addAdvertisement(AddAdvertisementDto addAdvertisementDto, AddCharacteristicDto addCharacteristicDto);
}
