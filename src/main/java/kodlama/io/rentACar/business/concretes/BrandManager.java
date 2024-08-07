package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstacts.BrandService;
import kodlama.io.rentACar.business.core.utilities.mapper.ModelMapperService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // bu sınıf bir business nesnesidir

public class BrandManager implements BrandService
{
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;



    public BrandManager(BrandRepository brandRepository)
    {
        super();
        this.brandRepository = brandRepository;

    }
    @Override
    public List<GetAllBrandResponses> getAll() {
      List<Brand> brands = this.brandRepository.findAll();
     // List<GetAllBrandResponses> responses = new ArrayList<GetAllBrandResponses>();
//        for (Brand brand : brands) {
//            GetAllBrandResponses response = new GetAllBrandResponses();
//            response.setId(brand.getId());
//            response.setName(brand.getName());
//            responses.add(response);
//        }
        // iş kuralları

        List<GetAllBrandResponses> brandResponses = brands.stream().
                map(brand ->this.modelMapperService.forResponse().map(brand, GetAllBrandResponses.class)).collect(Collectors.toList());





        return brandResponses;




    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
       // Brand brand = new Brand();
        //brand.setName(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        //createBrandRequest türünü brand classına çevirmek
        this.brandRepository.save(brand);

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
     }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }

    @Override
    public GetByIdResponse getById(int id) {
       Brand brand =   this.brandRepository.findById(id).orElseThrow();

       GetByIdResponse getByIdResponse = this.modelMapperService.forResponse().map(brand, GetByIdResponse.class);
        return getByIdResponse;
    }
}
