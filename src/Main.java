import java.util.*;
import java.io.*;
import com.google.gson.*;

public class Main
{
	static Gson gson=new Gson();
	public static void main(String[] args) throws IOException
	{
		File wisecraft=new File("/sdcard/Wisecraft/servers.json");
		File larger=new File("/sdcard/larger.json");
		File smaller=new File("/sdcard/smaller.json");
		
		System.out.println("TEST:Wisecraft");
		System.out.println("    gson time:"+testWisecraftWithGson(wisecraft));
		System.out.println("fastjson time:"+testWisecraftWithGson(wisecraft));
		
		
		System.out.println("TEST:larger");
		System.out.println("    gson time:"+testWisecraftWithGson(wisecraft));
		System.out.println("fastjson time:"+testWisecraftWithGson(wisecraft));
		
	}
	private static long testWisecraftWithGson(File f)throws IOException{
		FileReader r=null;
		long s=System.currentTimeMillis();
		try{
			gson.fromJson(r=new FileReader(f),Server[].class);
		}finally{
			if(r!=null)r.close();
		}
		return System.currentTimeMillis()-s;
	}
	public static class Server{
		public String ip;
		public int port;
		public boolean isPC;
	}
}
