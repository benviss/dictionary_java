import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition newDefinition = new Definition("a def");
    assertEquals(true, newDefinition instanceof Definition);
  }

  @Test
  public void Definition_addsDefinitions_true() {
    Definition newDefinition = new Definition("A definition");
    assertEquals("A definition", newDefinition.getDefinition());
  }
}
