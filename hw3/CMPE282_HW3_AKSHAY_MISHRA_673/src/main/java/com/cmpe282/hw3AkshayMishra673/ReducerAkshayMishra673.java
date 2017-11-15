package com.cmpe282.hw3AkshayMishra673;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class ReducerAkshayMishra673 extends Reducer<Text,IntWritable,Text,IntWritable> {       
    
    //private IntWritable result = new IntWritable();
    TreeMap<Text,IntWritable> result = new TreeMap<Text, IntWritable>();

    public void reduce(Text key, Iterable<IntWritable> values,  Context context) throws IOException, InterruptedException {
            
            int sum = 0;        
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.put(new Text(key),new IntWritable(sum));
        }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        Set<Map.Entry<Text, IntWritable>> set = result.entrySet();
        
        List<Map.Entry<Text, IntWritable>> list = new ArrayList<Map.Entry<Text,IntWritable>>(set);
        
        Collections.sort( list, new Comparator<Map.Entry<Text, IntWritable>>() {
            public int compare( Map.Entry<Text, IntWritable> o1, Map.Entry<Text,IntWritable> o2 ) {
                return ((o2.getValue()).compareTo( o1.getValue()) * -1);
            }
        });
        
        for(Map.Entry<Text,IntWritable> entry:list){

            context.write(entry.getKey(),entry.getValue());
        }
    }
}
