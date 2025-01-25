package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.color.GetAllColorResponse;
import kodlama.io.rentACar.business.responses.fuel.GetAllFuelResponse;
import kodlama.io.rentACar.business.responses.gear.GetAllGearResponse;
import kodlama.io.rentACar.business.responses.state.GetAllStateResponse;
import kodlama.io.rentACar.business.responses.status.GetAllStatusResponse;
import kodlama.io.rentACar.entities.concretes.*;

import java.util.List;

public interface DropdownService {
    public List<GetAllModelResponse> getAllModels();
    public List<GetAllColorResponse> getAllColors();
    public List<GetAllStateResponse> getAllStates();
    public List<GetAllFuelResponse> getAllFuels();
    public List<GetAllStatusResponse> getAllStatuses();

    public List<GetAllGearResponse> getAllGears();
}
