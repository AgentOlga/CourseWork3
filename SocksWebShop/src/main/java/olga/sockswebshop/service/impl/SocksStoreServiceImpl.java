package olga.sockswebshop.service.impl;

import olga.sockswebshop.exception.ValidationException;
import olga.sockswebshop.model.Color;
import olga.sockswebshop.model.Size;
import olga.sockswebshop.model.Socks;
import olga.sockswebshop.model.SocksBatch;
import olga.sockswebshop.service.SocksStoreService;
import olga.sockswebshop.service.ValidationService;
import olga.sockswebshop.stock.SocksStock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor

public class SocksStoreServiceImpl implements SocksStoreService {
    private final SocksStock socksStock;
    private final ValidationService validationService;
    @Override
    public void accept(SocksBatch socksBatch){
        checkSocksBatch(socksBatch);
        socksStock.save(socksBatch);
    }
    @Override
    public int issuance(SocksBatch socksBatch){
        checkSocksBatch(socksBatch);
        return socksStock.remove(socksBatch);
    }
    @Override
    public int reject(SocksBatch socksBatch){
        checkSocksBatch(socksBatch);
        return socksStock.remove(socksBatch);
    }
    @Override
    public int getCount(Color color, Size size, int cottonMin, int cottonMax ) {
        if (!validationService.validate(color,size,cottonMax,cottonMin)) {
            throw new ValidationException();

        }
        Map<Socks, Integer> socksMap = socksStock.getAll();
        int socksCounter = 0;
        for (Map.Entry<Socks, Integer> socksItem : socksMap.entrySet()) {
            Socks socks = socksItem.getKey();
            if (socks.getColor().equals(color)
                    && socks.getSize().equals(size)
                    && socks.getCottonPart() <= cottonMin
                    && socks.getCottonPart() >= cottonMax) {
               socksCounter =  socksCounter + socksItem.getValue();
            }
        }
        return socksCounter;
    }
    private void checkSocksBatch(SocksBatch socksBatch) {
        if (!validationService.validate(socksBatch)) {
            throw new ValidationException();
        }
    }
}



