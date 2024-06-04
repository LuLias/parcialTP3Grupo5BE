package com.example.parcialtp3grupo5be.entities

data class OfferModel(
    // atributos para la card grande
    var title: String,
    var description: String,
    var card_image: String,

    // atributos para el preview
    var previewTitle: String,
    var offerType: String,

)
