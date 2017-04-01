package com.bitwise.magnolia.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;

import com.bitwise.magnolia.model.user.User;


public class Utils {

	private static final Random RANDOM = new SecureRandom();
    
    private static final int PASSWORD_LENGTH = 8;
    
    private static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    private static Map<String, String> courseTypes = new TreeMap<String, String>();
    
    private static Map<String, String> statuses = new TreeMap<String, String>();
    
    private static Map<String, String> optionalityTypes = new TreeMap<String, String>();
    
    private static Map<String, String> partTypes = new TreeMap<String, String>();
    
    private static Map<Integer, String> levels = new TreeMap<Integer, String>();
    
    private static Map<String, String> questions = new TreeMap<String, String>();
    
    private static Map<String, String> sexes = new TreeMap<String, String>();

    private static Map<String, String> titles = new TreeMap<String, String>();
    
    private static Map<String, String> endReasons = new TreeMap<String, String>();
    
    private static Map<Double, String> units = new TreeMap<Double, String>();
	
	
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
	
	 public static String generateRandomPassword() {
	        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+#@";
	        
	        String pw = "";
	        
	        for (int i = 0; i < PASSWORD_LENGTH; i++) {
	            int index = (int) (RANDOM.nextDouble()*letters.length());
	            pw += letters.substring(index, index+1);
	        }
	        return pw;
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
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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
	
	public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
	
	public boolean hasMatchingUUID(User account, String oneTimeToken) {
        boolean userTokenValid = account != null && account.getOneTimeToken() != null && UUID_PATTERN.matcher(account.getOneTimeToken()).matches();
        boolean matchingTokenValid = oneTimeToken != null && UUID_PATTERN.matcher(oneTimeToken).matches();
        return userTokenValid && matchingTokenValid && account.getOneTimeToken().equals(oneTimeToken);
    }
	
	public static Map<String, String> listOfEnrolmentTypes() {
		courseTypes.put("ON", "ONLINE");
		courseTypes.put("OF", "OFFLINE");
		
		return courseTypes;
	}
	
	public static Map<String, String> getEnrolmentTypes() {
		for (String option : listOfEnrolmentTypes().values()) {
			System.out.println(option);
		}
		return courseTypes;
	}
	
	public static Map<String, String> listOfStatuses() {
		statuses.put("active", "ACTIVE");
		statuses.put("inactive", "INACTIVE");
		statuses.put("pending", "PENDING");
		statuses.put("completed", "COMPLETED");
		
		return statuses;
	}
	
	public static Map<String, String> getStatuses() {
		for (String option : listOfStatuses().values()) {
			System.out.println(option);
		}
		return statuses;
	}
	
	public static Map<String, String> listOfOptionalities() {
		optionalityTypes.put("MA", "MANDATORY");
		optionalityTypes.put("OP", "OPTIONAL");
		
		return optionalityTypes;
	}
	
	public static Map<String, String> getOptionalities() {
		for (String option : listOfOptionalities().values()) {
			System.out.println(option);
		}
		return optionalityTypes;
	}
	
	public static Map<String, String> listOfPartTypes() {
		partTypes.put("ON", "ONLINE");
		partTypes.put("OC", "ON-CAMPUS");
		
		return partTypes;
	}
	
	public static Map<String, String> getPartTypes() {
		for (String option : listOfPartTypes().values()) {
			System.out.println(option);
		}
		return partTypes;
	}
	
	public static Map<Integer, String> listOfLevels() {
		levels.put(100, "100");
		levels.put(200, "200");
		levels.put(300, "300");
		levels.put(400, "400");
		levels.put(500, "500");
		levels.put(600, "600");
		levels.put(700, "700");
		return levels;
	}
	
	public static Map<Integer, String> getLevels() {
		for (String level : listOfLevels().values()) {
			System.out.println(level);
		}
		return levels;
	}
	
	public static Map<String, String> listOfQuestions() {
		questions.put("Q1", "What is your mother's maiden name?");
		questions.put("Q2", "What is the name of your first dog?");
		questions.put("Q3", "What is the color of your building?");
		questions.put("Q4", "What is your favorite dish?");
		questions.put("Q5", "At what age did you graduate secondary school?");
		
		return questions;
	}
	
	public static Map<String, String> getQuestions() {
		for (String question : listOfQuestions().values()) {
			System.out.println(question);
		}
		return questions;
	}
	
	public static Map<String, String> listOfSexes() {
		sexes.put("MALE", "Male");
		sexes.put("FEMALE", "Female");
		return sexes;
	}
	
	public static Map<String, String> getSexes() {
		for (String sex : listOfSexes().values()) {
			System.out.println(sex);
		}
		return sexes;
	}
	
	public static Map<String, String> listOfTitles() {
		titles.put("MR", "Mr");
		titles.put("MS", "Mrs");
		titles.put("MI", "Miss");
		titles.put("DR", "Dr");
		titles.put("EG", "Engr");
		titles.put("BR", "Barr");
		titles.put("PR", "Prof");
		return titles;
	}
	
	public static Map<String, String> getTitles() {
		for (String title : listOfTitles().values()) {
			System.out.println(title);
		}
		return titles;
	}
	
	public static Map<String, String> listOfEndReasons() {
		endReasons.put("R1", "None");
		endReasons.put("R2", "Finacial");
		endReasons.put("R3", "Expulsion");
		endReasons.put("R4", "Medical");
		endReasons.put("R5", "Failure");
		endReasons.put("R6", "Transfer");
		return endReasons;
	}
	
	public static Map<String, String> getEndReasons() {
		for (String reason : listOfEndReasons().values()) {
			System.out.println(reason);
		}
		return endReasons;
	}
	
	public static Map<Double, String> listOfUnits() {
		units.put(1.0, "1");
		units.put(2.0, "2");
		units.put(3.0, "3");
		units.put(4.0, "4");
		units.put(5.0, "5");
		units.put(6.0, "6");
		units.put(7.0, "6");
		units.put(8.0, "6");
		units.put(9.0, "6");
		return units;
	}
	
	public static Map<Double, String> getUnits() {
		for (String unit : listOfUnits().values()) {
			System.out.println(unit);
		}
		return units;
	}
}
