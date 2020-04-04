package com.dada.mobile_thaidass.utility.game.quiz_game

import com.dada.mobile_thaidass.R

class QuizGamePresenter {
    var setData: ArrayList<ModelQuiz> = arrayListOf(
        ModelQuiz(1, R.drawable.b7),
        ModelQuiz(2, R.drawable.b9),
        ModelQuiz(3, R.drawable.g4),
        ModelQuiz(4, R.drawable.g8),
        ModelQuiz(5, R.drawable.b5),
        ModelQuiz(6, R.drawable.g6),
        ModelQuiz(7, R.drawable.g91),
        ModelQuiz(8, R.drawable.g95),
        ModelQuiz(9, R.drawable.g93),
        ModelQuiz(10, R.drawable.b1)
    )

    var quiz: List<Quiz> = arrayListOf(
        Quiz("ข้อที่ 1 ภาพใดคือการแต่งกายของผู้ชายในสมัยรัชกาลที่ 1-3",10,R.drawable.db1),
        Quiz("ข้อที่ 2 ภาพใดคือการแต่งกายของผู้หญิงในสมัยรัชกาลที่ 4",3,R.drawable.dg4),
        Quiz("ข้อที่ 3 ภาพใดคือการแต่งกายของผู้ชายในสมัยรัชกาลที่ 5",5,R.drawable.db5),
        Quiz("ข้อที่ 4 ภาพใดคือการแต่งกายของผู้หญิงในสมัยรัชกาลที่ 6",6,R.drawable.dg6),
        Quiz("ข้อที่ 5 ภาพใดคือการแต่งกายของผู้ชายในสมัยรัชกาลที่ 7",1,R.drawable.db7),
        Quiz("ข้อที่ 6 ภาพใดคือการแต่งกายของผูหญิงในสมัยรัชกาลที่ 8",4,R.drawable.dg8),
        Quiz("ข้อที่ 7 ภาพใดคือการแต่งกายชุดไทยจิตรลดา",7,R.drawable.dg91),
        Quiz("ข้อที่ 8 ภาพใดคือการแต่งกายของชุดไทยอมรินทร์",9,R.drawable.dg93),
        Quiz("ข้อที่ 9 ภาพใดคือการแต่งกายของชุดไทยศิวาลัย",8,R.drawable.dg95),
        Quiz("ข้อที่ 10 ภาพใดคือการแต่งของกายผู้ชายในสมัยรัชกาลที่ 9",2,R.drawable.db9)
    )
}

data class ModelQuiz(
    val id: Int,
    val icon: Int
)

data class Quiz(
    val title: String,
    val id: Int,
    val show: Int
)