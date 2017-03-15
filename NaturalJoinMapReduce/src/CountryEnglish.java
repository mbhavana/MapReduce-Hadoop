import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class CountryEnglish extends Configuration implements Tool{

	@Override
	public Configuration getConf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConf(Configuration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int run(String[] args) throws Exception {
		if (args.length<2){
			System.out.println("please give input and output file names");
			return -1;
		}
		
       JobConf conf = new JobConf (CountryEnglish.class);
       try{
    	   DistributedCache.addCacheFile(new URI("./input/country.txt"), conf);
       }
       catch(Exception e)
       {
    	   System.out.println(e);
       }
		
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		
		conf.setMapperClass(CountryEnglishMapper.class);
		//conf.setReducerClass(CountryEnglishReducer.class);
		conf.setNumReduceTasks(0);
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(Text.class);
		
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		
		JobClient.runJob(conf);
		
		return 0;
	}
		public static void main(String args[]) throws Exception{
		
			int exitCode = ToolRunner.run(new CountryEnglish(), args);
			System.exit(exitCode);
	}

}

