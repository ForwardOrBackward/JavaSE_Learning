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
		//Calendar���getTime()�������ص���java.util.Date���͵Ķ���
		System.out.println(c.getTime());//Wed Sep 02 14:41:12 CST 2020
		//��Calendar��ķ�������������ա�ע���·�Ҫ+1.
		System.out.println(c.get(Calendar.YEAR)); //2020
		System.out.println(c.get(Calendar.MONTH) + 1); //9
		System.out.println(c.get(Calendar.DATE)); //2
		//����ʱ��ļӼ�������(Ҫ���б䶯�ı���,�仯����С) (�仯��������ǰ��һ���������ʾ��)
		c.add(Calendar.YEAR, -10);
		System.out.println(c.getTime());//Thu Sep 02 14:47:56 CST 2010
		//�������������ۼ�ʱ���Զ����㵽��Ӧ��������,����������볣ʶ��ֵ���·ݱ�Ϊ19��
		c.add(Calendar.MONTH, 10);
		System.out.println(c.getTime());//Sat Jul 02 14:47:56 CST 2011
		//���������Ҫ��ʽ����������Ҫ�����ӵĻ�����Ҫ�õ�ǰ��ĸ�ʽ���İ취
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		System.out.println(df.format(c.getTime()));//2011-07-02 02:58:00.374
				
		//�������ں�ʱ��
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		//��set���������ա�(ע��5�������6��)
		c1.set(2012, 5, 6); 
		System.out.println(df.format(c1.getTime()));//2012-06-06 03:07:26.033
		c2.set(2014, 7, 7);
		System.out.println(df.format(c2.getTime()));//2014-08-07 03:07:26.033
		//��before���Ƚϵ�ǰ�����Ƿ��ڲ�������֮ǰ
		System.out.println(c1.before(c2));//true
		System.out.println(c1.after(c2));//false
		//---------------------------JDK8.0-----java.time-----------------------------
		
		//LocalDate��������
		//now()������õ�ǰϵͳ����
		LocalDate ldt1 = LocalDate.now();
		System.out.println(ldt1);//2019-01-02
		//of()���������Լ�ָ�����ڡ�����(��,��,��)
		LocalDate ldt = LocalDate.of(2012, 2, 1);  
		System.out.println(ldt);//2012-02-01
		//�������������»����յķ�����
		System.out.println(ldt.getYear());//2012
		System.out.println(ldt.getMonthValue());//2��ע�ⲻ��getMonth()��
		System.out.println(ldt.getMonth());//FEBRUARY��getMonth()�õ�����һ��Month��Ķ���
		System.out.println(ldt.getDayOfMonth());//1����õ���һ�����еĵڼ���
		System.out.println(ldt.getDayOfYear());//32����õ���һ�����еĵڼ���
		System.out.println(ldt.getDayOfWeek().getValue());//3����������,��õ���һ�������еĵڼ���
		//plusYears()������ʾ��ԭ�����ڵĻ����ϼӶ����ꡣ��Ӧ�Ļ���plusDays()��plusMonths()��plusWeeks()
		System.out.println(ldt.plusYears(10));//2022-02-01
		//Ҳ�����ø�����Ϊ����
		System.out.println(ldt.plusMonths(-10));//2011-04-01
		//minusMonths()��ʾ������ԭ�����ڵĻ����ϼ������¡�ע��������������ǵȼ۵�
		System.out.println(ldt.minusMonths(10));//2011-04-01
		
		//LocalTime��ʱ���ࡣ�����������LocalDate����
		//now()������õ�ǰϵͳʱ��
		LocalTime ltime = LocalTime.now();
		System.out.println(ltime);//15:45:06.945
		//of()���������Լ�ָ��ʱ�䡣����(ʱ,��,��)��
		LocalTime ltime1 = LocalTime.of(12, 2, 45);
		System.out.println(ltime1);//12:02:45
		//of()���������Լ�ָ��ʱ�䡣��һ�����ؿ���������һ������,����(ʱ,��,��,����)��(ע�������벻�Ǻ���)
		LocalTime ltime2 = LocalTime.of(12, 2, 45,222);		
		System.out.println(ltime2);//12:02:45.000000222��(ע��:1����=1000000����)
		//�������ʱ���֡��롢����ķ�����(û�к���)
		System.out.println(ltime.getHour());//15
		System.out.println(ltime.getMinute());//45
		System.out.println(ltime.getSecond());//6
		System.out.println(ltime.getNano());//945000000
		//plusHours()������ʾ��ԭ��ʱ��Ļ����ϼӶ���Сʱ����Ӧ�Ļ���plusMinutes()��plusSeconds()��plusNanos()
		System.out.println(ltime.plusHours(17));//08:45:06.945
		//minusMonths()��ʾ������ԭ��ʱ��Ļ����ϼ����ٷ��ӡ�
		System.out.println(ltime.plusMinutes(2));//15:47:06.945
		
		//LocalDateTime�����ں�ʱ����(������ܵ�LocalDate��LocalTime�ķ���������ͬ������)
		LocalDateTime dtm1 = LocalDateTime.now();
		System.out.println(dtm1);//2020-09-02T17:10:41.549
		//of()������LocalDateTime�����ж�������,�������ֲ�����(��,��,��,ʱ,��,��)
		LocalDateTime dtm2 = LocalDateTime.of(2011, 4, 5, 5, 6 , 5);
		System.out.println(dtm2);//2011-04-05T05:06:05
		//�ɵ�������ꡢ�¡��ա�ʱ���֡��롢����ȡ�
		System.out.println(dtm1.getYear());//2020
		System.out.println(dtm1.getMonthValue());//9
		System.out.println(dtm1.getDayOfMonth());//2
		System.out.println(dtm1.getHour());//17
		System.out.println(dtm1.getMinute());//10
		System.out.println(dtm1.getSecond());//41
		System.out.println(dtm1.getNano());//549000000
		//��plus��minus��صķ�����Ҳȫ����ͬ������
		System.out.println(dtm1.plusDays(12));//2020-09-14T17:10:41.549
		System.out.println(dtm1.minusYears(12));//2008-09-02T17:10:41.549
		
		
		LocalDateTime d1 = LocalDateTime.of(2012, 2, 1, 4, 6 , 4);
		LocalDateTime d2 = LocalDateTime.of(2012, 2, 9, 4, 6 , 4);
		//��java.time.Duration����������datetime�Ĳ�ֵ������ʱ���õڶ�������d2-��һ������d1��������������и�
		Duration dn = Duration.between(d1, d2);
		System.out.println(dn.toDays());//8
		System.out.println(dn.toHours());//192
		
	}

}
