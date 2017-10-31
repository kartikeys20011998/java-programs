//input data frm keyboard and write in data file text mode!
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.io.*;

public class textfileiovariable3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
InputStreamReader ir=new InputStreamReader(System.in);//make object ir for input
		
		BufferedReader br =new BufferedReader(ir);

		FileWriter fw=null;//to open file in write mode
		BufferedWriter bw=null;//to read from buffer and write in file
		
		String name="YK";
		int rollno=0,m1=0,m2=0,m3=0,f=0;
		int c;
		try{
			fw=new FileWriter("stud.txt",false);//true means append file//false means open new file
			bw=new BufferedWriter(fw);
		}
		catch(FileNotFoundException e){
			System.out.println("invalid file path");
			
		}
		catch(IOException e){ //this exception is must be written
			System.out.println("cant write to file"); //other write it will give error
		}
		try{
			do
			{
				System.out.println("enter name");
				try{
					name=br.readLine();
				}
				catch(IOException e){
					System.out.println("io error"+e.getMessage());
					System.exit(0);
				}
				do
				{
					
				
				try{ //evry caption shld be written bfr its conversion frm string
					f=1;
					System.out.println("enter roll no");
					rollno=Integer.parseInt(br.readLine());
					System.out.println("enter marks in physics");
					m1=Integer.parseInt(br.readLine());
					System.out.println("enter marks in chemistry");
					m2=Integer.parseInt(br.readLine());
					System.out.println("enter marks in maths");
					m3=Integer.parseInt(br.readLine());
					if(rollno<0||m1<=0||m2<0||m3<0)
						throw new NumberFormatException("invalid no");
				}
				catch(IOException e){
					System.out.println("io error"+e.getMessage());
					System.out.println("invalid no enter again");
					f=0;
				}
				catch(NumberFormatException e)
				{
					System.out.println("io error"+e.getMessage());
					System.out.println("invalid no enter again");
					f=0;
				}
				}while(f==0);
				bw.write(name);
				bw.newLine();
				bw.write(""+rollno);
				bw.newLine();
				bw.write(""+m1);
				bw.newLine();
				bw.write(""+m2);
				bw.newLine();
				bw.write(""+m3);
				bw.newLine();
				//in java if we r writing in text mode then 
				//evry data must be written in string
				System.out.println("1. to enter more date");
				System.out.println("2. to exit");
				c=Integer.parseInt(br.readLine());
			}while(c==1);
		}catch(IOException e){}
		finally{
			//always executed whether there is an exception or not
			try{
				bw.close();
				fw.close();
			}
			catch(IOException e){System.exit(0);}
			
				
				}
			}
			
		}
		
		
		

	


