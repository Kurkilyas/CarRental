package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.State.CreateStateRequest;
import kodlama.io.rentACar.business.requests.State.DeleteStateRequest;
import kodlama.io.rentACar.business.requests.State.UpdateStateRequest;
import kodlama.io.rentACar.business.responses.state.GetAllStateResponse;

public interface StateService {
	List<GetAllStateResponse> listeleme();
	public void add(CreateStateRequest createStateRequest);
	public void update(UpdateStateRequest updateStateRequest );
	public void delete(DeleteStateRequest deleteStateRequest);

}
