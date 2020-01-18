package com.example.cookbookapp.api.dto

/**
 * Created by Richard Gross on 2020-01-15
 */
data class RecipeDto(
    var name: String? = null,
    var duration: Int? = null,
    var id: String? = null,
    var score: Int? = null
)