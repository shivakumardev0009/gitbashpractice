package com.hms.genericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * @author Dev
	 * this method is used to append / generate random number upto 1000 range .. rang can be extended
	 * @return
	 */
	public int getRandomNo()
	{
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	/**
	 * to get system date
	 * @author Dev
	 * @return
	 */
	public String getSystemDate() {
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	/**
	 * to get system date in required format 
	 * @author Dev
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		String date = dateFormat.format(dt);
		return date;
	}

}
