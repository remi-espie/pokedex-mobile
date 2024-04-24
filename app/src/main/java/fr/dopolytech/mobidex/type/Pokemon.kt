package fr.dopolytech.mobidex.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Serializable
@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey
    var id: Int = 0,
    var abilities: List<Ability> = listOf(),
    @SerialName("base_experience")
    var baseExperience: Int = 0,
    var cries: Cries = Cries(),
    var forms: List<Species> = listOf(),
    @SerialName("game_indices")
    var gameIndices: List<GameIndex> = listOf(),
    var height: Int = 0,
    @SerialName("held_items")
    var heldItems: List<HeldItem> = listOf(),
    @SerialName("is_default")
    var isDefault: Boolean = false,
    @SerialName("location_area_encounters")
    var locationAreaEncounters: String = "",
    var moves: List<Move> = listOf(),
    @SerialName("past_abilities")
    var pastAbilities: List<Ability> = listOf(),
    @SerialName("past_types")
    var pastTypes: List<Type> = listOf(),
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
    var ability: AbilityDetail = AbilityDetail(),
    var url: String = "",
    @SerialName("is_hidden")
    var isHidden: Boolean = false,
    var slot: Int = 0
)

@Serializable
data class AbilityDetail(
    var name: String = "",
    var url: String = ""
)

@Serializable
data class Cries(
    var latest: String = "",
    var legacy: String = ""
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
    @SerialName("version_group")
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
    var backFemale: String? = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("back_shiny_female")
    var backShinyFemale: String? = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = "",
    var other: Other = Other(),
    var versions: Versions = Versions()
)

@Serializable
data class Other(
    @SerialName("dream_world")
    var dreamWorld: DreamWorld = DreamWorld(),
    var home: Home = Home(),
    @SerialName("official-artwork")
    var officialArtwork: OfficialArtwork = OfficialArtwork(),
    var showdown: Showdown = Showdown()
)

@Serializable
data class DreamWorld(
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = ""
)

@Serializable
data class Home(
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = ""
)

@Serializable
data class OfficialArtwork(
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = ""
)

@Serializable
data class Showdown(
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = "",
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_female")
    var backFemale: String? = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("back_shiny_female")
    var backShinyFemale: String? = ""
)

@Serializable
data class Versions(
    @SerialName("generation-i")
    var generationI: GenerationI = GenerationI(),
    @SerialName("generation-ii")
    var generationII: GenerationII = GenerationII(),
    @SerialName("generation-iii")
    var generationIII: GenerationIII = GenerationIII(),
    @SerialName("generation-iv")
    var generationIV: GenerationIV = GenerationIV(),
    @SerialName("generation-v")
    var generationV: GenerationV = GenerationV(),
    @SerialName("generation-vi")
    var generationVI: GenerationVI = GenerationVI(),
    @SerialName("generation-vii")
    var generationVII: GenerationVII = GenerationVII(),
    @SerialName("generation-viii")
    var generationVIII: GenerationVIII = GenerationVIII()
)

@Serializable
data class GenerationI(
    @SerialName("red-blue")
    var redBlue: RedBlue = RedBlue(),
    var yellow: Yellow = Yellow()

)

@Serializable
data class RedBlue(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_gray")
    var backGray: String = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_gray")
    var frontGray: String = "",
    @SerialName("front_transparent")
    var frontTransparent: String = "",
    @SerialName("back_transparent")
    var backTransparent: String = ""
)

@Serializable
data class Yellow(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_gray")
    var backGray: String = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_gray")
    var frontGray: String = "",
    @SerialName("front_transparent")
    var frontTransparent: String = "",
    @SerialName("back_transparent")
    var backTransparent: String = ""
)

@Serializable
data class GenerationII(
    @SerialName("crystal")
    var crystal: Crystal = Crystal(),
    @SerialName("gold")
    var gold: Gold = Gold(),
    @SerialName("silver")
    var silver: Silver = Silver()
)

@Serializable
data class Crystal(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_transparent")
    var frontShinyTransparent: String = "",
    @SerialName("back_shiny_transparent")
    var backShinyTransparent: String = "",
    @SerialName("front_transparent")
    var frontTransparent: String = "",
    @SerialName("back_transparent")
    var backTransparent: String = ""
)

@Serializable
data class Gold(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_transparent")
    var frontTransparent: String = "",
)

@Serializable
data class Silver(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_transparent")
    var frontTransparent: String = "",
)

@Serializable
data class GenerationIII(
    @SerialName("emerald")
    var emerald: Emerald = Emerald(),
    @SerialName("firered-leafgreen")
    var fireRedLeafGreen: FireRedLeafGreen = FireRedLeafGreen(),
    @SerialName("ruby-sapphire")
    var rubySapphire: RubySapphire = RubySapphire()
)

@Serializable
data class Emerald(
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = ""
)

@Serializable
data class FireRedLeafGreen(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = ""
)

@Serializable
data class RubySapphire(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = ""
)

@Serializable
data class GenerationIV(
    @SerialName("diamond-pearl")
    var diamondPearl: DiamondPearl = DiamondPearl(),
    @SerialName("heartgold-soulsilver")
    var heartGoldSoulSilver: HeartGoldSoulSilver = HeartGoldSoulSilver(),
    @SerialName("platinum")
    var platinum: Platinum = Platinum()
)

@Serializable
data class DiamondPearl(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_female")
    var backFemale: String? = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("back_shiny_female")
    var backShinyFemale: String? = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = ""
)

@Serializable
data class HeartGoldSoulSilver(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_female")
    var backFemale: String? = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("back_shiny_female")
    var backShinyFemale: String? = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = ""
)

@Serializable
data class Platinum(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_female")
    var backFemale: String? = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("back_shiny_female")
    var backShinyFemale: String? = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = ""
)

@Serializable
data class GenerationV(
    @SerialName("black-white")
    var blackWhite: BlackWhite = BlackWhite()
)

@Serializable
data class BlackWhite(
    @SerialName("animated")
    var animated: Animated = Animated(),
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_female")
    var backFemale: String? = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("back_shiny_female")
    var backShinyFemale: String? = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = ""
)

@Serializable
data class Animated(
    @SerialName("back_default")
    var backDefault: String = "",
    @SerialName("back_female")
    var backFemale: String? = "",
    @SerialName("back_shiny")
    var backShiny: String = "",
    @SerialName("back_shiny_female")
    var backShinyFemale: String? = "",
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = ""
)

@Serializable
data class GenerationVI(
    @SerialName("omegaruby-alphasapphire")
    var omegaRubyAlphaSapphire: OmegaRubyAlphaSapphire = OmegaRubyAlphaSapphire(),
    @SerialName("x-y")
    var xy: XY = XY()
)

@Serializable
data class OmegaRubyAlphaSapphire(
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = ""
)

@Serializable
data class XY(
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = ""
)

@Serializable
data class GenerationVII(
    @SerialName("icons")
    var icons: Icons = Icons(),
    @SerialName("ultra-sun-ultra-moon")
    var ultraSunUltraMoon: UltraSunUltraMoon = UltraSunUltraMoon()
)

@Serializable
data class Icons(
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
)

@Serializable
data class UltraSunUltraMoon(
    @SerialName("front_default")
    var frontDefault: String = "",
    @SerialName("front_shiny")
    var frontShiny: String = "",
    @SerialName("front_female")
    var frontFemale: String? = "",
    @SerialName("front_shiny_female")
    var frontShinyFemale: String? = ""
)

@Serializable
data class GenerationVIII(
    @SerialName("icons")
    var icons: Icons = Icons()
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
