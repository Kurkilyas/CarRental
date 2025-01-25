package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.requests.model.DeleteModelRequest;
import kodlama.io.rentACar.business.requests.model.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{

	
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelResponse> getAll() {
		
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelResponse> modelsResponse = models.stream()
				.map(model->this.modelMapperService.forResponse()
				.map(model,GetAllModelResponse.class)).collect(Collectors.toList());
		
		return modelsResponse;
		
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model=this.modelMapperService.forRequest().map(createModelRequest,Model.class);
		this.modelRepository.save(model);	
		
	}

	@Override
	public void update(UpdateModelRequest uptadeModelRequest) {
		Model model=this.modelMapperService.forRequest().map(uptadeModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

	@Override
	public void delete(DeleteModelRequest deleteModelRequest) {
		this.modelRepository.deleteById(deleteModelRequest.getId());
		
	}

	@Override
	public GetAllModelResponse getById(int id) {
		Model model=this.modelRepository.findById(id).orElseThrow();
		GetAllModelResponse getAllModelResponse=this.modelMapperService.forResponse().map(model, GetAllModelResponse.class);
		return getAllModelResponse;
	}
	

	
	
}
