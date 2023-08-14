package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	@Autowired
	StockFeignClient stockFeignClient;

	@GetMapping("/{productNumber}")
	public Product getProduct(@PathVariable String productNumber) {
		Product product = new Product(productNumber, "Product # 1", stockFeignClient.getProductStock(productNumber));
		System.out.println("*** Product With Stock:---> "+ product);
		return product;
	}
}
