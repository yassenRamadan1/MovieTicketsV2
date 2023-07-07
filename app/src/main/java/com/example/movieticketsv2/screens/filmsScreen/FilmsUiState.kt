package com.example.movieTicket.screens.filmsScreen


data class FilmsUiState(
    val filmsPhotos: List<String> = listOf(
        "https://images.ctfassets.net/usf1vwtuqyxm/1soIBawzwa52bYit498iYy/8b67c35d5116f96c187e8ba27f4cc264/fb3-poster-jude-law-full.jpg?w=914&q=70&fm=webp",
        "https://cdn.shopify.com/s/files/1/0057/3728/3618/files/blue-beetle_hyapde37_480x.progressive.jpg?v=1688499635",
        "https://cdn.shopify.com/s/files/1/0057/3728/3618/files/paw_patrol_the_mighty_movie_480x.progressive.jpg?v=1687887289",
    ),
val time: String = "2h 23m",
val title: String = "Fantastic Beasts: The \nSecrets of Dumbledore",
val genres: List<String> = listOf(
    "Fantasy",
    "Adventure",
),
)
