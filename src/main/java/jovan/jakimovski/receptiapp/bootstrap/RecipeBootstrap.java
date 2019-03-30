package jovan.jakimovski.receptiapp.bootstrap;

import jovan.jakimovski.receptiapp.domain.*;
import jovan.jakimovski.receptiapp.repositories.CategoryRepository;
import jovan.jakimovski.receptiapp.repositories.RecipeRepository;
import jovan.jakimovski.receptiapp.repositories.UnitOfMeasureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading bootstrap data");
    }

    //test

    public List<Recipe> getRecipes(){

        log.debug("Getting unit of measures");

        Optional<UnitOfMeasure> unitOfMeasure1 = unitOfMeasureRepository.findByDescription("mLazica");
        Optional<UnitOfMeasure> unitOfMeasure2 = unitOfMeasureRepository.findByDescription("gLazica");
        Optional<UnitOfMeasure> unitOfMeasure3 = unitOfMeasureRepository.findByDescription("kapki");
        Optional<UnitOfMeasure> unitOfMeasure4 = unitOfMeasureRepository.findByDescription("Ml");
        Optional<UnitOfMeasure> unitOfMeasure5 = unitOfMeasureRepository.findByDescription("Gram");
        Optional<UnitOfMeasure> unitOfMeasure6 = unitOfMeasureRepository.findByDescription("Paketce");

        if(!unitOfMeasure1.isPresent() && !unitOfMeasure2.isPresent() && !unitOfMeasure3.isPresent() && !unitOfMeasure4.isPresent()
           && !unitOfMeasure5.isPresent() && !unitOfMeasure6.isPresent())
            throw new RuntimeException("Expected UOM not found");

        UnitOfMeasure unitOfMeasure11 = unitOfMeasure1.get();
        UnitOfMeasure unitOfMeasure22 = unitOfMeasure2.get();
        UnitOfMeasure unitOfMeasure33 = unitOfMeasure3.get();
        UnitOfMeasure unitOfMeasure44 = unitOfMeasure4.get();
        UnitOfMeasure unitOfMeasure55 = unitOfMeasure5.get();
        UnitOfMeasure unitOfMeasure66 = unitOfMeasure6.get();


        //region GET_CATEGORIES

        Optional<Category> categoryOptional1= categoryRepository.findByDescription("Makedonska");
        Optional<Category> categoryOptional2= categoryRepository.findByDescription("Grcka");
        Optional<Category> categoryOptional3= categoryRepository.findByDescription("Mandzi");
        Optional<Category> categoryOptional4= categoryRepository.findByDescription("Rolati");


        if(!categoryOptional1.isPresent() && !categoryOptional2.isPresent() && !categoryOptional3.isPresent() && !categoryOptional4.isPresent())
            throw new RuntimeException("Expected Category not found");

        Category category1 = categoryOptional1.get();
        Category category2 = categoryOptional2.get();
        Category category3 = categoryOptional3.get();
        Category category4 = categoryOptional4.get();


        //endregion

        List<Recipe> recipes = new ArrayList<>();

        //region DODAVANJE_RECEPTI

            //ZIRAFA ROLAT
        Recipe zirafaRolat = new Recipe();
        zirafaRolat.setDescription("Najdobriot rolat");
        zirafaRolat.setPrepTime(40);
        zirafaRolat.setCookTime(10);
        zirafaRolat.setServings(10);
        zirafaRolat.setDifficulty(Difficulty.EASY);
        zirafaRolat.setDirections("Основна смеса\n" +
                "1. Изматете ги жолчките и шеќерот и ванилиниот шеќер, додадете ги млекото и маслото и матете додека да добиете хомогена смеса. Додадете го брашното и мешајте убаво. Од оваа смеса одвојте 2 ЛАЖИЦИ И СТАВЕТЕ ГИ НА СТРАНА. Ќе ви требаат за светлиот дел.\n" +
                "2. Подгответе го додатокот, изматете ги цврсто белките, шеќерот и малку лимонов сок и полека оваа смеса додадете ја на основната смеса и измешајте ги.\n" +
                "На крај додадете го какаото и убаво измешајте.\n" +
                "3. Преминете на подготовка на светлиот дел, изматете ја белката со шеќерот, додадете го брашното и 2 лажици од основната смеса, кои претходно ги тргнавте на страна. Убаво измешајте и турете ја оваа смеса во пластична кеса или во шприц, јас користев мал шприц за декорирање. Исечете го едниот крај од кесата ако користите ќеса и со помош на овој импровизиран шприц направете шари.\n" +
                "Шарите цртајте ги на хартија за печење поставена во плех, јас ја намастив малку хартијата одозгора со масло пред да цртам.\n" +
                "4. Откако ќе ги направите шарите, ставете да се пече во загреана рерна на 170 степени САМО 1 минута колку да се стврдни малку. Немојте да печете подолго време во никој случај.\n" +
                "Извадете го плехот од рерна, па над печените шари прелијте ја темната смеса и оставете да се пече уште 15тина минути.\n" +
                "5. После печење, извадете го плехот и преместете го пандишпанот со се хартија и оставете да се излади (не ја вадете хартијата за печење).\n" +
                "6. Подготовка на филот, се вари слатката павлака со чоколадото и се додава кремот. Оваа смеса се лади убаво да се згусни. Мене не знам од кои причини воопшто не ми се згусна смесата, па затоа ставив 1 кесичка шлаг во прав и го изматив и добив прекрасен фил. Значи шлагот е опционален.\n" +
                "7. Нанесете го филот, ставете банани (по желба) и внимателно замотајте го ролатот и постепено вадете ја хартијата за печење од кората.\n" +
                "8. Добиениот ролат замотајте го хартија или во најлонска фолија убаво и ставете го фрижидер неколку часа или преку ноќ. Вкусот е како на прекрасна торта.\n" +
                "\n" +
                "Прочитај повеќе: https://moirecepti.mk/post/%D0%B6%D0%B8%D1%80%D0%B0%D1%84%D0%B0-%D1%80%D0%BE%D0%BB%D0%B0%D1%82");

        Notes zirafaNotes = new Notes();
        zirafaNotes.setRecipeNotes("Познатиот жирафа ролат, одамна сакав да се пробам со него после 1 неуспешен обид и испадна совршен! Не е комплициран за правење, само бара постапност и трпение. Моментот кога ќе ја поттргниш хартијата за печење и ќе ги видиш совршените шари е бесценет.\n" +
                "\n" +
                "Прочитај повеќе: https://moirecepti.mk/post/%D0%B6%D0%B8%D1%80%D0%B0%D1%84%D0%B0-%D1%80%D0%BE%D0%BB%D0%B0%D1%82");

        zirafaNotes.setRecipe(zirafaRolat);
        zirafaRolat.setNotes(zirafaNotes);

        zirafaRolat.getIngredients().add(new Ingredient("belki od jajca", new BigDecimal(7), unitOfMeasure11, zirafaRolat));
        zirafaRolat.getIngredients().add(new Ingredient("seker", new BigDecimal(14), unitOfMeasure22,zirafaRolat));
        zirafaRolat.getIngredients().add(new Ingredient("meleni orevi", new BigDecimal(7), unitOfMeasure33,zirafaRolat));
        zirafaRolat.getIngredients().add(new Ingredient("seker vo prav", new BigDecimal(100), unitOfMeasure55,zirafaRolat));

        zirafaRolat.getCategories().add(category1);
        zirafaRolat.getCategories().add(category2);

        //add to return list
        recipes.add(zirafaRolat);

        //endregion


        return recipes;

    }
}

