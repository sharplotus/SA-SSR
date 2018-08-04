package p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author ivy
 *
 */
public class mySuffix {

	public static void main(String[] args)  {
		
		Scanner reader=new Scanner(System.in);
		System.out.println("请输入输出文件名称：");
		String filename=reader.next();
		System.out.println("请输入碱基序列：");
		
		
		PrintStream myout = null;
		try {
			myout = new PrintStream(filename+".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 创建一个打印输出流
		System.setOut(myout);//把创建的打印输出流赋给系统。即系统下次向 myout输出
		
		String s;
		/******从文件中读取**************
		try {
			s=LoadContentByPath("input.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		s=reader.next();
		s+="$";
		char[] chars=s.toCharArray();
		int len=s.length();
		String[] suff=new String[len];
		SUF[] suf=new SUF[len];
		
		System.out.println("================initialization：");
		System.out.println(s);
		System.out.println();
		
		int i=0;
		int j=0;
		Map<String, Integer> map = new HashMap<String, Integer>();//暂时使用map,after sorting 的时候赋值
		System.out.println();
		System.out.println("================before sorting：");
		while(i<len) {
			suff[j]=String.copyValueOf(chars, i, len-i);
			System.out.println(suff[j]);
			map.put(suff[j], j);
			
			i++;
			j++;
		}
		
		Arrays.sort(suff);
		System.out.println();
		System.out.println("================after sorting：");
		for(int m=0;m<suff.length;m++) {
			suf[m]=new SUF();
			suf[m].setAi(m);
			suf[m].setSa(map.get(suff[m]));
			suf[m].setString(suff[m]);
					
			System.out.printf("%-6d",map.get(suff[m]));
			System.out.println(suff[m]);
		}
		
		for(int m=1;m<suf.length;m++) {
			suf[m].setLcpa(suf[m].findLcpa(suf[m-1].getString()));
			suf[m].setK(suf[m].findK(suf[m-1].getString()));
			suf[m].setR(suf[m].findR());
			suf[m].setP(suf[m].findP(suf[m-1].getSa()));
		}
		
		System.out.println();
		System.out.println("================after finding LCPA K R P：");
		System.out.println();
		System.out.printf("%-6s","AI");
		System.out.printf("%-6s","SA");
		System.out.printf("%-6s","LCPA");
		System.out.printf("%-6s","K");
		System.out.printf("%-6s","R");
		System.out.printf("%-6s","P");
		System.out.printf("%-6s","STRING");
		System.out.println();
		System.out.println();
		for(int m=0;m<suf.length;m++) {
			System.out.printf("%-6d",suf[m].getAi());
			System.out.printf("%-6d",suf[m].getSa());
			System.out.printf("%-6d",suf[m].getLcpa());
			System.out.printf("%-6d",suf[m].getK());
			System.out.printf("%-6d",suf[m].getR());
			System.out.printf("%-6d",suf[m].getP());
			System.out.println(suf[m].getString());
		}
		
		System.out.println();
		System.out.println("================result：");
		System.out.println();
		for(int m=0;m<suf.length;m++) {
			if(suf[m].getR()>0) {
				//（1）第4个位置存在长度为6的重复序列，重复2次的SSR, GGTGGT
				String prin=String.copyValueOf(chars,suf[m].getP(),(suf[m].getR()+1)*suf[m].getK());
				System.out.println("第"+suf[m].getP()+"个位置存在长度为"+(suf[m].getR()+1)*suf[m].getK()+"，重复"+(suf[m].getR()+1)+"次的SSR，"+prin);
			}
		}
	}
	
	/**
	 * 从文件中读取
	 * @param path
	 */
	public static String LoadContentByPath(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
            buffer.append(line);
        }
        return buffer.toString();
 
    }
	
}
