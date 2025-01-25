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
import kodlama.io.rentACar.business.abstracts.StatusService;
import kodlama.io.rentACar.business.requests.status.CreateStatusRequest;
import kodlama.io.rentACar.business.requests.status.DeleteStatusRequest;
import kodlama.io.rentACar.business.requests.status.UpdateStatusRequest;
import kodlama.io.rentACar.business.responses.status.GetAllStatusResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/status")
@AllArgsConstructor
public class StatusController {
	private StatusService statusService;
	@GetMapping()
	List<GetAllStatusResponse> listeleme()
	{
		return statusService.listeleme();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateStatusRequest createStatusRequest)
	{
		this.statusService.add(createStatusRequest);
	}
	@PutMapping
	
	public void update(@RequestBody UpdateStatusRequest updateStatusRequest)
	{
		this.statusService.update(updateStatusRequest);
	}
	@DeleteMapping()
	public void delete(@RequestBody DeleteStatusRequest deleteStatusRequest)
	{
		this.statusService.delete(deleteStatusRequest);
	}
}
