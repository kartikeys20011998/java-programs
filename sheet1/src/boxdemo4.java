class employee
{
String s1;

double sal;
int exp,no;
employee(String ss,double sal1,int exp1,int no1)

{
	sal=sal1;
	exp=exp1;
	s1=ss;
	no=no1;
			
}




void display(employee ee)
{
	System.out.println("name of employee  "+ee.s1);
	System.out.println("the number of the employee "+ee.no);
	System.out.println("the expirence of the employee"+ee.exp);
	System.out.println("the salary of the employee is"+ee.sal);
	
	}
void increase(employee ee)
{
if (ee.exp>5)
{
	ee.sal=(10.0*ee.sal/100.0)+ee.sal;
	System.out.println("name of employee whose salary is increased  "+ee.s1);
	System.out.println("the number of the employee whose salary is increased"+ee.no);
	System.out.println("the expirience of the employee whose salary is being increased"+ee.exp);
	System.out.println("the  total salary "+ee.sal);
	}	
}

}
public class boxdemo4 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
employee ee1=new employee("ramesh",12345.0,6,1);
employee ee2=new employee("suresh",16578.0,4,2);
ee1.display(ee1);
ee1.display(ee2);
ee1.increase(ee1);
ee1.increase(ee2);

	}

}
