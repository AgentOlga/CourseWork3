package olga.sockswebshop.service;

import olga.sockswebshop.model.Color;
import olga.sockswebshop.model.Size;
import olga.sockswebshop.model.SocksBatch;

public interface SocksStoreService {
    void accept(SocksBatch socksBatch);
    int issuance(SocksBatch socksBatch);
    int reject(SocksBatch socksBatch);
    int getCount(Color color, Size size, int cottonMin, int cottonMax);
}
