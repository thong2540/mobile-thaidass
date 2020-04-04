package com.dada.mobile_thaidass.utility.game.choosing_dress

import com.dada.mobile_thaidass.R

class ChoosingDressPresenter {

    var shirtBoy: ArrayList<ModelChoosing> = arrayListOf(
        ModelChoosing(1, R.drawable.sbb1, R.drawable.sb1),
        ModelChoosing(2, R.drawable.sbb2, R.drawable.sb2),
        ModelChoosing(3, R.drawable.sbb3, R.drawable.sb3),
        ModelChoosing(4, R.drawable.sbb4, R.drawable.sb4),
        ModelChoosing(5, R.drawable.sbb5, R.drawable.sb5)
    )

    var pantsBoy: ArrayList<ModelChoosing> = arrayListOf(
        ModelChoosing(1, R.drawable.btbb1, R.drawable.btb1),
        ModelChoosing(2, R.drawable.btbb2, R.drawable.btb2),
        ModelChoosing(3, R.drawable.btbb3, R.drawable.btb3),
        ModelChoosing(4, R.drawable.btbb4, R.drawable.btb4),
        ModelChoosing(5, R.drawable.btbb5, R.drawable.btb5)
    )

    var shirtFemale: ArrayList<ModelChoosing> = arrayListOf(
        ModelChoosing(1, R.drawable.sgg1, R.drawable.sg1),
        ModelChoosing(2, R.drawable.sgg2, R.drawable.sg2),
        ModelChoosing(3, R.drawable.sgg3, R.drawable.sg3),
        ModelChoosing(4, R.drawable.sgg4, R.drawable.sg4),
        ModelChoosing(5, R.drawable.sgg5, R.drawable.sg5)
    )

    var pantsFemale: ArrayList<ModelChoosing> = arrayListOf(
        ModelChoosing(1, R.drawable.btgg1, R.drawable.btg1),
        ModelChoosing(2, R.drawable.btgg2, R.drawable.btg2),
        ModelChoosing(3, R.drawable.btgg3, R.drawable.btg3),
        ModelChoosing(4, R.drawable.btgg4, R.drawable.btg4),
        ModelChoosing(5, R.drawable.btgg5, R.drawable.btg5)
    )

    var quizBoy: ArrayList<ModelQuizChoosing> = arrayListOf(
        ModelQuizChoosing(R.drawable.bbb1,3,2),
        ModelQuizChoosing(R.drawable.bbb2,3,1),
        ModelQuizChoosing(R.drawable.bbb3,3,4),
        ModelQuizChoosing(R.drawable.bbb4,3,5),
        ModelQuizChoosing(R.drawable.bbb5,2,3),
        ModelQuizChoosing(R.drawable.bbb6,2,1),
        ModelQuizChoosing(R.drawable.bbb7,2,4),
        ModelQuizChoosing(R.drawable.bbb8,2,5),
        ModelQuizChoosing(R.drawable.bbb9,1,3),
        ModelQuizChoosing(R.drawable.bbb10,1,2),
        ModelQuizChoosing(R.drawable.bbb11,1,4),
        ModelQuizChoosing(R.drawable.bbb12,1,5),
        ModelQuizChoosing(R.drawable.bbb13,4,3),
        ModelQuizChoosing(R.drawable.bbb14,4,2),
        ModelQuizChoosing(R.drawable.bbb15,4,1),
        ModelQuizChoosing(R.drawable.bbb16,4,5),
        ModelQuizChoosing(R.drawable.bbb17,5,3),
        ModelQuizChoosing(R.drawable.bbb18,5,2),
        ModelQuizChoosing(R.drawable.bbb19,5,1),
        ModelQuizChoosing(R.drawable.bbb20,5,4),
        ModelQuizChoosing(R.drawable.bbb21,3,3),
        ModelQuizChoosing(R.drawable.bbb22,2,2),
        ModelQuizChoosing(R.drawable.bbb23,1,1),
        ModelQuizChoosing(R.drawable.bbb24,4,4),
        ModelQuizChoosing(R.drawable.bbb25,5,5)
    )

    var quizFemale: ArrayList<ModelQuizChoosing> = arrayListOf(
        ModelQuizChoosing(R.drawable.ggg1,1,2),
        ModelQuizChoosing(R.drawable.ggg2,1,3),
        ModelQuizChoosing(R.drawable.ggg3,1,4),
        ModelQuizChoosing(R.drawable.ggg4,1,5),
        ModelQuizChoosing(R.drawable.ggg6,2,1),
        ModelQuizChoosing(R.drawable.ggg7,2,3),
        ModelQuizChoosing(R.drawable.ggg8,2,4),
        ModelQuizChoosing(R.drawable.ggg9,2,5),
        ModelQuizChoosing(R.drawable.ggg10,3,1),
        ModelQuizChoosing(R.drawable.ggg11,3,2),
        ModelQuizChoosing(R.drawable.ggg12,3,4),
        ModelQuizChoosing(R.drawable.ggg13,5,5),
        ModelQuizChoosing(R.drawable.ggg14,5,1),
        ModelQuizChoosing(R.drawable.ggg15,5,2),
        ModelQuizChoosing(R.drawable.ggg16,5,3),
        ModelQuizChoosing(R.drawable.ggg17,5,4),
        ModelQuizChoosing(R.drawable.ggg18,1,1),
        ModelQuizChoosing(R.drawable.ggg19,2,2),
        ModelQuizChoosing(R.drawable.ggg20,3,3),
        ModelQuizChoosing(R.drawable.ggg21,4,4),
        ModelQuizChoosing(R.drawable.ggg22,5,5)
    )
}

data class ModelChoosing(
    val id: Int,
    val dress: Int,
    val dressSelect: Int
)

data class ModelQuizChoosing(
    val show: Int,
    val shirtId: Int,
    val pantsId: Int
)