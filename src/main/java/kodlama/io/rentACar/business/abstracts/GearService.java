package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.gear.CreateGearRequest;
import kodlama.io.rentACar.business.requests.gear.DeleteGearRequest;
import kodlama.io.rentACar.business.requests.gear.UpdateGearRequest;
import kodlama.io.rentACar.business.responses.gear.GetAllGearResponse;

public interface GearService {
		List<GetAllGearResponse> listeleme();
		public void add(CreateGearRequest createGearRequest);
		public void update(UpdateGearRequest updateGearRequest);
		public void delete(DeleteGearRequest deleteGearRequest);

}
