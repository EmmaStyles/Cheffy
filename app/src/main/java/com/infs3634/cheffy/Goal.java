package com.infs3634.cheffy;

import java.util.ArrayList;
import java.util.List;

// Class that established Goal object
public class Goal {
    public static final String ARG_ITEM_ID = "item_id";
    public String goalId;
    public String goalText;
    public String goalTheme;
    public Boolean goalBoolean;

    public Goal(){
    }

    public Goal (String goalId, String goalText, String goalTheme, Boolean goalBoolean){
        this.goalId = goalId;
        this.goalText = goalText;
        this.goalTheme = goalTheme;
        this.goalBoolean = goalBoolean;
    }

    public void setGoalId(String goalId) {
        this.goalId = goalId;
    }

    public void setGoalText(String goalText){
        this.goalText = goalText;
    }

    public void setGoalTheme(String goalTheme){
        this.goalTheme = goalTheme;
    }

    public void setGoalBoolean(Boolean goalBoolean) {
        this.goalBoolean = goalBoolean;
    }

    public String getGoalId(){
        return goalId;
    }

    public String getGoalText(){
        return goalText;
    }

    public String getGoalTheme(){
        return goalTheme;
    }

    public Boolean getGoalBoolean() {
        return goalBoolean;
    }

    public static Goal getGoal(String id) {
        for(Goal goal : getGoals()){
            if (goal.getGoalId().equals(id)) {
                return goal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return goalId;
    }

    //CountCheckedGoals is not used but was designed to count number of 'True's (number of flicked switches)
    // and report it back to level and graph on Main Activity
    public static int countCheckedGoals(){
        int m = 0;
        for (Goal goal : getGoals()){
            if (goal.getGoalBoolean() == true){
                m++;
            }
        }
        return m;
    }

    public static List<Goal> getGoals() {
        List<Goal> goals = new ArrayList<>();
        goals.add(new Goal("1", "Learn to bake a cake", "1.Learn single", false));
        goals.add(new Goal("2", "Learn to bake bread", "1.Learn single", false));
        goals.add(new Goal("3", "Learn to make your own pasta", "1.Learn single", false));
        goals.add(new Goal("4", "Learn to make your own pizza", "1.Learn single", false));
        goals.add(new Goal("5", "Learn to dice an onion", "1.Learn single", false));
        goals.add(new Goal("6", "Learn to dice an onion", "1.Learn single", false));
        goals.add(new Goal("7", "Learn to peel vegetables (eg. potatoes)", "1.Learn single", false));
        goals.add(new Goal("8", "Learn to make your own curry paste", "1.Learn single", false));
        goals.add(new Goal("9", "Cook a dish with pastry", "1.Learn single", false));
        goals.add(new Goal("10", "Learn to steam rice", "1.Learn single", false));
        goals.add(new Goal("11", "Learn to steam vegetables", "1.Learn single", false));
        goals.add(new Goal("12", "Learn use a mortar and pestle", "1.Learn single", false));
        goals.add(new Goal("13", "Learn to make dumplings", "1.Learn single", false));
        goals.add(new Goal("14", "Learn to roast vegetables", "1.Learn single", false));
        goals.add(new Goal("15", "Learn to make a dip", "1.Learn single", false));
        goals.add(new Goal("16", "Learn to make a salad dressing", "1.Learn single", false));
        goals.add(new Goal("17", "Learn to boil an egg", "1.Learn single", false));
        goals.add(new Goal("18", "Learn to use a barbeque", "1.Learn single", false));
        goals.add(new Goal("19", "Learn to make soup", "1.Learn single", false));
        goals.add(new Goal("20", "Learn to roast a meat dish", "1.Learn single", false));
        goals.add(new Goal("21", "Learn to make sushi", "1.Learn single", false));
        goals.add(new Goal("22", "Learn to make a pancake or crepe", "1.Learn single", false));
        goals.add(new Goal("23", "Learn to make popcorn", "1.Learn single", false));
        goals.add(new Goal("24", "Learn to make stuffing", "1.Learn single", false));
        goals.add(new Goal("25", "Learn to make a chutney", "1.Learn single", false));
        goals.add(new Goal("26", "Learn to caramelise onions", "1.Learn single", false));
        goals.add(new Goal("27", "Cook a dish with chicken", "2.Single ingredient/dish", false));
        goals.add(new Goal("28", "Cook a dish with beef", "2.Single ingredient/dish", false));
        goals.add(new Goal("29", "Cook a dish with lamb", "2.Single ingredient/dish", false));
        goals.add(new Goal("30", "Cook a dish with pork", "2.Single ingredient/dish", false));
        goals.add(new Goal("31", "Cook a dish with eggs", "2.Single ingredient/dish", false));
        goals.add(new Goal("32", "Cook a dish with fish or seafood", "2.Single ingredient/dish", false));
        goals.add(new Goal("33", "Cook a dish with cheese", "2.Single ingredient/dish", false));
        goals.add(new Goal("34", "Cook a dish with lentils", "2.Single ingredient/dish", false));
        goals.add(new Goal("35", "Cook a dish with rice", "2.Single ingredient/dish", false));
        goals.add(new Goal("36", "Cook a dish with noodles", "2.Single ingredient/dish", false));
        goals.add(new Goal("37", "Cook a dish with pasta", "2.Single ingredient/dish", false));
        goals.add(new Goal("38", "Cook a stir-fry dish", "2.Single ingredient/dish", false));
        goals.add(new Goal("39", "Cook a curry", "2.Single ingredient/dish", false));
        goals.add(new Goal("40", "Cook a vegetarian dish", "2.Single ingredient/dish", false));
        goals.add(new Goal("41", "Cook a vegan dish", "2.Single ingredient/dish", false));
        goals.add(new Goal("42", "Cook a dish with duck", "2.Single ingredient/dish", false));
        goals.add(new Goal("43", "Cook a dish with turkey", "2.Single ingredient/dish", false));
        goals.add(new Goal("44", "Cook a dish with tofu", "2.Single ingredient/dish", false));
        goals.add(new Goal("45", "Cook a dish with sausages/meatballs", "2.Single ingredient/dish", false));
        goals.add(new Goal("46", "Cook a dish with nuts", "2.Single ingredient/dish", false));
        goals.add(new Goal("47", "Cook an Italian dish", "3.Cuisine", false));
        goals.add(new Goal("48", "Cook a French dish", "3.Cuisine", false));
        goals.add(new Goal("49", "Cook a German dish", "3.Cuisine", false));
        goals.add(new Goal("50", "Cook an American dish", "3.Cuisine", false));
        goals.add(new Goal("51", "Cook a Canadian dish", "3.Cuisine", false));
        goals.add(new Goal("52", "Cook a Chinese dish", "3.Cuisine", false));
        goals.add(new Goal("53", "Cook a Japanese dish", "3.Cuisine", false));
        goals.add(new Goal("54", "Cook a Lebanese dish", "3.Cuisine", false));
        goals.add(new Goal("55", "Cook a Greek dish", "3.Cuisine", false));
        goals.add(new Goal("56", "Cook an Indian dish", "3.Cuisine", false));
        goals.add(new Goal("57", "Cook a Vietnamese dish", "3.Cuisine", false));
        goals.add(new Goal("58", "Cook a Spanish dish", "3.Cuisine", false));
        goals.add(new Goal("59", "Cook a Mexican dish", "3.Cuisine", false));
        goals.add(new Goal("60", "Cook a Korean dish", "3.Cuisine", false));
        goals.add(new Goal("61", "Cook a Thai dish", "3.Cuisine", false));
        goals.add(new Goal("62", "Cook a Malaysian dish", "3.Cuisine", false));
        goals.add(new Goal("63", "Cook a Singaporean dish", "3.Cuisine", false));
        goals.add(new Goal("64", "Cook an Argentinian dish", "3.Cuisine", false));
        goals.add(new Goal("65", "Cook a Caribbean dish", "3.Cuisine", false));
        goals.add(new Goal("66", "Cook a Moroccan dish", "3.Cuisine", false));
        goals.add(new Goal("67", "Cook a Turkish dish", "3.Cuisine", false));
        goals.add(new Goal("68", "Cook a breakfast dish", "4.Time of day", false));
        goals.add(new Goal("69", "Cook a brunch dish", "4.Time of day", false));
        goals.add(new Goal("70", "Cook a lunch dish", "4.Time of day", false));
        goals.add(new Goal("71", "Cook a dinner dish", "4.Time of day", false));
        goals.add(new Goal("72", "Cook 2 days in a row", "4.Time of day", false));
        goals.add(new Goal("73", "Cook 3 days in a row", "4.Time of day", false));
        goals.add(new Goal("74", "Cook 4 days in a row", "4.Time of day", false));
        goals.add(new Goal("75", "Cook 5 days in a row", "4.Time of day", false));
        goals.add(new Goal("76", "Cook 6 days in a row", "4.Time of day", false));
        goals.add(new Goal("77", "Cook 7 days in a row", "4.Time of day", false));
        goals.add(new Goal("78", "Learn to make 3 different potato dishes", "5.Learn triple", false));
        goals.add(new Goal("79", "Learn to make 3 different salads", "5.Learn triple", false));
        goals.add(new Goal("80", "Learn to make 3 different egg dishes", "5.Learn triple", false));
        goals.add(new Goal("81", "Learn to make 3 different pasta dishes", "5.Learn triple", false));
        goals.add(new Goal("82", "Learn to make 3 different dips", "5.Learn triple", false));
        goals.add(new Goal("83", "Learn to make 3 different curries", "5.Learn triple", false));
        goals.add(new Goal("84", "Learn to make 3 different rice dishes", "5.Learn triple", false));
        goals.add(new Goal("85", "Learn to make 3 different noodle dishes", "5.Learn triple", false));
        goals.add(new Goal("86", "Learn to make 3 different chicken dishes", "5.Learn triple", false));
        goals.add(new Goal("87", "Learn to make 3 different pastry dishes", "5.Learn triple", false));
        goals.add(new Goal("88", "Learn to make 3 different fish or seafood dishes", "5.Learn triple", false));
        goals.add(new Goal("89", "Learn to make 3 different lamb dishes", "5.Learn triple", false));
        goals.add(new Goal("90", "Learn to make 3 different pork dishes", "5.Learn triple", false));
        goals.add(new Goal("91", "Learn to make 3 different beef dishes", "5.Learn triple", false));
        goals.add(new Goal("92", "Learn to make 3 different lentils dishes", "5.Learn triple", false));
        goals.add(new Goal("93", "Learn to make 3 different vegetarian dishes", "5.Learn triple", false));
        goals.add(new Goal("94", "Learn to make 3 different vegan dishes", "5.Learn triple", false));
        goals.add(new Goal("95", "Learn to make 3 different cheese dishes", "5.Learn triple", false));
        goals.add(new Goal("96", "Learn to make 3 different stir-fry dishes", "5.Learn triple", false));
        goals.add(new Goal("97", "Learn to make 3 different tofu dishes", "5.Learn triple", false));
        goals.add(new Goal("98", "Learn to make a dish with 3 different herbs", "5.Learn triple", false));
        goals.add(new Goal("99", "Learn to make a dish with 3 different spices", "5.Learn triple", false));
        goals.add(new Goal("100", "Learn to make 3 different soups", "5.Learn triple", false));
        return goals;
    }

}
