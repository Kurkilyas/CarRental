package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.StatusService;
import kodlama.io.rentACar.business.requests.status.CreateStatusRequest;
import kodlama.io.rentACar.business.requests.status.DeleteStatusRequest;
import kodlama.io.rentACar.business.requests.status.UpdateStatusRequest;
import kodlama.io.rentACar.business.responses.status.GetAllStatusResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.StatusRepository;
import kodlama.io.rentACar.entities.concretes.Status;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class StatusManager implements StatusService {
	private StatusRepository statusRepository;
	private ModelMapperService modelMapperService;
	@Override
	public List<GetAllStatusResponse> listeleme() {
		List<Status> statuses=this.statusRepository.findAll();
		List<GetAllStatusResponse> statusResponses=statuses.stream().map(status->this.modelMapperService.forResponse().
				map(status, GetAllStatusResponse.class)).collect(Collectors.toList());
		return statusResponses;
	}
	@Override
	public void add(CreateStatusRequest createStatusRequest) {
		Status status=this.modelMapperService.forRequest().map(createStatusRequest, Status.class);
		this.statusRepository.save(status);
		
	}
	@Override
	public void update(UpdateStatusRequest updateStatusRequest) {
		Status status=this.modelMapperService.forRequest().map(updateStatusRequest, Status.class);
		this.statusRepository.save(status);
		
	}
	@Override
	public void delete(DeleteStatusRequest deleteStatusRequest) {
		this.statusRepository.deleteById(deleteStatusRequest.getId());
		
	}
	

}
