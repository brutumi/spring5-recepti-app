package jovan.jakimovski.receptiapp.domain;

import javax.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne               //Ne sakame Cascade opcii TUKA, ako go izbrisam Notes NE SAKAM DA JA IZBRISE I RECEPT
    private Recipe recipe;

    @Lob                    //Large Object -> za da cuvame poveke od default 255
    private String recipeNotes;

    //region GETTERS_AND_SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    //endregion
}
