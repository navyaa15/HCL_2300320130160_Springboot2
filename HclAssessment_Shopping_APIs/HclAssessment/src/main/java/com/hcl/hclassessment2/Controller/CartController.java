package com.hcl.hclassessment2.Controller;

import com.hcl.hclassessment2.Service.*; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*; import org.springframework.http.HttpStatus;

@RestController @RequestMapping("/api/cart") public class CartController {
private final CartService service; public CartController(CartService service){this.service=service;}
@PostMapping("/add/{customerId}/{productId}") public CartResponse add(@PathVariable Long customerId,@PathVariable Long productId,@Valid @RequestBody QuantityRequest request){return service.add(customerId,productId,request.quantity());}
@GetMapping("/{customerId}") public CartResponse view(@PathVariable Long customerId){return service.view(customerId);}
@PutMapping("/update/{cartItemId}") public CartResponse update(@PathVariable Long cartItemId,@Valid @RequestBody QuantityRequest request){return service.update(cartItemId,request.quantity());}
@DeleteMapping("/remove/{cartItemId}") @ResponseStatus(HttpStatus.NO_CONTENT) public void remove(@PathVariable Long cartItemId){service.remove(cartItemId);}
@DeleteMapping("/clear/{customerId}") @ResponseStatus(HttpStatus.NO_CONTENT) public void clear(@PathVariable Long customerId){service.clear(customerId);}
}
