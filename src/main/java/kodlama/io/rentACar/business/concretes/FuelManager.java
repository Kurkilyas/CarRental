package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.FuelService;
import kodlama.io.rentACar.business.requests.fuel.CreateFuelRequest;
import kodlama.io.rentACar.business.requests.fuel.DeleteFuelRequest;
import kodlama.io.rentACar.business.requests.fuel.UpdateFuelRequest;
import kodlama.io.rentACar.business.responses.fuel.GetAllFuelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.FuelRepository;
import kodlama.io.rentACar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor

public class FuelManager implements FuelService {
	private FuelRepository fuelRepository;
	private ModelMapperService modelMapperService;
	
	
	
	@Override
	public List<GetAllFuelResponse> listeleme() {
		List<Fuel> fuels=this.fuelRepository.findAll();
		List<GetAllFuelResponse> fuelResponses=fuels.stream().map(fuel->this.modelMapperService.forResponse().map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
		return fuelResponses;
	}

	@Override
	public void add(CreateFuelRequest createFuelRequest) {
		Fuel fuel=this.modelMapperService.forRequest().map(createFuelRequest, Fuel.class);
		this.fuelRepository.save(fuel);
		
	}

	@Override
	public void delete(DeleteFuelRequest deleteFuelRequest) {
		this.fuelRepository.deleteById(deleteFuelRequest.getId());
		
	}

	@Override
	public void uptade(UpdateFuelRequest uptadeFuelRequest) {
		Fuel fuel=this.modelMapperService.forRequest().map(uptadeFuelRequest, Fuel.class);
		this.fuelRepository.save(fuel);
		
	}
	

}
