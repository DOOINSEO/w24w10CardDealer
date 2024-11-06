package kr.ac.kumoh.s20210395.w24w10CardDealer.service

import kr.ac.kumoh.s20210395.w24w10CardDealer.model.Card
import kr.ac.kumoh.s20210395.w24w10CardDealer.repository.CardRepository
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class CardService(private val repository : CardRepository) {
    companion object { //객체를 만들고 쓸 수 있는 companion object
        const val NUMBER_OF_CARDS = 5
    }
    fun getAllCards() : List<Card> {
        return repository.getAllCards()
    }
    fun dealCards(count: Int = NUMBER_OF_CARDS) {
        val suits = arrayOf("spades",
            "diamonds",
            "hearts",
            "clubs",
            )
        val ranks = arrayOf(
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "jack", "queen", "kink", "ace"
        )

        repository.clear()

        val uniqueCards = mutableSetOf<Card>()
        while(uniqueCards.size < count) {
            val randomSuit = suits[Random.nextInt(suits.size)]
            val randomRank = ranks[Random.nextInt(ranks.size)]

            uniqueCards.add(Card(randomRank, randomSuit))
        }

        val sortedCards = uniqueCards.toList()
            .sortedWith(compareBy(
                {suits.indexOf(it.suit)},
                {ranks.indexOf(it.rank)}
                )
            )
        sortedCards.forEach {repository.add(it)}
    }
}