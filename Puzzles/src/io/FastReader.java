package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader {

	private InputStreamReader in =null;
	private BufferedReader br = null;
	private StringTokenizer st =null;
	public FastReader(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
	}
	
	
	public String next()
	{
		while(st==null || !st.hasMoreElements())
		{
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	
	public int nextInt()
	{
		return Integer.parseInt(next());
	}
	public long nextLong()
	{
		return Long.parseLong(next());
	}
	public double nextDouble()
	{
		return Double.parseDouble(next());
	}
	public String nextLine()
	{
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
