package lt.sda.store.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "lt.sda.store.stocks")
@Data
public class ProductStock {
    private Integer apple;
    private Integer orange;
    private Integer carrot;
    private Integer potato;
}
