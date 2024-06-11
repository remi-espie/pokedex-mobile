package fr.dopolytech.mobidex.type

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun fromListOfTypes(value: List<ListOfTypes>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toListOfTypes(value: String): List<ListOfTypes> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromListOfAbilities(value: List<ListOfAbilities>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toListOfAbilities(value: String): List<ListOfAbilities> {
        return Json.decodeFromString(value)
    }


    @TypeConverter
    fun fromAbilityList(value: List<Ability>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toAbilityList(value: String): List<Ability> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromGameIndexList(value: List<GameIndex>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toGameIndexList(value: String): List<GameIndex> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromSpecies(value: Species): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toSpecies(value: String): Species {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromMoveList(value: List<Move>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toMoveList(value: String): List<Move> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromTypeList(value: List<Type>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toTypeList(value: String): List<Type> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromStatList(value: List<Stat>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toStatList(value: String): List<Stat> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromHeldItemList(value: List<HeldItem>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toHeldItemList(value: String): List<HeldItem> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromSprites(value: Sprites): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toSprites(value: String): Sprites {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromForms(value: List<Species>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toForms(value: String): List<Species> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromCries(value: Cries): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toCries(value: String): Cries {
        return Json.decodeFromString(value)
    }
}