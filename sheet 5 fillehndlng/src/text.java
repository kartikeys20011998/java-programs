//read data from text file and write in another file
//import java.io.InputStreamReader;//
//import java.io.BufferedReader;//
import java.io.*;
public class text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
FileReader fr=null;
BufferedReader br=null;
FileWriter fw=null;
BufferedWriter bw=null;

             String name=null;//here data is read in a string 
             //always and print on the screen
             try{
            	 fw=new FileWriter("result.txt",false);
            	 bw=new BufferedWriter(fw);
            	 
             }
             catch(FileNotFoundException e){
            	 System.out.println("invalid file path");
            	 
             }
             catch(IOException e){
            	 System.out.println("can write file");
             }
            	 int rollno=0,m1=0,m2=0,m3=0;
            	try
            	{
            	 fr=new FileReader("stud.txt");
            	 br=new BufferedReader(fr);
            	 while(true){
            		 name=br.readLine();
            		 if(name==null)
            			 break;
            			rollno= Integer.parseInt(br.readLine());
            		 m1=Integer.parseInt(br.readLine());
            		 m2=Integer.parseInt(br.readLine());
            		 m3=Integer.parseInt(br.readLine());
            	
            			int tot=m1+m2+m3;
            			bw.write("name of student"+name);
            			bw.newLine();
            			bw.write("roll no"+rollno);
            			bw.newLine();
            			bw.write("marks in comp"+m1);
            			bw.newLine();
            			bw.write("marks in science"+m2);
            			bw.newLine();
            			bw.write("marks in sst"+m3);
            			bw.newLine();
            			bw.write("total marks"+tot);
            			bw.newLine();
            			System.out.println(name);
            	 }
            	 }
            	 catch(Exception e){
            		 System.out.println("invalid file path");
            	 }
            	 
            finally{
            	//alwys executed whethr there is an exception or not
            	try{
            		bw.close();
            		fw.close();
            		br.close();
            		fr.close();
            		
            	} catch(IOException e){}
                }
                }
}
	
