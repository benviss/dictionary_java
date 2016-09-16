import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @Test
  public void Word_instantiatesCorrectly_true() {
    Word newWord = new Word("Apple","what");
    assertEquals(true, newWord instanceof Word);
  }


  @Test
  public void Word_addsDefinition_true() {
    Word newWord = new Word("Apple","what");
    assertEquals("what", newWord.getDefinitionsArray().get(0).getDefinition());
  }
  @Test
  public void Word_addsMultipleDefinitions_true() {
    Word newWord = new Word("Apple","A fruit");
    Definition newDef2 = new Definition("A fruit?");
    newWord.addDefinitions(newDef2);
    assertEquals("A fruit", newWord.getDefinitionsArray().get(0).getDefinition());
    assertEquals("A fruit?", newWord.getDefinitionsArray().get(1).getDefinition());
  }

  @Test
  public void Word_getsID_1() {
    Word newWord = new Word("Apple","what");
    assertEquals((Integer) 1, newWord.getID());
  }


}
