import java.util.ArrayList;
import java.util.List;

public class ThreadsDemo
{
	public static void main(String[] args)
	{
		Service x = new Service();
		x.addData("Jelly");
		x.ss.forEach(System.out::println);
	}
}

class Service
{
	public List<String> ss = new ArrayList<String>();

	public void addData(String s)
	{
		ss.add(s);
		System.out.println("Added");
	}
}
