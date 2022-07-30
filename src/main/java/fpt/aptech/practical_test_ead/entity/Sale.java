package fpt.aptech.practical_test_ead.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slNo;
    private String salesmanId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product prodID;
    private String salesmanName;
    private String DOS;
}