package fr.dopolytech.mobidex.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpecy(
    @SerialName("base_happiness")
    var baseHappiness: Int? = null,
    @SerialName("capture_rate")
    var captureRate: Int? = null,
    var color: Color? = Color(),
    @SerialName("egg_groups")
    var eggGroups: List<EggGroups> = listOf(),
    @SerialName("evolution_chain")
    var evolutionChain: EvolutionChain? = EvolutionChain(),
    @SerialName("evolves_from_species")
    var evolvesFromSpecies: String? = null,
    @SerialName("flavor_text_entries")
    var flavorTextEntries: List<FlavorTextEntries> = listOf(),
    @SerialName("form_descriptions")
    var formDescriptions: List<String> = listOf(),
    @SerialName("forms_switchable")
    var formsSwitchable: Boolean? = null,
    @SerialName("gender_rate")
    var genderRate: Int? = null,
    var genera: List<Genera> = listOf(),
    var generation: Generation? = Generation(),
    @SerialName("growth_rate")
    var growthRate: GrowthRate? = GrowthRate(),
    var habitat: Habitat? = Habitat(),
    @SerialName("has_gender_differences")
    var hasGenderDifferences: Boolean? = null,
    @SerialName("hatch_counter")
    var hatchCounter: Int? = null,
    var id: Int? = null,
    @SerialName("is_baby")
    var isBaby: Boolean? = null,
    @SerialName("is_legendary")
    var isLegendary: Boolean? = null,
    @SerialName("is_mythical")
    var isMythical: Boolean? = null,
    var name: String? = null,
    var names: List<Names> = listOf(),
    var order: Int? = null,
    @SerialName("pal_park_encounters")
    var palParkEncounters: List<PalParkEncounters> = listOf(),
    @SerialName("pokedex_numbers")
    var pokedexNumbers: List<PokedexNumbers> = listOf(),
    var shape: Shape? = Shape(),
    var varieties: List<Varieties> = listOf()
)

@Serializable
data class Color(
    var name: String? = null,
    var url: String? = null
)

@Serializable
data class EggGroups(
    var name: String? = null,
    var url: String? = null
)

@Serializable
data class EvolutionChain(
    var url: String? = null
)

@Serializable
data class FlavorTextEntries(
    @SerialName("flavor_text")
    var flavorText: String? = null,
    var language: Language? = Language(),
    var version: Version? = Version()
)

@Serializable
data class Genera(
    var genus: String? = null,
    var language: Language? = Language()
)

@Serializable
data class GrowthRate(
    var name: String? = null,
    var url: String? = null
)

@Serializable
data class Habitat(
    var name: String? = null,
    var url: String? = null
)

@Serializable
data class Language(
    var name: String? = null,
    var url: String? = null
)

@Serializable
data class Names(
    var language: Language? = Language(),
    var name: String? = null
)

@Serializable
data class Area(
    var name: String? = null,
    var url: String? = null
)

@Serializable
data class PalParkEncounters(
    var area: Area? = Area(),
    @SerialName("base_score")
    var baseScore: Int? = null,
    var rate: Int? = null
)

@Serializable
data class Pokedex(
    var name: String? = null,
    var url: String? = null
)

@Serializable
data class PokedexNumbers(
    @SerialName("entry_number")
    var entryNumber: Int? = null,
    var pokedex: Pokedex? = Pokedex()
)

@Serializable
data class Shape(
    var name: String? = null,
    var url: String? = null
)

@Serializable
data class Varieties(
    @SerialName("is_default") var isDefault: Boolean? = null,
    var pokemon: SimplifiedPokemon? = SimplifiedPokemon()
)

@Serializable
data class SimplifiedPokemon(
    var name: String? = null,
    var url: String? = null
)