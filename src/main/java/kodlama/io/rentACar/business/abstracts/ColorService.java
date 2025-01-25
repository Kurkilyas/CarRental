package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.color.CreateColorRequest;
import kodlama.io.rentACar.business.requests.color.DeleteColorRequest;
import kodlama.io.rentACar.business.requests.color.UpdateColorRequest;
import kodlama.io.rentACar.business.responses.color.GetAllColorResponse;

public interface ColorService {
	List<GetAllColorResponse> listeme();
	void add(CreateColorRequest createColorRequest);
	void update(UpdateColorRequest updateColorRequest);
	void delete(DeleteColorRequest deleteColorRequest);

}
