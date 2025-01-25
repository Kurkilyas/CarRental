package kodlama.io.rentACar.business.concretes;

import jakarta.servlet.http.HttpSession;
import kodlama.io.rentACar.business.abstracts.PaymentRecordsService;
import kodlama.io.rentACar.business.requests.payment.PaymentRecordsRequest;
import kodlama.io.rentACar.business.responses.color.GetAllColorResponse;
import kodlama.io.rentACar.business.responses.payment.PaymentRecordsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.PaymentRecordsRepository;
import kodlama.io.rentACar.entities.concretes.PaymentRecords;
import kodlama.io.rentACar.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentRecordsManager implements PaymentRecordsService {
    private  PaymentRecordsRepository paymentRecordsRepository;
    private ModelMapperService modelMapperService;





    @Override
    public void add(PaymentRecordsRequest request, HttpSession session) {
        PaymentRecords paymentRecords = modelMapperService.forRequest().map(request, PaymentRecords.class);

        // Kullanıcı ID'sini oturumdan al
        long userId = (long) session.getAttribute("userId");
        paymentRecords.setUserId(userId);

        // Ödeme tarihini ayarla
        paymentRecords.setPaymentDate(java.time.LocalDateTime.now().toString());

        // PaymentRecords tablosuna kaydet
        paymentRecordsRepository.save(paymentRecords);
    }

    @Override
    public List<PaymentRecordsResponse> getAll() {
        List<PaymentRecords> paymentRecords=paymentRecordsRepository.findAll();
        List<PaymentRecordsResponse> paymnetRecordsResponses=paymentRecords.stream().map(paymentrecord->this.modelMapperService.forResponse().map(paymentrecord, PaymentRecordsResponse.class))
                .collect(Collectors.toList());



        return paymnetRecordsResponses;
    }

    @Override
    public PaymentRecordsResponse getById(int id) {
        return null;
    }


}
