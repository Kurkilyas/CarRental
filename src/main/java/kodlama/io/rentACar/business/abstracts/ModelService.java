package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.requests.model.DeleteModelRequest;
import kodlama.io.rentACar.business.requests.model.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;

public interface ModelService {

	List<GetAllModelResponse> getAll();
	void add(CreateModelRequest createModelRequest);
	void update(UpdateModelRequest uptadeModelRequest);
	void delete(DeleteModelRequest deleteModelRequest);
	GetAllModelResponse getById(int id);
	
}
