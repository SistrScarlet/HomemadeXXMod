package com.sistr.homemadexx.datagen;

import com.sistr.homemadexx.setup.Registration;
import net.minecraft.data.*;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(Registration.PARASOL_ITEM.get())
                .patternLine("WWI")
                .patternLine(" RW")
                .patternLine("R W")
                .key('R', Tags.Items.RODS_WOODEN)
                .key('I', Tags.Items.NUGGETS_IRON)
                .key('W', ItemTags.WOOL)
                .addCriterion("has_wool", this.hasItem(ItemTags.WOOL))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(Registration.MUFFLER_ITEM.get())
                .patternLine(" WW")
                .patternLine("  W")
                .patternLine("  W")
                .key('W', ItemTags.WOOL)
                .addCriterion("has_wool", this.hasItem(ItemTags.WOOL))
                .build(consumer);
    }
}
