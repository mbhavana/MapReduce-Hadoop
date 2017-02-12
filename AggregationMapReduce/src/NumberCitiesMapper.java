import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class NumberCitiesMapper extends MapReduceBase 
implements Mapper<LongWritable, Text, Text, IntWritable> {

	String lines;
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter r)
			throws IOException {
		
		   lines = value.toString();
		   String[] fields = lines.split(",");
		   Text district = new Text(fields[3]);
		   
		  // if (district.length > 0)
		  // {
			   output.collect(new Text(district), new IntWritable(1));
		
		 //  }

	}
}
