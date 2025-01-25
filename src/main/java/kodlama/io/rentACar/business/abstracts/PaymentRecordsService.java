package kodlama.io.rentACar.business.abstracts;

import jakarta.servlet.http.HttpSession;
import kodlama.io.rentACar.business.requests.payment.PaymentRecordsRequest;
import kodlama.io.rentACar.business.responses.payment.PaymentRecordsResponse;


import java.util.List;

public interface PaymentRecordsService {

    void add(PaymentRecordsRequest request, HttpSession session);
    List<PaymentRecordsResponse> getAll();
    PaymentRecordsResponse getById(int id);
}
