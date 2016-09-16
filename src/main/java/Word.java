import java.util.ArrayList;

public class Word {
  private Integer mID;
  private String mWord;
  private ArrayList<Definition> mDefinitions = new ArrayList<Definition>();
  private static ArrayList<Word>  mInstances = new ArrayList<Word>();

  public Word(String _userWord, String _userDef) {
    Definition newDef = new Definition(_userDef);
    mWord = _userWord;
    mInstances.add(this);
    mID = mInstances.size();
    mDefinitions.add(newDef);
  }

  public void addDefinitions(Definition _definition) {
    mDefinitions.add(_definition);
  }

  public ArrayList<Definition> getDefinitionsArray() {
    return mDefinitions;
  }

  public String getWord() {
    return mWord;
  }

  public Integer getID() {
    return mID;
  }

  public static Word find(int _id) {
    return mInstances.get(_id - 1);
  }


}
