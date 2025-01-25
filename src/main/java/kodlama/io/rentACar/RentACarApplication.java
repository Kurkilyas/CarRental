package kodlama.io.rentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentACar.core.utilities.exceptions.ValidationProblemDetails;





@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@RestControllerAdvice
@Component
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException)
	{
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
	}


	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException)
	{
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALİDATİON.EXCEPTİON ");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());


		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {

			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());

		}


		return validationProblemDetails;
	}


	/*@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		Employee employee1 = Employee.builder()
				.firstName("Ramesh")
				.lastName("Fadatare")
				.email("ramesh@gmail.com")
				.build();

		Employee employee2 = Employee.builder()
				.firstName("Tony")
				.lastName("Stark")
				.email("tony@gmail.com")
				.build();

		Employee employee3 = Employee.builder()
				.firstName("John")
				.lastName("Cena")
				.email("cena@gmail.com")
				.build();

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
	}*/




}
