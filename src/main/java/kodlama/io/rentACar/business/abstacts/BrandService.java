package kodlama.io.rentACar.business.abstacts;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    // iş kurallarını  yazacağım  kuralları tasarladığımız yer
    List<GetAllBrandResponses> getAll();
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    GetByIdResponse getById(int id);


}
