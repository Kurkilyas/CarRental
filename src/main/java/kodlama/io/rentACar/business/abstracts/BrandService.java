package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.DeleteBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest brandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);

}
