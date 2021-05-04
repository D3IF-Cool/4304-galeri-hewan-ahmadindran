package org.d3if4077.galerihewan.model

import org.d3if4077.galerihewan.R

data class Hewan(
    val nama: String,
    val namaLatin: String,
    val imageId: String
)

enum class ApiStatus {LOADING, SUCCESS, FAILED}