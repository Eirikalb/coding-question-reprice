import java.io.File

/**
 * Finds all anagrams in a word list.
 * 
 * An anagram is a word formed by rearranging the letters of another word.
 * This program reads a word list and groups together all words that are
 * anagrams of each other.
 */
fun main(args: Array<String>) {
    val fileName = args.firstOrNull() ?: "eventyr.txt"
    val file = File(fileName)
    
    if (!file.exists()) {
        println("Error: File '$fileName' not found")
        return
    }
    
    val anagramGroups = findAnagrams(file.readLines())
    
    anagramGroups.forEach { group ->
        println(group.joinToString(" "))
    }
}

/**
 * Finds all groups of anagrams in the given list of words.
 * 
 * @param words List of words to search for anagrams
 * @return List of anagram groups, where each group contains 2 or more words
 *         that are anagrams of each other
 * Notes: Behavior for empty list or list with single word is ambiguously defined.
 *        The current implementation returns an empty list in these cases.
 */
fun findAnagrams(words: List<String>): List<List<String>> {
    return words
        .filter { it.isNotBlank() }
        .map { it.trim().lowercase() }
        .distinct()
        .groupBy { it.toSortedKey() }
        .values
        .filter { it.size > 1 }
        .sortedBy { it.first() }
}

/**
 * Creates a canonical key for anagram comparison by sorting the characters.
 * Words that are anagrams of each other will have the same sorted key.
 */
private fun String.toSortedKey(): String = this.toCharArray().sorted().joinToString("")

