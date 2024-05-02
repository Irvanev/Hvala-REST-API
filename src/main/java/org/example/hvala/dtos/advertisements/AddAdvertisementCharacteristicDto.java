package org.example.hvala.dtos.advertisements;

import org.example.hvala.dtos.AddCharacteristicDto;

public class AddAdvertisementCharacteristicDto {
    AddCharacteristicDto addCharacteristicDto;
    AddAdvertisementDto addAdvertisementDto;

    public AddCharacteristicDto getAddCharacteristicDto() {
        return addCharacteristicDto;
    }

    public void setAddCharacteristicDto(AddCharacteristicDto addCharacteristicDto) {
        this.addCharacteristicDto = addCharacteristicDto;
    }

    public AddAdvertisementDto getAddAdvertisementDto() {
        return addAdvertisementDto;
    }

    public void setAddAdvertisementDto(AddAdvertisementDto addAdvertisementDto) {
        this.addAdvertisementDto = addAdvertisementDto;
    }
}
