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
import kodlama.io.rentACar.business.abstracts.GearService;
import kodlama.io.rentACar.business.requests.gear.CreateGearRequest;
import kodlama.io.rentACar.business.requests.gear.DeleteGearRequest;
import kodlama.io.rentACar.business.requests.gear.UpdateGearRequest;
import kodlama.io.rentACar.business.responses.gear.GetAllGearResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/gears")
@AllArgsConstructor
public class GearController {
	private GearService gearService;
	@GetMapping()
	List<GetAllGearResponse> listeleme()
	{
		return this.gearService.listeleme();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateGearRequest createGearRequest)
	{
		this.gearService.add(createGearRequest);
	}
	@PutMapping
	public void update(@RequestBody UpdateGearRequest updateGearRequest)
	{
		this.gearService.update(updateGearRequest);
	}
	@DeleteMapping()
	public void delete(@RequestBody DeleteGearRequest deleteGearRequest)
	{
		this.gearService.delete(deleteGearRequest);;
	}
}
