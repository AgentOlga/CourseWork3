package olga.sockswebshop.stock;

import olga.sockswebshop.model.Socks;
import olga.sockswebshop.model.SocksBatch;

import java.util.Map;

public interface SocksStock {
    void save(SocksBatch socksBatch);
    int remove(SocksBatch socksBatch);
    Map<Socks, Integer> getAll();

}
