/*
package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carimages")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Lob
    @Column(name = "image_data", columnDefinition = "bytea")
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    // Getter ve setter metotları

    // Constructors
}

*/
