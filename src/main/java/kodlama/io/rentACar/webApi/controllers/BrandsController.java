package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.DeleteBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
//www.kodlama.io/api/brands/getAll buradaki domain adresine bakarak request mapping "api/brands" kısmını oluşturuyor ve getmapping'de "/getAll" deyince o fonksiyonu çağırır
@RestController //annotation:bilgilendirme ifadesi
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	
	
	private BrandService brandService;
	
	
	
	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll()
	{
		return brandService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id)
	{
		return brandService.getById(id);
	}
	
	
	
	
	@PostMapping("/save")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody @Valid  CreateBrandRequest brandRequest)
	{
		brandService.add(brandRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest)
	{
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody DeleteBrandRequest deleteBrandRequest)
	{
		this.brandService.delete(deleteBrandRequest);
	}		
}
 	 	 	