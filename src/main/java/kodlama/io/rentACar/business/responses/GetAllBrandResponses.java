package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBrandResponses {
    private int id ;
    private String name;


}
