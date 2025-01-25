package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ColorService;
import kodlama.io.rentACar.business.requests.color.CreateColorRequest;
import kodlama.io.rentACar.business.requests.color.DeleteColorRequest;
import kodlama.io.rentACar.business.requests.color.UpdateColorRequest;
import kodlama.io.rentACar.business.responses.color.GetAllColorResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ColorRepository;
import kodlama.io.rentACar.entities.concretes.Color;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService{
	ColorRepository colorRepository;
	ModelMapperService modelMapperService;
	@Override
	public List<GetAllColorResponse> listeme() {
		List<Color> colors=colorRepository.findAll();
		List<GetAllColorResponse> newColors=colors.stream().map(color->this.modelMapperService.forResponse().map(color,GetAllColorResponse.class))
				.collect(Collectors.toList());

		return newColors;
	}

	@Override
	public void add(CreateColorRequest createColorRequest) {
		Color color=this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		this.colorRepository.save(color);
	}

	@Override
	public void update(UpdateColorRequest updateColorRequest) {
		Color color=this.modelMapperService.forRequest().map(updateColorRequest, Color.class);
		this.colorRepository.save(color);
		
	}

	@Override
	public void delete(DeleteColorRequest deleteColorRequest) {
		this.colorRepository.deleteById(deleteColorRequest.getId());
		
	}

}
