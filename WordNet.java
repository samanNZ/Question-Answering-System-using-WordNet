import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;




import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
// tamame properties ru az dbpedia endpoint begir va tu array save kun
public class WordNet {
public static void main(String[] args) throws IOException, SQLException {
	
	    
		String sparqlQuery = "select distinct  ?label where "
				+ "{ ?property <http://www.w3.org/2000/01/rdf-schema#domain> ?class ."
				+ "  ?property  <http://www.w3.org/2000/01/rdf-schema#label> ?label ."
				+ " FILTER (lang(?label) = 'en')"
				+ " }  ";
		List<String> props = new ArrayList<String>();		
				
		//System.out.println(sparqlQuery);
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
		ResultSet results = qexec.execSelect(); 
		while(results.hasNext()){
			props.add(results.next().get("label").toString());
			/*results.next();
			System.out.println(results.next());*/
		}
		qexec.close() ;
		//System.out.println(props);
		FileWriter fw=new FileWriter("syn.txt"); 
		int count=0;
		
		for(String prop:props){
			//System.out.println(prop );
			String [] prts = prop.split("@"); 
			prop = prts[0];
			List<String> synm = JAWS.getSynonyms(prop);
			if(synm.size() >0)
				count++;
			System.out.println(prop + "\t" + synm);
			fw.write(prop+"\t"+synm+"\n");
			}
		//System.out.println("Total properties in DBpedia= " + props.size());
		//System.out.println("Total properties with synm in DBpedia= " + count);
		//System.out.println(synm.size()); //in miyad tedad synonym har prop ru jodagane mide 
		fw.close();
		
	}      
}
      

 



			
			
			
			
			
		
	






			
			
			
		
		
      

 



			
			
			
			
			
		
	





