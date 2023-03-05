package olga.sockswebshop.service.impl;

import olga.sockswebshop.model.Color;
import olga.sockswebshop.model.Size;
import olga.sockswebshop.model.SocksBatch;
import olga.sockswebshop.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {


    @Override
    public boolean validate(SocksBatch socksBatch) {
        return socksBatch.getSocks() != null
                && socksBatch.getQuantity() > 0
                && socksBatch.getSocks().getColor() != null
                && socksBatch.getSocks().getSize() != null
                && checkCottonPart(socksBatch.getSocks().getCottonPart(),
                socksBatch.getSocks().getCottonPart());
    }

    @Override
    public boolean validate(Color color, Size size, int cottonMax, int cottonMin) {
        return color != null &&
                size != null &&
                checkCottonPart(cottonMax, cottonMin);
    }
    private boolean checkCottonPart( int cottonMax, int cottonMin) {
        return cottonMin >= 0 && cottonMax <= 100;
    }
}
