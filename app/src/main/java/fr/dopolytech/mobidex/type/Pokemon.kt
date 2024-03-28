package fr.dopolytech.mobidex.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    var abilities: List<Ability> = listOf(),
    @SerialName("base_experience")
    var baseExperience: Int = 0,
    var forms: List<Species> = listOf(),
    @SerialName("game_indices")
    var gameIndices: List<GameIndex> = listOf(),
    var height: Int = 0,
    @SerialName("held_items")
    var heldItems: List<HeldItem> = listOf(),
    var id: Int = 0,
    @SerialName("is_default")
    var isDefault: Boolean = false,
    @SerialName("location_area_encounters")
    var locationAreaEncounters: String = "",
    var moves: List<Move> = listOf(),
    var name: String = "",
    var order: Int = 0,
    var species: Species = Species(),
    var sprites: Sprites = Sprites(),
    var stats: List<Stat> = listOf(),
    var types: List<Type> = listOf(),
    var weight: Int = 0
)

@Serializable
data class Ability(
    var name: String = "",
    var url: String = "",
    @SerialName("is_hidden")
    var isHidden: Boolean = false,
    var slot: Int = 0
)

@Serializable
data class Species(
    var name: String = "",
    var url: String = ""
)

@Serializable
data class GameIndex(
    @SerialName("game_index")
    var gameIndex: Int = 0,
    var version: Version = Version()
)

@Serializable
data class Version(
    var name: String = "",
    var url: String = ""
)

@Serializable
data class HeldItem(
    var item: Item = Item(),
    @SerialName("version_details")
    var versionDetails: List<VersionDetail> = listOf()
)

@Serializable
data class Item(
    var name: String = "",
    var url: String = ""
)

@Serializable
data class VersionDetail(
    var rarity: Int = 0,
    var version: Version = Version()
)

@Serializable
data class Move(
    var move: MoveDetail = MoveDetail(),
    @SerialName("version_group_details")
    var versionGroupDetails: List<VersionGroupDetail> = listOf()
)

@Serializable
data class MoveDetail(
    var name: String = "",
    var url: String = ""
)

@Serializable
data class VersionGroupDetail(
    @SerialName("level_learned_at")
    var levelLearnedAt: Int = 0,
    @SerialName("move_learn_method")
    var moveLearnMethod: MoveLearnMethod = MoveLearnMethod(),
    var versionGroup: VersionGroup = VersionGroup()
)

@Serializable
data class MoveLearnMethod(
    var name: String = "",
    var url: String = ""
)

@Serializable
data class VersionGroup(
    var name: String = "",
    var url: String = ""
)

@Serializable
data class Sprites(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_female")
    var backFemale: String = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("back_shiny_femame")
    var backShinyFemale: String = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String = ""
)

@Serializable
data class Stat(
    @SerialName("base_stat")
    var baseStat: Int = 0,
    var effort: Int = 0,
    var stat: StatDetail = StatDetail()
)

@Serializable
data class StatDetail(
    var name: String = "",
    var url: String = ""
)

@Serializable
data class Type(
    var slot: Int = 0,
    var type: TypeDetail = TypeDetail()
)

@Serializable
data class TypeDetail(
    var name: String = "",
    var url: String = ""
)
