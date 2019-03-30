package jovan.jakimovski.receptiapp.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne               //Ne sakame Cascade opcii TUKA, ako go izbrisam Notes NE SAKAM DA JA IZBRISE I RECEPT
    private Recipe recipe;

    @Lob                    //Large Object -> za da cuvame poveke od default 255
    private String recipeNotes;

    public Notes() {
    }

}
