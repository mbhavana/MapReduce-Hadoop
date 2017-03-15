import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
//import org.apache.hadoop.mapreduce.lib.map.WrappedMapper.Context;


public class CityPopulationMapper extends MapReduceBase 
implements Mapper<LongWritable, Text, Text, IntWritable> {
     
	String lines;
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter r)
			throws IOException {
		
		  lines = value.toString();
		   String[] fields = lines.split(",");
		   
		   Text city = new Text(fields[1]);
		   Integer population = new Integer(fields[4]);
		   output.collect(new Text(city), new IntWritable(population));   
		
	}

}
