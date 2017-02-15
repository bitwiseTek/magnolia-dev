package com.bitwise.magnolia.dao.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.codec.binary.Base64;


public class Utils {

	
	
	/**
	 * <p>
	 * 	A helper method that generates a random string 
	 *  The length of the returned string is determined by the
	 *  len parameter passed to the method 
	 * </p>
	 * 
	 * @param len
	 * @return string
	 */
	public static String randomString(int len){
		String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		//sb.append(value + year);
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}
	
	/**
	 * <p>
	 * 	A Helper method that returns the year of the current Date instance
	 * </p>
	 * @return
	 */
	public static int currentYear(){
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int year = now.get(Calendar.YEAR);
		return year;
	}
	
	/**
	 * 
	 * @param imageByteArray
	 * @return
	 */
	public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64String(imageByteArray);
    }
	
	/**
	 * 
	 * @param filePath
	 * @param prefixBase64
	 * @return
	 */
	public static String convertFileToBase64(String filePath, String prefixBase64){
		String output = null;
		File file;
		FileInputStream imageInFile = null;
		try{
		   file = new File(filePath);
		   imageInFile = new FileInputStream(file);
		   byte imageData[] = new byte[(int) file.length()];
		   imageInFile.read(imageData);
	 
		   // Converting File byte array into Base64 String
		   String base64 = prefixBase64;
		   String base64Image = encodeImage(imageData);
		   output = base64 + base64Image;
		}
		catch(Exception e){
		   System.err.println(Utils.class.getSimpleName() + ": Error converting file to Base64");
		   e.printStackTrace();
		}
		finally{
			try {
				imageInFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	   return output;
		
	}
	
	/**
	 * Gets base64 string and saves it to a designated path
	 * The path is gotten for the combination of @see #ApplicationConstant and 
	 * ext parameter.. Ext parameter is used to identify the file locally on disk.
	 * Ext can be a unique identifier optionally followed by _photo or _image or _xls
	 * @param _base64
	 * @param schoolAlias
	 * @param ext
	 */
	public static String saveBase64ToPath(String _base64, String schoolAlias, String ext){
		String base64 = null;
		String sourceData = null;
		StringTokenizer tokenizer = new StringTokenizer(_base64, ",");
		while(tokenizer.hasMoreTokens()){
			base64 = tokenizer.nextElement().toString();
			sourceData = tokenizer.nextElement().toString();
		}

		String directory = ApplicationConstant.MAGNOLIA_PATH + schoolAlias + "/" + ext;
		try{
			byte[] imageByteArray = Base64.decodeBase64(sourceData);
			FileOutputStream imageOutFile = new FileOutputStream(directory);
 
            imageOutFile.write(imageByteArray);
            imageOutFile.close();
            imageOutFile.flush();
 
            System.out.println("File Successfully Manipulated! " + Utils.class.getSimpleName());
		}
		catch(Exception e){
			System.out.println("File Creation was unsuccessful! " + Utils.class.getSimpleName());
		}
		return base64;
	}
	
	/**
	 * <p>
	 * 	A helper method that checks the difference between two date
	 *  An endDate parameter is accepted, hoping to be greater than the current system date which 
	 *  is compare with with the system current date and the difference returned
	 * </p>
	 * @param endDate
	 * @return
	 */
	public static long remainingDays(String endDate){
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
        String strDate = format.format(cal.getTime());
		Date d1 = null;
		Date d2 = null;
		long dateDiff = 0;
		try{
			d1 = format.parse(endDate);
			d2 = format.parse(strDate);
			long diff = d2.getTime() - d1.getTime();
			
			dateDiff = diff / (24 * 60 * 60 * 1000);
		}
		catch(Exception e){
			
		}
		return dateDiff;
	}
	
	/**
	 * <p>
	 * 	A helper method that generates a custom random string 
	 *  The length of the returned string is determined by the
	 *  len parameter passed to the method 
	 * </p>
	 * 
	 * @param len
	 * @return string
	 */
	public static String getCustomString(int len, String schoolAlias ){
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int year = now.get(Calendar.YEAR);
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		if(schoolAlias.isEmpty())
			sb.append(year);
		else
			sb.append(schoolAlias + year);
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}
	
	
	
}
