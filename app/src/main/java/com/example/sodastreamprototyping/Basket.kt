package com.example.sodastreamprototyping

class Basket {
    companion object{
        val basketDrinks : ArrayList<Drink> = arrayListOf()
        var orderNumber = 0;
        val history = ArrayList<Pair<Int, Boolean>>()
        private var lastDrinkID: Int = 0

        fun saveDrink(drink: Drink){
            val oldDrink = getDrinks().indexOfFirst { it.drinkID == drink.drinkID }
            if(oldDrink == -1){
                addDrink(drink)
                return
            }
            basketDrinks[oldDrink] = drink
        }

        fun addDrink(drink: Drink){
            drink.drinkID = ++lastDrinkID
            basketDrinks.add(drink)
        }

        fun getDrinks(): ArrayList<Drink>{
            return basketDrinks
        }

        fun clearBasket() {
            basketDrinks.clear()
            lastDrinkID = 0 // Reset the ID counter if needed
        }

        fun addOrder(){
            history.add(Pair(orderNumber, false))
            orderNumber++;
        }
    }
}