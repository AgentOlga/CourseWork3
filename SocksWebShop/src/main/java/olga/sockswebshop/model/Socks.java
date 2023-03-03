package olga.sockswebshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * носки
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Socks {
    private Color color;
    private Size size;
    private int cottonPart;
}
