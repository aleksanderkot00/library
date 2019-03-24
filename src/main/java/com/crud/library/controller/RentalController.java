package com.crud.library.controller;

import com.crud.library.domain.Dto.RentalDto;
import com.crud.library.mapper.RentalMapper;
import com.crud.library.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping(value = "returnBook/{rentalId}")
    public RentalDto returnBook(@PathVariable("rentalId") long rentalId) {
        return rentalMapper.mapToRentalDto(rentalService.returnBook(rentalId));
    }
}
