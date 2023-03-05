package olga.sockswebshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * количество пар носков
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SocksBatch {
    private Socks socks;
    private int quantity;
}
