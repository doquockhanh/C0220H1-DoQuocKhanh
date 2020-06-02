package Service.Impl;

import Service.ConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public Long convert(long amountOFMoney, int exchangeRate) {
        return amountOFMoney*exchangeRate;
    }
}
