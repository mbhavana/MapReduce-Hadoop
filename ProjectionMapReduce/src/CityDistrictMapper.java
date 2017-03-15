import java.io.IOException;

//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class CityDistrictMapper extends MapReduceBase 
implements Mapper<LongWritable, Text, Text, Text>{

	String lines;
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, Text> output, Reporter r)
			throws IOException {
			 
			lines = value.toString();
		    String[] fields = lines.split(",");
		   
		    Text city = new Text(fields[1]);
		    Text district = new Text(fields[3]);
		    
		    output.collect(new Text(city), new Text("|" + district));
		
	}

}
