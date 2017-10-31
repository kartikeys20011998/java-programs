
public class array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int []arr={10,5,6,7};
for (int i=0;i<arr.length;i++)
{
	System.out.println(arr[i]);
	
}
int[]arr1=new int[10];
for(int i=0;i<10;i++)
{	
arr1[i]=i;
}
for(int i=0;i<10;i++)
{
	System.out.print (arr1[i]+"\t");
}
System.out.println("\ntwo dimensional array");
int arr2[][]=new int[3][4];
for(int i=0;i<3;i++)
{
	for(int j=0;j<4;j++)
	{
		arr2[i][j]=i*j;
	}
}
for(int i=0;i<3;i++)
{

for(int j=0;j<4;j++)
{
	System.out.print (arr2[i][j]+"\t");
}
System.out.println();
	}

	System.out.println("\n three dimensional array");
	int arr3[][][]=new int[3][4][5];
	
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<4;j++)
			{
				for(int k=0;k<5;k++)
				{
					arr3[i][j][k]=i*j*k;
				}
			}
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<4;j++)
			{
				for(int k=0;k<5;k++)
				{
					System.out.print (arr3[i][j][k]+"\t");
					
				}
				System.out.println();
				
				}
			System.out.println("\n\n");
			}
		
	
boolean bb;
bb=true;
if(bb)
	System.out.println("it will print");
if(!bb)
	System.out.println("it will not print");
bb=false;
if(bb)
	System.out.println("it will not print");
if(!bb)
	System.out.println("it will print");

}
}
