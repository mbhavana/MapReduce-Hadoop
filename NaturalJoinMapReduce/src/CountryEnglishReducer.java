
import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashSet;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import java.util.Set;
//import java.util.Map;
//import java.util.TreeMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import java.io.BufferedReader;


public class CountryEnglishReducer extends MapReduceBase
implements Reducer<Text, Text, Text, Text>{
	/*
	public static void main (String [] args) throws Exception{
    
	try{
		//Path pt = new Path("hdfs://0.0.0.0:8020/user/training/input2/country.txt");
		Path pt = new Path("country.txt");
		FileSystem fs = FileSystem.get(new Configuration());
		BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(pt)));
		String line;
		 line = br.readLine();
		 while (line != null){
				
				
				String[] tokens = line.split(",");				
				String country_id = tokens[0];
				String country_name = tokens[1];
				
		 }
		 br.close();
		fs.close();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
		
	}
	*/
@Override
	public void reduce(Text key, Iterator<Text> values,
			OutputCollector<Text, Text> output, Reporter r)
					throws IOException {
		/*
				if (country_id.containsKey(key.toString()))
				{
					output.collect(new Text(country_name), new Text(""));
				}
		*/		
			}
	
	}

