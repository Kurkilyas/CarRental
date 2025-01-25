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
import kodlama.io.rentACar.business.abstracts.StateService;
import kodlama.io.rentACar.business.requests.State.CreateStateRequest;
import kodlama.io.rentACar.business.requests.State.DeleteStateRequest;
import kodlama.io.rentACar.business.requests.State.UpdateStateRequest;
import kodlama.io.rentACar.business.responses.state.GetAllStateResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/states")
@AllArgsConstructor
public class StateController {
	private StateService stateService;
	@GetMapping
	List<GetAllStateResponse> listeleme()
	{
		return this.stateService.listeleme();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateStateRequest createStateRequest)
	{
		this.stateService.add(createStateRequest);
	}
	@PutMapping
	public void update(@RequestBody UpdateStateRequest updateStateRequest)
	{
		this.stateService.update(updateStateRequest);
	}
	@DeleteMapping()
	public void delete(@RequestBody DeleteStateRequest deleteStateRequest)
	{
		this.stateService.delete(deleteStateRequest);
	}
	
	
}
