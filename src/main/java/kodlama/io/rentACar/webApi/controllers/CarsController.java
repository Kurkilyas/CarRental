package kodlama.io.rentACar.webApi.controllers;

import java.util.*;

import kodlama.io.rentACar.business.requests.payment.PaymentRequest;
import kodlama.io.rentACar.business.responses.car.GetAllCarNewResponse;
import kodlama.io.rentACar.business.responses.car.GetCarByID;
import kodlama.io.rentACar.business.responses.car.GetCarUpdateResponse;
import kodlama.io.rentACar.business.responses.payment.CarStatusResponse;
import kodlama.io.rentACar.business.responses.payment.ErrorResponse;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.car.CreateCarRequest;
import kodlama.io.rentACar.business.requests.car.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.GetAllCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller

@AllArgsConstructor
public class CarsController {
	private CarService carService;


	@GetMapping("/allAds.html")

	public String getAll(Model model) {


		List<GetAllCarNewResponse> getAllCarResponses= this.carService.getAll();
		model.addAttribute("AllCars",getAllCarResponses);
		return "allAds";
	}



	@GetMapping("/cars/{id}")  //Update Ekranına verileri getirme
	@ResponseBody
	public ResponseEntity<?> getCarDetails(@PathVariable int id) {
		try {
			GetCarUpdateResponse carDetails = carService.getById2(id); // GetCarByID modeli kullanarak veriyi çekiyoruz.
			if (carDetails == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Araç bulunamadı.");
			}
			return ResponseEntity.ok(carDetails);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu: " + e.getMessage());
		}
	}
	@GetMapping("/cars/{id}/details")
	public String getCarsById(@PathVariable int id, Model model) {
		Optional<GetCarByID> carOptional = Optional.ofNullable(this.carService.getById(id));

		if (carOptional.isPresent()) {
			GetCarByID getCarByID = carOptional.get();
			model.addAttribute("Cars", getCarByID);
			return "bookNow";
		} else {
			// Araba bulunamadı, hata durumu veya yönlendirme yapılabilir.
			return "redirect:/error";
		}
	}
	@GetMapping("/cars/{id}/getstatus")
	public ResponseEntity<CarStatusResponse> getCarStatus(@PathVariable int id) {
		Optional<Car> carOptional = carService.getCarById(id);

		if (!carOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		Car car = carOptional.get();
		CarStatusResponse response = new CarStatusResponse();

		// car.getStatus() yerine uygun string değeri döndürün
		response.setStatus(car.getStatus().getName()); // "getName()" methodu örnek olarak kullanılmıştır

		return ResponseEntity.ok(response);
	}
	@PostMapping("/cars/{id}/pay")
	@ResponseBody
	public ResponseEntity<?> payAndUpdateStatus(
			@PathVariable int id,
			@RequestBody PaymentRequest paymentRequest) {
		try {
			// Ödeme işlemi alınıyor ve araç durumu güncelleniyor
			carService.processPaymentAndUpdateStatus(id, paymentRequest.getTransactionHash());
			return ResponseEntity.ok(Map.of("success", true, "message", "Ödeme başarılı, araç durumu güncellendi."));
		} catch (RuntimeException e) {
			// Hata durumunda kullanıcıya mesaj dönüyoruz
			return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
		}
	}


	@PostMapping("/guncelleme")
	@ResponseBody
	public ResponseEntity<?> update(@ModelAttribute UpdateCarRequest uptadeCarRequest,@RequestParam("carPhoto") MultipartFile carPhoto) {
		this.carService.update(uptadeCarRequest,carPhoto);
		Map<String, Object> response = new HashMap<>();
		try {
			// Servis metodunu çağırarak aracı ekliyoruz
			this.carService.update(uptadeCarRequest, carPhoto);

			response.put("success", true);
			response.put("message", "Araç Başarıyla Güncellendi");


			// Başarı durumunda JSON yanıtı döndürüyoruz
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			// Hata durumunda JSON yanıtı döndürüyoruz
			response.put("success", false);
			response.put("message", "Araç güncellenirken bir hata oluştu.");
			return ResponseEntity.status(500).body(response);
		}
	}

	/*@DeleteMapping("/delete/{id}")

	public String delete(@PathVariable int id) {
		this.carService.delete(id);
		return "Araba başarıyla silindi";
	}*/

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		try {
			this.carService.delete(id);

			// Başarı durumunda 200 OK yanıtı gönderin
			return ResponseEntity.ok("Araba başarıyla silindi");
		} catch (Exception e) {
			// Hata durumunda 500 Internal Server Error yanıtı gönderin
			return ResponseEntity.status(500).body("Araba silinirken bir hata oluştu");
		}
	}
	@PostMapping("/ekleme")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> addCar(
			@ModelAttribute CreateCarRequest createCarRequest,
			@RequestParam("carPhoto") MultipartFile carPhoto)
	{
		Map<String, Object> response = new HashMap<>();
		try {
			// Servis metodunu çağırarak aracı ekliyoruz
			this.carService.add(createCarRequest, carPhoto);

			response.put("success", true);
			response.put("message", "Araç Başarıyla Eklendi");


			// Başarı durumunda JSON yanıtı döndürüyoruz
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			// Hata durumunda JSON yanıtı döndürüyoruz
			response.put("success", false);
			response.put("message", "Araç eklenirken bir hata oluştu.");
			return ResponseEntity.status(500).body(response);
		}
	}


}

