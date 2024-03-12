package com.compose.cryptocurrency.data


import com.compose.cryptocurrency.domain.model.HeartRate
import com.compose.cryptocurrency.domain.model.PAI
import java.util.Calendar

fun getHeartRateData():List<HeartRate>{
    return MutableList(20){
        HeartRate(
            value = (1..5).random(),
            type = listOf(
                HeartRate.Type.Awake,
                HeartRate.Type.Rem,
                HeartRate.Type.Light,
                HeartRate.Type.Damp
            ).random()
        )
    }
}
fun getHeartRateTime():Pair<Long,Long>{
    return Calendar.getInstance()
        .apply {
            set(Calendar.MONTH,2)
            set(Calendar.DAY_OF_MONTH,28)
            set(Calendar.HOUR_OF_DAY,12)
            set(Calendar.MINUTE,29)
        }.timeInMillis to Calendar.getInstance().apply {
        set(Calendar.MONTH,2)
        set(Calendar.DAY_OF_MONTH,28)
        set(Calendar.HOUR_OF_DAY,2)
        set(Calendar.MINUTE,47)
    }.timeInMillis
}


fun getChartData(count:Int? = null): List<Float> {
    return MutableList(count ?:(5..10).random()){
        listOf(0f,50f,100f,150f,200f,250f,300f,350f,400f,450f,500f,550f,600f,650f,700f,750f,800f,850f,900f).random()
    }+ mutableListOf(0f)
}


fun getPAIValues():List<PAI>{
    val calendar = Calendar.getInstance()

    return MutableList(30){
        calendar.add(Calendar.DAY_OF_YEAR,1)
        PAI(
            id = it,
            selected = it == 0,
            date = calendar.timeInMillis,
            value = (1..100).random().toFloat()
        )
    }
}