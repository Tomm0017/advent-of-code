package com.tomm.advent2020.day4

import com.tomm.PuzzleStep

val Day4 = Step1() + Step2()

private const val BIRTH_YEAR = "byr"
private const val ISSUE_YEAR = "iyr"
private const val EXPIRE_YEAR = "eyr"
private const val HEIGHT = "hgt"
private const val HAIR_COLOR = "hcl"
private const val EYE_COLOR = "ecl"
private const val PASSPORT_ID = "pid"

private const val CENTIMETERS = "cm"
private const val INCHES = "in"

private val requiredFields = listOf(
    EYE_COLOR,
    PASSPORT_ID,
    EXPIRE_YEAR,
    HAIR_COLOR,
    BIRTH_YEAR,
    ISSUE_YEAR,
    HEIGHT
)

private class Step1 : PuzzleStep<List<Passport>> {

    override fun solve(input: List<Passport>): String {
        val valid = input.count { it.hasRequiredFields() }
        return valid.toString()
    }
}

private class Step2 : PuzzleStep<List<Passport>> {

    override fun solve(input: List<Passport>): String {
        val count = input.count { it.hasRequiredFields() && it.isValid() }
        return count.toString()
    }

    private fun Passport.isValid(): Boolean {
        val ranges = validRanges.all { inValidRange(it.first, it.second) }
        val height = hasValidHeight(HEIGHT)
        val hairColor = hasValidRegex(HAIR_COLOR, hairColourRegex)
        val eyeColor = hasValidEyeColor(EYE_COLOR)
        val passportId = hasValidRegex(PASSPORT_ID, passportIdRegex)
        return ranges && height && hairColor && eyeColor && passportId
    }

    private fun Passport.inValidRange(key: String, range: IntRange): Boolean {
        val value = properties.getValue(key).toIntOrNull()
        return value in range
    }

    private fun Passport.hasValidHeight(key: String): Boolean {
        val value = properties.getValue(key)
        if (value.contains(CENTIMETERS)) {
            val length = value.removeSuffix(CENTIMETERS).toIntOrNull()
            return length in VALID_CM_RANGE
        } else if (value.contains(INCHES)) {
            val length = value.removeSuffix(INCHES).toIntOrNull()
            return length in VALID_IN_RANGE
        }
        return false
    }

    private fun Passport.hasValidEyeColor(key: String): Boolean {
        val value = properties.getValue(key).toLowerCase()
        return value in validEyeColors
    }

    private fun Passport.hasValidRegex(key: String, regex: Regex): Boolean {
        val value = properties.getValue(key)
        return regex.matches(value)
    }

    companion object {

        private val validRanges = arrayOf(
            BIRTH_YEAR to 1920..2002,
            ISSUE_YEAR to 2010..2020,
            EXPIRE_YEAR to 2020..2030
        )

        private val validEyeColors = arrayOf(
            "amb",
            "blu",
            "brn",
            "gry",
            "grn",
            "hzl",
            "oth"
        )

        private val VALID_CM_RANGE = 150..193
        private val VALID_IN_RANGE = 59..76

        private val hairColourRegex = Regex("^#[a-f0-9]{6}\$")
        private val passportIdRegex = Regex("^\\d{9}\$")
    }
}

private fun Passport.hasRequiredFields(): Boolean {
    return properties.keys.containsAll(requiredFields)
}
