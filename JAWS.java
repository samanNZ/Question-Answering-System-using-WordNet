import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class JAWS{
 public static void main(String[] args){
  String word = "Capacity"; 
  List<String> synm = getSynonyms(word) ;
  //showing all synsets
  //for (int i = 0; i < synm.size(); i++) {
   System.out.print(synm);

  //}
 }

 public static List<String> getSynonyms(String word) {
  String wordForm = word;
  //  Get the synsets containing the word form=capicity

  File f=new File("WordNet\\2.1\\dict");
  System.setProperty("wordnet.database.dir", f.toString());
  //setting path for the WordNet Directory

  WordNetDatabase database = WordNetDatabase.getFileInstance();
  Synset[] synsets = database.getSynsets(wordForm);
  //  Display the word forms and definitions for synsets retrieved
  // System.out.println(synsets);
  ArrayList<String> al = new ArrayList<String>();
  if (synsets.length > 0){
   // add elements to al, including duplicates
   HashSet hs = new HashSet();
   for (int i = 0; i < synsets.length; i++){
    String[] wordForms = synsets[i].getWordForms();
    for (int j = 0; j < wordForms.length; j++)
    {
     al.add(wordForms[j]);
    }
   
    //removing duplicates
    hs.addAll(al);
    al.clear();
    al.addAll(hs);
   }

  }

  else
  {
  // System.err.println("No synsets exist that contain the word form '" + wordForm + "'");
  }
  return al;
 } 

}