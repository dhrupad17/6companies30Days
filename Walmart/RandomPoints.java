// Java program for the above approach
import java.util.*;

class RandomPoints{	
static final double PI = 3.141592653589;
static class pair
{
	double first, second;
	public pair(double first,double second)
	{
		super();
		this.first = first;
		this.second = second;
	}
}
static double uniform(){
    return Math.random();
}
static Vector<pair> randPoint(int r, int x,int y, int n)
{
	Vector<pair> res = new Vector<pair>();
	for(int i = 0; i < n; i++)
	{
		double theta = 2 * PI * uniform();
		double len = Math.sqrt(uniform()) * r;
		res.add(new pair(x + len * Math.cos(theta),y + len * Math.sin(theta)));
	}
	return res;
}
static void printVector(Vector<pair> A)
{
	for(pair P : A)
	{
		System.out.printf("(%.2f, %.2f)\n",P.first, P.second);
	}
}
public static void main(String[] args)
{
	int R = 12;
	int X = 3;
	int Y = 3;
	int N = 5;
	printVector(randPoint(R, X, Y, N));
}
}