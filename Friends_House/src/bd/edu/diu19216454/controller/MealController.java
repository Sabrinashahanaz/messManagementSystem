
package bd.edu.diu19216454.controller;


import bd.edu.diu19216454.model.Meal;

/**
 *
 * @author Shahanaz
 */
public class MealController {
    public boolean save(Meal meal){
        return meal.save();
}
}
