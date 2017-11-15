package com.cmpe282.hw3AkshayMishra673;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MapperAkshayMishra673 extends Mapper<Object, Text, Text, IntWritable> {

	  private final static IntWritable ONE = new IntWritable(1);
	  private Text word = new Text();

	  public void map(Object key, Text value, Context context
	                  ) throws IOException, InterruptedException {
	      String[] split = value.toString().split(" ");
	      for(int i=0; i<split.length; i++){
	          if (i==6){
	          	  word.set(split[i]);
	              context.write(word, ONE);
	          }

	      }
	  }
	  }
