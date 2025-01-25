package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.FuelService;
import kodlama.io.rentACar.business.requests.fuel.CreateFuelRequest;
import kodlama.io.rentACar.business.requests.fuel.DeleteFuelRequest;
import kodlama.io.rentACar.business.requests.fuel.UpdateFuelRequest;
import kodlama.io.rentACar.business.responses.fuel.GetAllFuelResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/fuels")
@AllArgsConstructor
public class FuelController {
	private FuelService fuelService;
	@GetMapping()
	List<GetAllFuelResponse> listeleme()
	{
		return fuelService.listeleme();
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateFuelRequest createFuelRequest)
	{
		this.fuelService.add(createFuelRequest);
	}
	@PutMapping
	public void update(@RequestBody UpdateFuelRequest updateFuelRequest)
	{
		this.fuelService.uptade(updateFuelRequest);
	}
	@DeleteMapping()
	public void delete(@RequestBody DeleteFuelRequest deleteFuelRequest)
	{
		this.fuelService.delete(deleteFuelRequest);
	}
}
