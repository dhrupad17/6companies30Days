import java.util.*;
class KSwaps{
static String max;
static void findMaximumNum(char[] str,int k)
{
if (k == 0)
	return;
int n = str.length;
for (int i = 0; i < n - 1; i++)
{
	for (int j = i + 1; j < n; j++)
	{
	if (str[i] < str[j])
	{
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
		if (String.valueOf(str).compareTo(max) > 0)
		max = String.valueOf(str);
		findMaximumNum(str, k - 1);
		char c = str[i];
		str[i] = str[j];
		str[j] = c;
	}
	}
}
}
public static void main(String[] args)
{
String str = "129814999";
int k = 4;
max = str;
findMaximumNum(str.toCharArray(), k);
System.out.print(max + "\n");
}
}
