package fr.dopolytech.mobidex.type

data class Pokemon(
    var abilities: List<Ability> = listOf(),
    var baseExperience: Int = 0,
    var forms: List<Species> = listOf(),
    var gameIndices: List<GameIndex> = listOf(),
    var height: Int = 0,
    var heldItems: List<HeldItem> = listOf(),
    var id: Int = 0,
    var isDefault: Boolean = false,
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

data class Ability(
    var name: String = "",
    var url: String = "",
    var isHidden: Boolean = false,
    var slot: Int = 0
)

data class Species(
    var name: String = "",
    var url: String = ""
)

data class GameIndex(
    var gameIndex: Int = 0,
    var version: Version = Version()
)

data class Version(
    var name: String = "",
    var url: String = ""
)

data class HeldItem(
    var item: Item = Item(),
    var versionDetails: List<VersionDetail> = listOf()
)

data class Item(
    var name: String = "",
    var url: String = ""
)

data class VersionDetail(
    var rarity: Int = 0,
    var version: Version = Version()
)

data class Move(
    var move: MoveDetail = MoveDetail(),
    var versionGroupDetails: List<VersionGroupDetail> = listOf()
)

data class MoveDetail(
    var name: String = "",
    var url: String = ""
)

data class VersionGroupDetail(
    var levelLearnedAt: Int = 0,
    var moveLearnMethod: MoveLearnMethod = MoveLearnMethod(),
    var versionGroup: VersionGroup = VersionGroup()
)

data class MoveLearnMethod(
    var name: String = "",
    var url: String = ""
)

data class VersionGroup(
    var name: String = "",
    var url: String = ""
)

data class Sprites(
    var backDefault: String = "",
    var backFemale: String = "",
    var backShiny: String = "",
    var backShinyFemale: String = "",
    var frontDefault: String = "",
    var frontFemale: String = "",
    var frontShiny: String = "",
    var frontShinyFemale: String = ""
)

data class Stat(
    var baseStat: Int = 0,
    var effort: Int = 0,
    var stat: StatDetail = StatDetail()
)

data class StatDetail(
    var name: String = "",
    var url: String = ""
)

data class Type(
    var slot: Int = 0,
    var type: TypeDetail = TypeDetail()
)

data class TypeDetail(
    var name: String = "",
    var url: String = ""
)
