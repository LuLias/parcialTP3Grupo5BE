package com.example.parcialtp3grupo5be.providers

import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.OfferModel

class OffersProvider {
    companion object{
        val offersList = listOf<OfferModel>(
            OfferModel("Get 20% discount with your Master credit cards", "Use your mastercard with any transaction and get 20% discount instantly!",
                R.drawable.credit_card_1.toString()
            ),
            OfferModel("25% discount with your VISA credit or debit cards", "Use your VISA credit or debit card with any transaction and get 25% discount instantly!",
                R.drawable.credit_card_2.toString()
            )

        )
    }
}



