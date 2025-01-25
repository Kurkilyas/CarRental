package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.fuel.CreateFuelRequest;
import kodlama.io.rentACar.business.requests.fuel.DeleteFuelRequest;
import kodlama.io.rentACar.business.requests.fuel.UpdateFuelRequest;
import kodlama.io.rentACar.business.responses.fuel.GetAllFuelResponse;

public interface FuelService {
	List<GetAllFuelResponse> listeleme();
	public void add(CreateFuelRequest createFuelRequest);
	public void delete(DeleteFuelRequest deleteFuelRequest);
	public void uptade(UpdateFuelRequest uptadeFuelRequest);
	

}
