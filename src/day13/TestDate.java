package day13;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class TestDate {

	public static void main(String[] args) {
		
		java.util.Date date = new java.util.Date();		
		System.out.println(date);//Wed Sep 02 11:33:59 CST 2020
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		System.out.println(df1.format(date));//2020-09-02 11:33:59.586
		
		//------------------------------------------------------------------
		//Calendar
		Calendar c = Calendar.getInstance();
		//Calendar类的getTime()方法返回的是java.util.Date类型的对象
		System.out.println(c.getTime());//Wed Sep 02 14:41:12 CST 2020
		//用Calendar类的方法来获得年月日。注意月份要+1.
		System.out.println(c.get(Calendar.YEAR)); //2020
		System.out.println(c.get(Calendar.MONTH) + 1); //9
		System.out.println(c.get(Calendar.DATE)); //2
		//日期时间的加减。参数(要进行变动的变量,变化量大小) (变化量的数字前带一个负号则表示减)
		c.add(Calendar.YEAR, -10);
		System.out.println(c.getTime());//Thu Sep 02 14:47:56 CST 2010
		//用来进行日期累加时会自动计算到相应的年月日,不会出现脱离常识的值如月份变为19。
		c.add(Calendar.MONTH, 10);
		System.out.println(c.getTime());//Sat Jul 02 14:47:56 CST 2011
		//上面的日期要格式化成我们想要的样子的话还需要用到前面的格式化的办法
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		System.out.println(df.format(c.getTime()));//2011-07-02 02:58:00.374
				
		//设置日期和时间
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		//用set设置年月日。(注意5代表的是6月)
		c1.set(2012, 5, 6); 
		System.out.println(df.format(c1.getTime()));//2012-06-06 03:07:26.033
		c2.set(2014, 7, 7);
		System.out.println(df.format(c2.getTime()));//2014-08-07 03:07:26.033
		//用before来比较当前日期是否在参数日期之前
		System.out.println(c1.before(c2));//true
		System.out.println(c1.after(c2));//false
		//---------------------------JDK8.0-----java.time-----------------------------
		
		//LocalDate是日期类
		//now()方法获得当前系统日期
		LocalDate ldt1 = LocalDate.now();
		System.out.println(ldt1);//2019-01-02
		//of()方法用于自己指定日期。参数(年,月,日)
		LocalDate ldt = LocalDate.of(2012, 2, 1);  
		System.out.println(ldt);//2012-02-01
		//单独获得年或者月或者日的方法。
		System.out.println(ldt.getYear());//2012
		System.out.println(ldt.getMonthValue());//2。注意不是getMonth()。
		System.out.println(ldt.getMonth());//FEBRUARY。getMonth()得到的是一个Month类的对象
		System.out.println(ldt.getDayOfMonth());//1。获得的是一个月中的第几天
		System.out.println(ldt.getDayOfYear());//32。获得的是一年月中的第几天
		System.out.println(ldt.getDayOfWeek().getValue());//3。即星期三,获得的是一个星期中的第几天
		//plusYears()方法表示在原来日期的基础上加多少年。相应的还有plusDays()、plusMonths()、plusWeeks()
		System.out.println(ldt.plusYears(10));//2022-02-01
		//也可以用负数作为参数
		System.out.println(ldt.plusMonths(-10));//2011-04-01
		//minusMonths()表示多少在原来日期的基础上减多少月。注意上下两条语句是等价的
		System.out.println(ldt.minusMonths(10));//2011-04-01
		
		//LocalTime是时间类。方法和上面的LocalDate类似
		//now()方法获得当前系统时间
		LocalTime ltime = LocalTime.now();
		System.out.println(ltime);//15:45:06.945
		//of()方法用于自己指定时间。参数(时,分,秒)。
		LocalTime ltime1 = LocalTime.of(12, 2, 45);
		System.out.println(ltime1);//12:02:45
		//of()方法用于自己指定时间。有一种重载可以连纳秒一起设置,参数(时,分,秒,纳秒)。(注意是纳秒不是毫秒)
		LocalTime ltime2 = LocalTime.of(12, 2, 45,222);		
		System.out.println(ltime2);//12:02:45.000000222。(注意:1毫秒=1000000纳秒)
		//单独获得时、分、秒、纳秒的方法。(没有毫秒)
		System.out.println(ltime.getHour());//15
		System.out.println(ltime.getMinute());//45
		System.out.println(ltime.getSecond());//6
		System.out.println(ltime.getNano());//945000000
		//plusHours()方法表示在原来时间的基础上加多少小时。相应的还有plusMinutes()、plusSeconds()、plusNanos()
		System.out.println(ltime.plusHours(17));//08:45:06.945
		//minusMonths()表示多少在原来时间的基础上减多少分钟。
		System.out.println(ltime.plusMinutes(2));//15:47:06.945
		
		//LocalDateTime是日期和时间类(上面介绍的LocalDate和LocalTime的方法它都有同名方法)
		LocalDateTime dtm1 = LocalDateTime.now();
		System.out.println(dtm1);//2020-09-02T17:10:41.549
		//of()方法在LocalDateTime类里有多种重载,这里这种参数是(年,月,日,时,分,秒)
		LocalDateTime dtm2 = LocalDateTime.of(2011, 4, 5, 5, 6 , 5);
		System.out.println(dtm2);//2011-04-05T05:06:05
		//可单独获得年、月、日、时、分、秒、纳秒等。
		System.out.println(dtm1.getYear());//2020
		System.out.println(dtm1.getMonthValue());//9
		System.out.println(dtm1.getDayOfMonth());//2
		System.out.println(dtm1.getHour());//17
		System.out.println(dtm1.getMinute());//10
		System.out.println(dtm1.getSecond());//41
		System.out.println(dtm1.getNano());//549000000
		//与plus和minus相关的方法它也全都有同名方法
		System.out.println(dtm1.plusDays(12));//2020-09-14T17:10:41.549
		System.out.println(dtm1.minusYears(12));//2008-09-02T17:10:41.549
		
		
		LocalDateTime d1 = LocalDateTime.of(2012, 2, 1, 4, 6 , 4);
		LocalDateTime d2 = LocalDateTime.of(2012, 2, 9, 4, 6 , 4);
		//用java.time.Duration类来算两个datetime的差值。计算时是用第二个参数d2-第一个参数d1。结果可能有正有负
		Duration dn = Duration.between(d1, d2);
		System.out.println(dn.toDays());//8
		System.out.println(dn.toHours());//192
		
	}

}
