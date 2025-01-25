package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.DropdownService;

import kodlama.io.rentACar.business.responses.color.GetAllColorResponse;
import kodlama.io.rentACar.business.responses.fuel.GetAllFuelResponse;
import kodlama.io.rentACar.business.responses.gear.GetAllGearResponse;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.state.GetAllStateResponse;
import kodlama.io.rentACar.business.responses.status.GetAllStatusResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperManager;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.*;
import kodlama.io.rentACar.entities.concretes.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DropdownManager implements DropdownService {
    private ModelRepository modelRepository;
    private ColorRepository colorRepository;

    private FuelRepository fuelRepository;
    private GearRepository gearRepository;

    private StatusRepository statusRepository;
    private StateRepository stateRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllModelResponse> getAllModels() {
        List<Model> models = modelRepository.findAll();

        List<kodlama.io.rentACar.business.responses.model.GetAllModelResponse> modelsResponse = models.stream()
                .map(model->this.modelMapperService.forResponse()
                        .map(model, kodlama.io.rentACar.business.responses.model.GetAllModelResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public List<GetAllColorResponse> getAllColors() {
        List<Color> colors=colorRepository.findAll();
        List<GetAllColorResponse> newColors=colors.stream().map(color->this.modelMapperService.forResponse().map(color,GetAllColorResponse.class))
                .collect(Collectors.toList());
        return newColors;
    }

    @Override
    public List<GetAllStateResponse> getAllStates() {
        List<State> states=this.stateRepository.findAll();
        List<GetAllStateResponse> stateResponses=states.stream().map(state->this.modelMapperService.forResponse().map(state, GetAllStateResponse.class)).collect(Collectors.toList());

        return stateResponses;
    }

    @Override
    public List<GetAllFuelResponse> getAllFuels() {
        List<Fuel> fuels=this.fuelRepository.findAll();
        List<GetAllFuelResponse> fuelResponses=fuels.stream().map(fuel->this.modelMapperService.forResponse().map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
        return fuelResponses;
    }

    @Override
    public List<GetAllStatusResponse> getAllStatuses() {
        List<Status> statuses=this.statusRepository.findAll();
        List<GetAllStatusResponse> statusResponses=statuses.stream().map(status->this.modelMapperService.forResponse().
                map(status, GetAllStatusResponse.class)).collect(Collectors.toList());
        return statusResponses;
    }

    @Override
    public List<GetAllGearResponse> getAllGears() {
        List<Gear> gears=this.gearRepository.findAll();
        List<GetAllGearResponse> gearsResponses=gears.stream().map(gear->this.modelMapperService.forResponse().map(gear, GetAllGearResponse.class)).collect(Collectors.toList());
        // TODO Auto-generated method stub
        return gearsResponses;
    }
}
