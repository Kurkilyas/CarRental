package kodlama.io.rentACar.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlama.io.rentACar.business.requests.car.CreateCarRequest;
import kodlama.io.rentACar.business.requests.car.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.GetAllCarNewResponse;
import kodlama.io.rentACar.business.responses.car.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.car.GetCarByID;
import kodlama.io.rentACar.business.responses.car.GetCarUpdateResponse;
import kodlama.io.rentACar.entities.concretes.Car;
import org.springframework.web.multipart.MultipartFile;

public interface CarService {
	List<GetAllCarNewResponse>  getAll();
	public void add(CreateCarRequest createCarRequest, MultipartFile multipartFile);
	public void update(UpdateCarRequest updateCarRequest,MultipartFile multipartFile);
	public void delete(int id);
	GetCarByID getById(int id);
	GetCarUpdateResponse getById2(int id);
	public void processPaymentAndUpdateStatus(int carId,String transactionHash);
	public Optional<Car> getCarById(int id);




}
