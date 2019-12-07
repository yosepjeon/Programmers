package 찾아라프로그래밍마에스터.폰켓몬;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Practice {
	public static void main(String[] args)  {
		Properties properties = System.getProperties();
		Map<String, String> env = System.getenv();
		
		System.out.println("******************** Prop ********************");
		
		Iterator<Object> itrProp = properties.keySet().iterator();
		
		while(itrProp.hasNext()) {
			Object value = itrProp.next();
			System.out.println(value + "= " + properties.get(value)); 
		}
		
		System.out.println("******************** Env ********************");
		
		Iterator<String> itrEnv = env.keySet().iterator();
		
		while(itrEnv.hasNext()) {
			String value = itrEnv.next();
			System.out.println(value + "= " + env.get(value));
		}
	}
}
