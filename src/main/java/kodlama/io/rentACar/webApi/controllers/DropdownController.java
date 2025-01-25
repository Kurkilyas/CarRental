package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.DropdownService;
import kodlama.io.rentACar.business.responses.color.GetAllColorResponse;
import kodlama.io.rentACar.business.responses.fuel.GetAllFuelResponse;
import kodlama.io.rentACar.business.responses.gear.GetAllGearResponse;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.state.GetAllStateResponse;
import kodlama.io.rentACar.business.responses.status.GetAllStatusResponse;
import kodlama.io.rentACar.dataAccess.abstracts.*;
import kodlama.io.rentACar.entities.concretes.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DropdownController {
    private DropdownService dropdownService;

    @GetMapping("/models")
    public List<GetAllModelResponse> getAllModels() {
        return dropdownService.getAllModels();
    }

    @GetMapping("/colors")
    public List<GetAllColorResponse> getAllColors() {
        return dropdownService.getAllColors();
    }

    @GetMapping("/states")
    public List<GetAllStateResponse> getAllStates() {
        return dropdownService.getAllStates();
    }

    @GetMapping("/gears")
    public List<GetAllGearResponse> getAllGears() {
        return dropdownService.getAllGears();
    }

    @GetMapping("/fuels")
    public List<GetAllFuelResponse> getAllFuels() {
        return dropdownService.getAllFuels();
    }

    @GetMapping("/statuses")
    public List<GetAllStatusResponse> getAllStatuses() {
        return dropdownService.getAllStatuses();
    }

    // Diğer dropdown listeleri için benzer servis ve controller metodlarını ekleyin
}