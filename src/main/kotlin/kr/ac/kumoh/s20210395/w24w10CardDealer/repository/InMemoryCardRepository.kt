package kr.ac.kumoh.s20210395.w24w10CardDealer.repository

import kr.ac.kumoh.s20210395.w24w10CardDealer.model.Card
import org.springframework.stereotype.Repository

@Repository
class InMemoryCardRepository :CardRepository { //인터페이스 내용 임플리먼트(implement, 구현)
    private val cards: MutableList<Card> = mutableListOf() //가변형 리스트

    override val size: Int
        get() = cards.size

    override fun add(card: Card) {
        cards.add(card)
    }

    override fun getAllCards(): List<Card> {
        return cards
    }

    override fun clear() {
        cards.clear()
    }

}