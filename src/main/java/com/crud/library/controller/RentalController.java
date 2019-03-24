package com.crud.library.controller;

import com.crud.library.domain.Dto.RentalDto;
import com.crud.library.mapper.RentalMapper;
import com.crud.library.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private RentalMapper rentalMapper;

    @PostMapping(value = "rentBook")
    public RentalDto addBook(@RequestBody RentalDto rentalDto) {
        return rentalMapper.mapToRentalDto(rentalService.addRental(rentalMapper.mapToRental(rentalDto)));
    }
}
