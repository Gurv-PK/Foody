package com.example.foody

class DataSource {

    companion object{

        fun createdata(): ArrayList<FoodItems>{

            val itemlist = ArrayList<FoodItems>()
            itemlist.add(FoodItems("Paneer Butter Masala","A dish containing paneer and punjabi masala mainly not so spicy dish ",R.drawable.f1))
            itemlist.add(FoodItems("South Indian Cuisine","A cuisine coming from southeren part of India comprising of each type of food ",R.drawable.f2))
            itemlist.add(FoodItems("Noodles","A Chinese dish that has hold his position firm in fast food category ",R.drawable.f3))


            return itemlist
        }


    }
}