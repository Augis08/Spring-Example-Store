package lt.sda.store.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "lt.sda.store.prices")
@Data
public class ProductPrice {
    private  Double applePrice;
    private  Double orangePrice;
    private  Double carrotPrice;
    private  Double potatoPrice;
}
