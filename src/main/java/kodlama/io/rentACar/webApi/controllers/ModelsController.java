package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.requests.model.DeleteModelRequest;
import kodlama.io.rentACar.business.requests.model.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import lombok.AllArgsConstructor;

@RestController //annotation:bilgilendirme ifadesi
@RequestMapping("/models")
@AllArgsConstructor
public class ModelsController {
	
	private ModelService modelService;
	
	@GetMapping
	public List<GetAllModelResponse> getAll(){
			
		return modelService.getAll();
} 
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateModelRequest modelRequest)
	{
		modelService.add(modelRequest);
	}
	@PutMapping
	public void Uptade(@RequestBody UpdateModelRequest uptademodel)
	{
		modelService.update(uptademodel);
	}
	@DeleteMapping()
	public void delete(@RequestBody DeleteModelRequest deleteModelRequest)
	{
		modelService.delete(deleteModelRequest);
	}
	@GetMapping("/{id}")
	public void getByID(@PathVariable int id)
	{
		modelService.getById(id);
	}
	
	
	

}
