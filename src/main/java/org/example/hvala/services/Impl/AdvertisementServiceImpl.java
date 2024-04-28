package org.example.hvala.services.Impl;

import org.example.hvala.dtos.advertisements.AddAdvertisementDto;
import org.example.hvala.dtos.AddCharacteristicDto;
import org.example.hvala.models.entities.Advertisement;
import org.example.hvala.models.entities.Characteristic;
import org.example.hvala.repositories.AdvertisementRepository;
import org.example.hvala.repositories.CharacteristicRepository;
import org.example.hvala.repositories.SubCategoryRepository;
import org.example.hvala.services.AdvertisementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementRepository advertisementRepository;
    private CharacteristicRepository characteristicRepository;
    private SubCategoryRepository subCategoryRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setAdvertisementServiceImpl(AdvertisementRepository advertisementRepository, ModelMapper modelMapper,
                                            CharacteristicRepository characteristicRepository,
                                            SubCategoryRepository subCategoryRepository) {
        this.advertisementRepository = advertisementRepository;
        this.characteristicRepository = characteristicRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addAdvertisement(AddAdvertisementDto addAdvertisementDto, AddCharacteristicDto addCharacteristicDto) {
        addAdvertisementDto.setCreated(LocalDateTime.now());
        addAdvertisementDto.setModified(LocalDateTime.now());

        Advertisement advertisement = modelMapper.map(addAdvertisementDto, Advertisement.class);
        advertisement.setSubCategory(subCategoryRepository.findByName(addAdvertisementDto.getSubCategory()).orElse(null));
        advertisementRepository.saveAndFlush(advertisement);

        Characteristic characteristic = modelMapper.map(addCharacteristicDto, Characteristic.class);
        characteristic.setAdvertisement(advertisement);
        characteristicRepository.saveAndFlush(characteristic);
    }
}
