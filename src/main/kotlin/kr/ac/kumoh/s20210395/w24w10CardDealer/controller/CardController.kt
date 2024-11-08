package kr.ac.kumoh.s20210395.w24w10CardDealer.controller

import kr.ac.kumoh.s20210395.w24w10CardDealer.service.CardService
import org.springframework.ui.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CardController(private val service: CardService) {
    @GetMapping("/cards/random")
    fun getRandomCards(model: Model): String {
        service.dealCards()

        val cards = service.getAllCards()

        model.addAttribute(
            "cards",
            cards.map{it.imageName}
        )
//        model.addAttribute("suit","spades")
//        model.addAttribute("rank","ace")
        return "cards"
    }
}

