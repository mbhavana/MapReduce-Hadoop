import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class CountryEnglishMapper extends MapReduceBase 
implements Mapper<LongWritable, Text, Text, Text>{
	
	
	private Path[] cacheFile;
	String lines;
	Map<String,String> id_country = new HashMap<String,String>();
	@Override
	public void configure(JobConf job)
	{
		try {
			cacheFile = DistributedCache.getLocalCacheFiles(job);
		
		for(Path p : cacheFile)
		{
			if(p.getName().equals("country.txt"))
			{
				BufferedReader br = new BufferedReader(new FileReader(p.toString()));
				String line = br.readLine();
				while(line != null)
				{
					String[] tokens = line.split(",");
					String id = tokens[0];
					String name = tokens[1];
					id_country.put(id, name);
					line = br.readLine();
				}
				br.close();
			}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, Text> output, Reporter report) throws IOException {
		
		lines = value.toString();
		String[] tokens = lines.split(",");
		
			String country_id = tokens[0];
			String isOfficial = tokens[2];
			String isEnglish = tokens[1];
			if(isOfficial.contains("T"))
			{
				if(isEnglish.contains("English"))
				
			{
					String country = null;
					country = id_country.get(country_id);
					if(!country.isEmpty())
					{
				//System.out.println(lines);
				output.collect(new Text(country), new Text(""));
					}
			}
			}
		//}
		//else
		//{
		//	String country_id = tokens[0];
			//String country_name = tokens[1];
			//output.collect(new Text(country_id), new Text("2\t" + country_name));
		//}
	}
	
}
	
	


