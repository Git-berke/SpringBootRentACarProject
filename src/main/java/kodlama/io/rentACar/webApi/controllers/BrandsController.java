package kodlama.io.rentACar.webApi.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.rentACar.business.abstacts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;



   @GetMapping()
   public List<GetAllBrandResponses> getAllBrands()
   {
       return brandService.getAll();
   }

   @GetMapping("/{id}")
   public GetByIdResponse getById(@PathVariable int id)
   {
       return brandService.getById(id);
   }

   @PostMapping()
   @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody()CreateBrandRequest createBrandRequest)
   {
       this.brandService.add(createBrandRequest);
   }

   @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest)
   {
       this.brandService.update(updateBrandRequest);
   }

   @DeleteMapping("/{delete}")
    public void delete(@PathVariable int id)
   {
       this.brandService.delete(id);
   }



}
