
public class string {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s1="ramesh";
String s2="suresh";
String s3=s1+" " +s2;
System.out.println(s1+""+s2+""+s3);
if(s1==s2)
	System.out.println("both have same names");
if(s1.equals(s2))
	System.out.println("sme name");
if(s1.equals("ramesh"))
	System.out.println("they have both have same name");
int l;
l=s1.length();
System.out.println(s1.charAt(2));
	}

}