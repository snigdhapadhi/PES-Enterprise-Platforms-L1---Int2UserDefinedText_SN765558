/**************************************************************************
* Assignment Title: Int2UserDefinedText
* Assignment Description:Converting the number currency to words in metric or US
* Algorithmic steps / Design in brief:
* Limitation if any:until 10 crores
 * Date of last update:26/10/16
*
* Author details:
 * emp number:328094     
 * name:Snigdha Padhi	
* email:snigdha.padhi@wipro.com
*************************************************************************/

import java.io.*;
public class Int2UserDefinedText
{
	public static void main(String[] args) throws IOException
	{
		String first[]={"","one","two","threee","four","five","six","seven","eight","nine"};
		String second[]={"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		String third[]={"hundred","thousand","million","billion"};
		String fourth[]={"hundred","thousand","lakh","crore"};
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number and US/Metric");
		String line=br.readLine();
		String []arr=line.split("\\s+");
		int cur=Integer.parseInt(arr[0]);
		arr[1]=arr[1].toLowerCase();
		String res="";
		int i=0;
		String sam="";
		String maybe[]=new String[4];
		int count=0;
		int index=0;
		if (arr[1].equals("us"))
		{
			while (cur>0)
			{
				int k=cur%10;
				if (i==0)
					res=first[k]+res;
				else if (i==1)
					res=" "+second[k]+" "+res;
				else if (i==2)
				{
					if (k!=0)
						res=" "+first[k]+" "+third[0]+" "+res;
				}
			    else
				{
					sam=k+sam;
					count+=1;
					if (count==3)
					{
						maybe[index]=sam;
						count=0;
						index++;
						sam="";
					}
				}
				cur=cur/10;
				i++;
			}
			if (sam!="")
				maybe[index]=sam;
			for (int j=0;j<maybe.length;j++)
			{
				if (maybe[j]!=null)
				{
					if (Integer.parseInt(maybe[j])!=0)
						res=" "+maybe[j]+" "+third[j+1]+" "+res;
				}
			}
			System.out.println(res);
		}

		if (arr[1].equals("metric"))
		{
			while (cur>0)
			{
				int k=cur%10;
				if (i==0)
					res=first[k]+res;
				else if (i==1)
					res=" "+second[k]+" "+res;
				else if (i==2)
				{
					if (k!=0)
						res=" "+first[k]+" "+third[0]+" "+res;
				}
				else
				{
					sam=k+sam;
					count+=1;
					if (count==2 && index<=1)
					{
						maybe[index]=sam;
						count=0;
						index++;
						sam="";
					}
					else if(index==2)
					{
						maybe[index]=sam;						
					}
				}
				cur=cur/10;
				i++;
			}
			if (sam!="")
				maybe[index]=sam;
			for (int j=0;j<maybe.length;j++)
			{
				if (maybe[j]!=null)
				{
					if (Integer.parseInt(maybe[j])!=0)
						res=" "+maybe[j]+" "+fourth[j+1]+" "+res;
				}
			}
			System.out.println(res);
		}
	}
}