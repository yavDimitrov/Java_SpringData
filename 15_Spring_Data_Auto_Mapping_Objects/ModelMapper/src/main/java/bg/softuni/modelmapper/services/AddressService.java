package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.dtos.CreateAddressDTO;

public interface AddressService {
    Address create(CreateAddressDTO data);
}
