package com.mustaf.printingonmaps.controller;

import com.mustaf.printingonmaps.dto.AddressDTO;
import com.mustaf.printingonmaps.entity.Address;
import com.mustaf.printingonmaps.entity.PrintProject;
import com.mustaf.printingonmaps.repository.AddressRepository;
import com.mustaf.printingonmaps.repository.PrintProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrintProjectController {

    PrintProjectRepository printProjectRepository;
    AddressRepository addressRepository;

    public PrintProjectController(PrintProjectRepository printProjectRepository,
                                  AddressRepository addressRepository) {
        this.printProjectRepository = printProjectRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/print-projects/{id}")
    public PrintProject one(@PathVariable String id) {
        return printProjectRepository.findById(id).orElse(null);
    }

    @GetMapping("/print-projects")
    public List<PrintProject> all() {
        System.out.println("requesting data...:");
        return printProjectRepository.findAll();
    }

    @GetMapping("/addresses")
    public List<Address> allAddresses() {
        var addresses = addressRepository.findAll();
        System.out.println("returning addresses...");
        addresses.forEach(address -> System.out.println(address.getAddress()));

        return addresses;
    }

    @PostMapping("/location-data")
    public void createAddress(@RequestBody AddressDTO addressDTO) {
        System.out.println("new address received...");
        System.out.println(addressDTO);
        Address address = new Address();
        address.setAddress(addressDTO.getAddress());
        addressRepository.save(address);
    }
}