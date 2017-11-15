package com.cmpe282.hw3AkshayMishra673;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



//java -jar target/hw3AkshayMishra673-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.cmpe282.hw3AkshayMishra673.WCAkshayMishra673 -Dfs.default.name="file://localhost:9000/"
//java -jar target/hw3AkshayMishra673-0.0.1-SNAPSHOT-jar-with-dependencies.jar
public class WCAkshayMishra673  {
		public static void main(String[] args) throws Exception {
	    Configuration conf = new Configuration();   
	    String[] otherArgs = new String[]{"/tmp/wordcount/in", "/tmp/wordcount/out"};
	    File f = new File(otherArgs[1]);
	    
	    if(f.exists() ){
	    	FileUtils.cleanDirectory(f); 
	        FileUtils.forceDelete(f);         
	    }
	    
	    Job job = new Job(conf, "Url Count");
	    
	    job.setJarByClass(WCAkshayMishra673.class);
	    job.setMapperClass(MapperAkshayMishra673.class);
	    job.setReducerClass(ReducerAkshayMishra673.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	    
	    FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
	    FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));    
	    
	    /*
	    if (job.waitForCompletion(true) ? true : false)
	    	HelperAkshayMishra673.printOutput(new File(otherArgs[1]));	
	    */
	    
	    System.exit(job.waitForCompletion(true) ? 0 : 1);    
	  } 
}
