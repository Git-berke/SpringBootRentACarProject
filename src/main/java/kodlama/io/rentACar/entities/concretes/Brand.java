package kodlama.io.rentACar.entities.concretes;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.processing.Generated;

@Table(name="brands")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id //sen veritabanında id keysin
    @GeneratedValue(strategy = GenerationType.IDENTITY) // sen bir veri arttır demekmiiş
    @Column(name = "id")
    private int id;//primary key olarak düşünülmelidir aynı zamanda tekrar edemezsin anlamına gelir

    @Column(name ="name")
    private String name;

}
