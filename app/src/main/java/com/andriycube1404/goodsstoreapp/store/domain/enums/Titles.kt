package com.andriycube1404.goodsstoreapp.store.domain.enums

import com.andriycube1404.goodsstoreapp.store.domain.model.Title

enum class Titles(val title: Title) {
    Design(
        Title(
            title = "Design",
            description = "Grab blocks of colors and create whatever you can imagine!"
        )
    ),
    Story(
        Title(
            title = "Story",
            description = "Create your own story of choose among " +
                    "the already told stories from PIXIO blocks"
        )
    )
}