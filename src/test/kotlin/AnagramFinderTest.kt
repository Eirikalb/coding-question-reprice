import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AnagramFinderTest {
    
    @Test
    fun `finds simple anagram pair`() {
        val words = listOf("akte", "teak")
        val result = findAnagrams(words)
        
        assertEquals(1, result.size)
        assertTrue(result[0].containsAll(listOf("akte", "teak")))
    }
    
    @Test
    fun `finds multiple anagram groups`() {
        val words = listOf("akte", "teak", "kate", "alt", "tal")
        val result = findAnagrams(words)
        
        assertEquals(2, result.size)
    }
    
    @Test
    fun `excludes words without anagrams`() {
        val words = listOf("hello", "world", "akte", "teak")
        val result = findAnagrams(words)
        
        assertEquals(1, result.size)
        assertTrue(result[0].containsAll(listOf("akte", "teak")))
    }
    
    @Test
    fun `handles empty list`() {
        val result = findAnagrams(emptyList())
        assertTrue(result.isEmpty())
    }
    
    @Test
    fun `handles single word`() {
        val result = findAnagrams(listOf("hello"))
        assertTrue(result.isEmpty())
    }
    
    @Test
    fun `handles case insensitivity`() {
        val words = listOf("Akte", "TEAK", "kate")
        val result = findAnagrams(words)
        
        assertEquals(1, result.size)
        assertEquals(3, result[0].size)
    }
    
    @Test
    fun `handles duplicate words`() {
        val words = listOf("akte", "akte", "teak")
        val result = findAnagrams(words)
        
        assertEquals(1, result.size)
        assertEquals(2, result[0].size)
    }
    
    @Test
    fun `handles blank lines`() {
        val words = listOf("akte", "", "  ", "teak")
        val result = findAnagrams(words)
        
        assertEquals(1, result.size)
        assertTrue(result[0].containsAll(listOf("akte", "teak")))
    }
    
    @Test
    fun `finds anagram group with more than two words`() {
        val words = listOf("akte", "teak", "kate", "ekat")
        val result = findAnagrams(words)
        
        assertEquals(1, result.size)
        assertEquals(4, result[0].size)
    }
}

