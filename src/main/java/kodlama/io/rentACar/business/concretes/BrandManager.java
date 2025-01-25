package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.DeleteBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
@Service //bellekte "ıoc" denen bir yapı sayesinde gider bellekte onu newler ve onu çağırmak isteyen herkese onun referansını verir.
	//bu sayede bellek tasarrufu sağlanmış olur.

@AllArgsConstructor
public class BrandManager implements BrandService{
	
	private BrandRepository brandrepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands=brandrepository.findAll();
		/*List<GetAllBrandsResponse> brandsResponses=new ArrayList<GetAllBrandsResponse>();
		
		for(Brand brand:brands)
		{
			GetAllBrandsResponse brandResponse=new GetAllBrandsResponse();
			brandResponse.setId(brand.getId());
			brandResponse.setName(brand.getName());
			brandsResponses.add(brandResponse);
		}
		*/
		List<GetAllBrandsResponse> brandsResponseMap=brands.stream()
		.map(brand->this.modelMapperService.forResponse()
				.map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return brandsResponseMap;
	}

	@Override
	public void add(CreateBrandRequest brandRequest) {
		
		this.brandBusinessRules.chechIfBrandNameExists(brandRequest.getName());
		
		Brand brand=this.modelMapperService.forRequest().map(brandRequest,Brand.class);
		this.brandrepository.save(brand);	
	}
	

	@Override
	public GetByIdBrandResponse getById(int id) {
		
	Brand brand =this.brandrepository.findById(id).orElseThrow();
		
	GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}

	
	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
	
		Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
		this.brandrepository.save(brand);
	}
	

	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
	this.brandrepository.deleteById(deleteBrandRequest.getId());
		
	}
	

}
