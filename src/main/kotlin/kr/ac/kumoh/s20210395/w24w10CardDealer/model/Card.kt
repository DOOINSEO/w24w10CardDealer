package kr.ac.kumoh.s20210395.w24w10CardDealer.model

data class Card(
    val rank: String,
    val suit: String
){
    val imageName: String
        get() = "${rank}_of_${suit}.png" // 이건 return()과 같은 역할
}
