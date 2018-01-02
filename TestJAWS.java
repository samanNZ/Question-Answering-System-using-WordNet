import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
// tamame properties ru az dbpedia endpoint begir va tu array save kun
public class TestJAWS{
    public static void main(String[] args){
          String wordForm = "capacity";
          //  Get the synsets containing the word form=capicity

         File f=new File("G:\\Eclipse\\DBpedia\\dict");
         System.setProperty("wordnet.database.dir", f.toString());
         //setting path for the WordNet Directory

         WordNetDatabase database = WordNetDatabase.getFileInstance();
         Synset[] synsets = database.getSynsets(wordForm);
         //  Display the word forms and definitions for synsets retrieved

         if (synsets.length > 0){
            ArrayList<String> al = new ArrayList<String>();
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

            //showing all synsets
            for (int i = 0; i < al.size(); i++) {
                  System.out.println(al.get(i));
            }
         }
    }
    }
    
} 


