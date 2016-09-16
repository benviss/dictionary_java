import java.util.ArrayList;

public class Dictionary {
  private ArrayList<Word> mDictionary;


  public Dictionary() {
    mDictionary = new ArrayList<Word>();

  }

  public void addWord(Word _newWord) {
    mDictionary.add(_newWord);
  }

  public ArrayList<Word> getWords() {
    return mDictionary;
  }

  public Word find(Integer _id) {
    return mDictionary.get(_id - 1);
  }
}
