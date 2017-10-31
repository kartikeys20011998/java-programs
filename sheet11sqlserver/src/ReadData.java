//read data from the table and print on screen
import java.sql.*;
public class ReadData {

	
	public static void main(String[] args) {
		Connection con=null;//interface to conect with data
		Statement st=null;//interface to execute queries on table
		ResultSet rs=null;//interface to read data from table
		try{
			//load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
		}
		catch (ClassNotFoundException e){
			System.out.println("Invalid Driver" +e.getMessage());
			System.exit(0);
			
		}
		catch (SQLException e){
			System.out.println("Invalid Dsn" +e.getMessage());
			System.exit(0);
		}
		
		try{
			//initialize statement to execute queries
			st=con.createStatement();
			//execute query and store result in Resultset
		//	rs=st.executeQuery("select * from emp");
		//	rs=st.executeQuery("select * from emp where id=3");
		//	rs=st.executeQuery("select * from emp where name='RAM KUMAR'");
			rs=st.executeQuery("select * from emp order by salary desc");
			//rs=st.executequery("select * from emp where salary>=1200");
			if(rs.next()){//returns true if able to read a row ,otherwise false
				do{
					//System.out.println("id:"+rs.getInt("id"));
		//			System.out.println("name :"+rs.getString("name"));
			//		System.out.println("date of birth :"+rs.getDate("dob").toString());
				//	System.out.println("salary :"+rs.getFloat("salary"));
					//System.out.println("-----------------------------");
					  int id1=rs.getInt("id");
					  String ss=rs.getString("name");
					  String dt1=rs.getDate("dob").toString();
					  double s1=rs.getDouble("salary");
					  String gender=rs.getString("sex");
					  //s1=s1+5000;
					  //store values in other variables and then print
					  System.out.println("Id              :"+id1);
					  System.out.println("name            :"+ss);
					  System.out.println("date of birth   :"+dt1);
					  System.out.println("salry           :"+s1);
					  System.out.println("gender          :"+gender);
					  System.out.println("-------------------");
					  
				}while(rs.next());
			}
			
			else{
				System.out.println("no record found");
			}
		}
		catch(SQLException e){
			 System.out.println("query error:"+e.getMessage());
			 
			}
		finally{
			try{
				rs.close();
				st.close();
				con.close();
				
				
			}catch(SQLException e){
		}
			
			
		}
	
		

	}

}
