package kr.ac.kumoh.s20210395.w24w10CardDealer.controller

import org.springframework.ui.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CardController {
    @GetMapping("/cards/random")
    fun getRandomCards(model: Model): String {
        model.addAttribute("cards","ace_of_spades.png")
//        model.addAttribute("suit","spades")
//        model.addAttribute("rank","ace")
        return "cards"
    }
}

