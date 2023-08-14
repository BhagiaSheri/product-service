package product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service", url = "http://localhost:8900")
public interface StockFeignClient {

    @RequestMapping("/api/v1/stocks/{productNumber}")
    long getProductStock(@PathVariable("productNumber") String productNumber);

}
