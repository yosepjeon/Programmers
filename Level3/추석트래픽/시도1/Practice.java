package Level3.추석트래픽.시도1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice {
	public static void main(String[] args ) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String line = "2016-09-15 20:59:57.421 0.351s";
		String line2 = "2016-09-15 20:59:56.233 1.991s";
		String date = "";
		int processSecond;
		int processMilliSecond;
		
		String date2 = "";
		int processSecond2;
		int processMilliSecond2;
		
		date = line.substring(0, line.lastIndexOf(" "));
		processMilliSecond = Integer.valueOf(line.substring(line.lastIndexOf(".")+1,line.indexOf("s")));
		processSecond = Integer.valueOf(line.substring(line.lastIndexOf(".")-1, line.lastIndexOf(".")));
		date2 = line2.substring(0, line2.lastIndexOf(" "));
		processMilliSecond2 = Integer.valueOf(line2.substring(line2.lastIndexOf(".")+1,line2.indexOf("s")));
		processSecond2 = Integer.valueOf(line2.substring(line2.lastIndexOf(".")-1, line2.lastIndexOf(".")));
		
//		System.out.println(date);
//		System.out.println(processTime);
		calendar.setTime(sdf.parse(date));
		calendar.add(Calendar.MILLISECOND, processMilliSecond);
		calendar.add(Calendar.SECOND, processSecond);
		System.out.println(sdf.format(calendar.getTime()));
		
		calendar2.setTime(sdf.parse(date2));
		calendar2.add(Calendar.MILLISECOND, processMilliSecond2);
		calendar2.add(Calendar.SECOND, processSecond2);
		System.out.println(sdf.format(calendar2.getTime()));
//		System.out.println(calendar2.compareTo(calendar));
		System.out.println(sdf2.format(calendar2.getTime()).toString());
//		System.out.println(sdf2.format(calendar.getTime()).compareTo(sdf2.format(calendar2.getTime())));	
		
	}
}

class CopiedSolution {
	public int solution(String[] lines) throws ParseException {
		int answer = 0;
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat keyFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Integer> map = new HashMap<>();

		for (String line : lines) {
			String date = line.substring(0, line.lastIndexOf(" "));
			int processSeconds;
			int processMilliSeconds;

			if (line.lastIndexOf(".") > line.lastIndexOf(" ")) {
				processSeconds = Integer.valueOf(line.substring(line.lastIndexOf(" ") + 1, line.lastIndexOf(".")));
				processMilliSeconds = Integer.valueOf(line.substring(line.lastIndexOf(".") + 1, line.lastIndexOf("s")));
			}else {
				processSeconds = Integer.valueOf(line.substring(line.lastIndexOf(" ")+1, line.lastIndexOf("s")));
				processMilliSeconds = 0;
			}

			calendar1.setTime(simpleDateFormat.parse(date));
			calendar2.setTime(simpleDateFormat.parse(date));
			calendar2.add(Calendar.SECOND, processSeconds);
			calendar2.add(Calendar.MILLISECOND, processMilliSeconds);

			while (keyFormat.format(calendar1.getTime()).compareTo(keyFormat.format(calendar2.getTime())) <= 0) {
				if (map.getOrDefault(keyFormat.format(calendar1.getTime()).toString(), 0) == 0) {
					map.put(keyFormat.format(calendar1.getTime()).toString(), 1);
				} else {
					map.replace(keyFormat.format(calendar1.getTime()).toString(),
							map.get(keyFormat.format(calendar1.getTime()).toString()) + 1);
				}

				calendar1.add(Calendar.SECOND, 1);
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}

		});

		Iterator<String> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			String key = itr.next();
			pq.add(map.get(key));
		}

		System.out.println("pq size: " + pq.size());
		answer = pq.poll();

		return answer;
	}
}
