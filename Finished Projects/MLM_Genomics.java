//The purpose of this code is to look through the Ml0117/Data/Genomics results and find overlapping genes or pathways.
//This code requires txt files named according to study.  Examples might be MlRnaTvO, MlRrbsTvO, P12Blood, or Lars.
//Each line in the txt files contains, in this order, gene name, then adjusted p value, separated by a tab (use Excel).
//An unadjusted p value is optional, but it must go after the adjusted p value, separated by a tab.
//Each txt file gets ONE list of genes.  Don't combine DDT & DDE.  Don't combine RNA and RRBS.  Don't combine P12 and ML0117.
//No headers in your txt file.

//In this code, data is summed up in an list named allFiles.
//You can think of allFiles as the folder that contains a bunch of txt files, each of which contains a bunch of genes (or pathways).
//Additionally, an array called fileNames contains the String text of each txt file name.

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.Math.pow;
import java.io.File;
import java.io.FileWriter;
public class MLM_Genomics { //requires Java compiler!
	static double p = .05; //SIGNIFICANCE THRESHOLD
	static double prelax = .1; //RELAXED THRESHOLD
	public static void main (String [] args) throws Exception {
		String address = "C:/Users/Kyle Jackson/Desktop/Science/Programs/Runnable/Java/"; //only runs on Kyle's computer
		//scribe(address, "MLM_Practice");
		//scribe(address, "MLM_Genes");
		scribe(address, "MLM_Pathways");
	}

	public static void scribe(String address, String content) throws Exception {
		ArrayList <ArrayList> allFiles = new ArrayList <ArrayList>();
		String [] fileNames = new File(address+content).list();
		for(int i = 0; i < fileNames.length; i++) {
			allFiles.add(populate(new File(address+content+'/'+fileNames[i]),fileNames[i], p)); //populates allFiles by adding each txt file
		}

		//for(int i = 0; i < allFiles.size(); i++) { //If you want to see what allFiles will be comparing, uncomment this
		//	for(int j = 0; j < allFiles.get(i).size(); j++) {
		//		System.out.println(allFiles.get(i).get(j));
		//	}
		//}

		File output = new File(content+".txt"); //writes new output txt file
		FileWriter fw = new FileWriter(output);

		for(int i = 0; i < allFiles.size(); i++) {
			for(int j = i+1; j < allFiles.size(); j++) {
				compare(fw, allFiles.get(i), allFiles.get(j)); //compare every txt file to every other txt file & write similarities in output file
			}
		}

		fw.flush();
		fw.close();
	}

	//each time populate() is called, it adds one study to allFiles by making an ArrayList of Strings, but only the significant genes
	public static ArrayList <String> populate(File doc, String name, double cutoff) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(doc));
		ArrayList <String> output = new ArrayList <String>();
		String s;
		while((s = br.readLine()) != null) { //this is the bit that reads one line of your txt file
			int index = s.indexOf("\t");
			String s1= s.substring(0, index).toLowerCase(); //this splits gene (or pathway) name off from p-values.
			String s10= s.substring(index+1);
			String s2 = s10;
			String s3 = s10;
			index = s10.indexOf("\t");
			if(index > -1) {
				s2 = s10.substring(0, index); //this splits off the adjusted p-value and (if applicable) unadjusted p-value
				s3= s10.substring(index+1);
			}
			if(s2.indexOf("NA") > -1 || s2.indexOf("NA") > -1) {}
			else {
				double pval = Double.parseDouble(s2);
				double unadjustpval = Double.parseDouble(s3);
				if(pval < cutoff)
					output.add(s1); //this adds only significant genes to the study
				if(unadjustpval < cutoff && name.indexOf("Unadjusted") > -1)
					output.add(s1); //this adds genes if we want to look at unadjusted p-values.
			}
		}

		if(output.size() < 1 && cutoff == p) {
			output = populate(doc, name+" Relaxed ", prelax); //if no genes from that txt file are good enough, we relax our standards.
		}
		else {	if(output.size() < 1 && name.indexOf("Unadjusted") < 0) {
				output = populate(doc, name+"Unadjusted", prelax); //if STILL no genes are good enough, we'll look at unadjusted p-values.
			}
			else {output.add(0, name);} //I wanted to name the gene list before it goes into allFiles, according to what your txt file was named.
		}
		return output;
	}

	public static void compare(FileWriter fw, ArrayList <String> list1, ArrayList <String> list2) throws Exception {
		for(int i = 0; i < list1.size(); i++) {
			for(int j = 0; j < list2.size(); j++) {
				if(list1.get(i).equals(list2.get(j))) { //compare every gene in file 1 to every gene in file 2
					fw.write(list1.get(0) + "\t" + list2.get(0) + "\t"); //This tells you what txt files the genes came from!
					fw.write(list1.get(i) + "\n");
				}
			}
		}
		return;
	}
}