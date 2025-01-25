package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ColorService;
import kodlama.io.rentACar.business.requests.color.CreateColorRequest;
import kodlama.io.rentACar.business.requests.color.DeleteColorRequest;
import kodlama.io.rentACar.business.requests.color.UpdateColorRequest;
import kodlama.io.rentACar.business.responses.color.GetAllColorResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/colors")
@AllArgsConstructor
public class ColorController {
	private ColorService colorService;
	
	@GetMapping()
	List<GetAllColorResponse> listeleme()
	{
		return this.colorService.listeme();
	}

	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateColorRequest createColorRequest)
	{
		this.colorService.add(createColorRequest);
	}
	@PutMapping()
	public void update(@RequestBody UpdateColorRequest updateColorRequest)
	{
		this.colorService.update(updateColorRequest);
	}
	@DeleteMapping()
	public void delete(@RequestBody DeleteColorRequest deleteColorRequest)
	{
		this.colorService.delete(deleteColorRequest);
	}

	
}
