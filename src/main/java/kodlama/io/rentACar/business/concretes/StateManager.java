package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.StateService;
import kodlama.io.rentACar.business.requests.State.CreateStateRequest;
import kodlama.io.rentACar.business.requests.State.DeleteStateRequest;
import kodlama.io.rentACar.business.requests.State.UpdateStateRequest;
import kodlama.io.rentACar.business.responses.state.GetAllStateResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.StateRepository;
import kodlama.io.rentACar.entities.concretes.State;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor

public class StateManager implements StateService {
	private StateRepository stateRepository;
	private ModelMapperService modelMapperService;
	@Override
	public List<GetAllStateResponse> listeleme() {
		List<State> states=this.stateRepository.findAll();
		List<GetAllStateResponse> stateResponses=states.stream().map(state->this.modelMapperService.forResponse().map(state, GetAllStateResponse.class)).collect(Collectors.toList());
		
		return stateResponses;
	}
	@Override
	public void add(CreateStateRequest createStateRequest) {
		State state=this.modelMapperService.forRequest().map(createStateRequest,State.class);
		this.stateRepository.save(state);
		
	}
	@Override
	public void update(UpdateStateRequest updateStateRequest) {
		State state=this.modelMapperService.forRequest().map(updateStateRequest,State.class);
		this.stateRepository.save(state);
		
	}
	@Override
	public void delete(DeleteStateRequest deleteStateRequest) {
		this.stateRepository.deleteById(deleteStateRequest.getId());
		
	}
	
	
}
