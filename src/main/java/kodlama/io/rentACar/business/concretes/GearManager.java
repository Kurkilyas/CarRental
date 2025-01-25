package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.GearService;
import kodlama.io.rentACar.business.requests.gear.CreateGearRequest;
import kodlama.io.rentACar.business.requests.gear.DeleteGearRequest;
import kodlama.io.rentACar.business.requests.gear.UpdateGearRequest;
import kodlama.io.rentACar.business.responses.gear.GetAllGearResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.GearRepository;
import kodlama.io.rentACar.entities.concretes.Gear;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class GearManager implements GearService {
	private GearRepository gearRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllGearResponse> listeleme() {
		List<Gear> gears=this.gearRepository.findAll();
		List<GetAllGearResponse> gearsResponses=gears.stream().map(gear->this.modelMapperService.forResponse().map(gear, GetAllGearResponse.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return gearsResponses;
	}

	@Override
	public void add(CreateGearRequest createGearRequest) {
		Gear gear=this.modelMapperService.forRequest().map(createGearRequest, Gear.class);
		this.gearRepository.save(gear);
	}

	@Override
	public void update(UpdateGearRequest updateGearRequest) {
		Gear gear=this.modelMapperService.forRequest().map(updateGearRequest, Gear.class);
		this.gearRepository.save(gear);
		
	}

	@Override
	public void delete(DeleteGearRequest deleteGearRequest) {
		this.gearRepository.deleteById(deleteGearRequest.getId());
		
	}
	
	

}
