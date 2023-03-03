package olga.sockswebshop.service;

import olga.sockswebshop.model.Color;
import olga.sockswebshop.model.Size;
import olga.sockswebshop.model.SocksBatch;
import olga.sockswebshop.model.*;
import org.springframework.stereotype.Service;

@Service
public interface ValidationService {
    boolean validate (SocksBatch socksBatch);
    boolean validate(Color color, Size size, int cottonMax, int cottonMin);

}
