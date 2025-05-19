package com.monkode.cattus.api.models

import android.net.Uri

data class GetAllCats(
    val ok: Boolean,
    val result: List<CatData>
)

data class GetOneCat(
    val ok: Boolean,
    val result: CatData
)

data class CatData(
    val _id: String? = null,
    val petName: String? = null,
    val petBirth: String? = null,
    val petGender: String? = null, // "Fêmea", "Macho"
    val petPicture: String? = null,
    val petObs: String? = null,
    val petCharacteristics: PetCharacteristics? = null,
    val physicalCharacteristics: PhysicalCharacteristics? = null,
    val behavioralCharacteristics: BehavioralCharacteristics? = null,
    val petComorbidities: String? = null,
    val company: Company? = null,
    val petStatus: PetStatus? = null,
    val petVaccines: List<String>? = emptyList()
)

data class PetCharacteristics(
    val petCastrated: String? = null, //"Sim", "Não"
    val petBreed: String? = null,
    val petSize: String? = null
)

data class PhysicalCharacteristics(
    val furColor: String? = null, // "preta" | "branca" | "cinza" | "laranja" | "marrom" | "mesclada"
    val furLength: String? = null, // "curto", "médio", "longo"
    val eyeColor: String? = null,  // "azul", "castanho", "verde"
    val size: Double? = null,
    val weight: Double? = null
)

data class BehavioralCharacteristics(
    val personality: String? = null,      // "amigável", "reservado", etc
    val activityLevel: String? = null,     // "ativo", "moderado", "calmo"
    val socialBehavior: String? = null,
    val meow: String? = null
)

data class PetStatus(
    val petCurrentStatus: String,
    val petOccurrencesQuantity: Int,
    val petLastOccurrence: String? = null
)

data class Company(
    val companyDetails: CompanyDetails,
    val id: String,
    val companyCNPJ: String,
    val companyName: String,
    val companyLogo: String,
    val v: Int
)

data class CompanyDetails(
    val companyColor: String,
    val companyPhone: Long?
)
