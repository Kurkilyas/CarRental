package kodlama.io.rentACar.business.payment;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

@Service
public class EthereumService {
    private final Web3j web3j;

    public EthereumService() {
        // Ethereum ağına bağlan
        this.web3j = Web3j.build(new HttpService("https://mainnet.infura.io/v3/YOUR_INFURA_PROJECT_ID"));
    }

    public boolean verifyTransaction(String transactionHash) throws IOException {
        // İşlem detaylarını kontrol et
        TransactionReceipt receipt = web3j.ethGetTransactionReceipt(transactionHash)
                .send()
                .getTransactionReceipt()
                .orElse(null);

        if (receipt != null && receipt.isStatusOK()) {
            System.out.println("İşlem başarılı!");
            return true;
        } else {
            System.out.println("İşlem başarısız!");
            return false;
        }
    }
}