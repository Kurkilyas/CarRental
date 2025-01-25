package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.status.CreateStatusRequest;
import kodlama.io.rentACar.business.requests.status.DeleteStatusRequest;
import kodlama.io.rentACar.business.requests.status.UpdateStatusRequest;
import kodlama.io.rentACar.business.responses.status.GetAllStatusResponse;

public interface StatusService {
	List<GetAllStatusResponse> listeleme();
	public void add(CreateStatusRequest createStatusRequest);
	public void update(UpdateStatusRequest updateStatusRequest);
	public void delete(DeleteStatusRequest deleteStatusRequest);

}
