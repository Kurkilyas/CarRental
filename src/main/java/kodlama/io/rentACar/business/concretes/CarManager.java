package kodlama.io.rentACar.business.concretes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import kodlama.io.rentACar.business.responses.car.GetAllCarNewResponse;
import kodlama.io.rentACar.business.responses.car.GetCarByID;
import kodlama.io.rentACar.business.responses.car.GetCarUpdateResponse;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.dataAccess.abstracts.StatusRepository;
import kodlama.io.rentACar.entities.concretes.Status;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.car.CreateCarRequest;
import kodlama.io.rentACar.business.requests.car.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.GetAllCarResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	private ModelRepository modelRepository;
	private StatusRepository statusRepository;

	
	@Override

	public List<GetAllCarNewResponse> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<GetAllCarNewResponse> getAllCarNewResponses = cars.stream()
				.map(car -> {
					// Car objesini GetAllCarNewResponse'a dönüştür
					GetAllCarNewResponse response = this.modelMapperService.forResponse().map(car, GetAllCarNewResponse.class);

					// Model ID'den marka adını al ve set et
					response.setBrandName(getBrandNameFromModel(car.getModel().getId()));

					// Car fotoğrafını Base64 formatına dönüştür
					if (car.getCarPhoto() != null) {
						String base64Photo = convertToBase64(car.getCarPhoto());
						response.setCarPhotoBase64(base64Photo); // Base64 olarak fotoğrafı set et
					}

					return response;
				})
				.collect(Collectors.toList());

		return getAllCarNewResponses;
	}

	private String convertToBase64(byte[] fileBytes) {
		return Base64.getEncoder().encodeToString(fileBytes);
	}
	@Override
	public void add(CreateCarRequest createCarRequest,MultipartFile carPhoto) {
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);

		// Fotoğraf yükleme işlemi

		byte[] photoUrl = savePhoto(carPhoto);
		car.setCarPhoto(photoUrl);
	// s	System.out.println(Base64.getEncoder().encodeToString(car.getCarPhoto()));

		this.carRepository.save(car);
	}

	private byte[] savePhoto(MultipartFile carPhoto) {
		if (carPhoto != null && !carPhoto.isEmpty()) {
			try {
				return carPhoto.getBytes(); // Dosya içeriğini byte[] olarak döndür
			} catch (IOException e) {
				throw new RuntimeException("Fotoğraf yükleme sırasında bir hata oluştu.", e);
			}
		}
		return null;
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest,MultipartFile carPhoto) {
		Car car=this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		byte[] photoUrl = savePhoto(carPhoto);
		car.setCarPhoto(photoUrl);
		this.carRepository.save(car);
		
	}

	@Override
	public void delete(int id) {
		this.carRepository.deleteById(id);
		
	}

	/*@Override

	public GetCarByID getById(int id) {
		Car car=this.carRepository.findById(id).orElseThrow();

		GetCarByID getCarByID=this.modelMapperService.forResponse().map(car,GetCarByID.class);
		getCarByID.setBrandName(getBrandNameFromModel(car.getId()));
		return getCarByID;
	}
	private String getBrandNameFromModel(int id) {
		// Model adından Brand adını çekmek için gerekli işlemleri yapın
		// Örnek olarak, Model adından Brand adını çıkarmak:

		return this.modelRepository.findBrandNameById(id);
	}*/
	@Override
	public Optional<Car> getCarById(int id) {   //Status Durumu için
		return carRepository.findById(id);
	}
	@Override
	public GetCarByID getById(int id) {
		Car car = this.carRepository.findById(id).orElseThrow();

		GetCarByID getCarByID = this.modelMapperService.forResponse().map(car, GetCarByID.class);
		getCarByID.setBrandName(getBrandNameFromModel(car.getModel().getId()));
		if (car.getCarPhoto() != null) {
			String carPhotoBase64 = Base64.getEncoder().encodeToString(car.getCarPhoto());
			getCarByID.setCarPhoto(carPhotoBase64);
		} else {
			getCarByID.setCarPhoto(null); // Fotoğraf yoksa null olarak ayarla
		}

		return getCarByID;
	}

	@Override
	public GetCarUpdateResponse getById2(int id) {
		Car car = this.carRepository.findById(id).orElseThrow();

		GetCarUpdateResponse getCarUpdateResponse = this.modelMapperService.forResponse().map(car, GetCarUpdateResponse.class);
		getCarUpdateResponse.setBrandId(getBrandNameFromModel(car.getModel().getId()));


		return getCarUpdateResponse;
	}


	@Override
	public void processPaymentAndUpdateStatus(int carId, String transactionHash) {
		if (transactionHash == null || transactionHash.isEmpty()) {
			throw new RuntimeException("Geçersiz ödeme işlemi!");
		}

		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new RuntimeException("Araç bulunamadı!"));

		if (car.getStatus().getName().equalsIgnoreCase("dolu")) {
			throw new RuntimeException("Bu araç dolu olduğu için işlem yapılamaz.");
		}

		Status doluStatus = statusRepository.findByName("dolu")
				.orElseThrow(() -> new RuntimeException("Dolu durumu bulunamadı!"));

		car.setStatus(doluStatus);
		carRepository.save(car);
	}


	private String getBrandNameFromModel(int modelId) {
		return this.modelRepository.findBrandNameById(modelId);
	}

}
