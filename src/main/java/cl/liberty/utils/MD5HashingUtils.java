/**
 * 
 */
package cl.liberty.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

/**
 * @author jgarrido
 *
 */
public class MD5HashingUtils {

	private MD5HashingUtils() {
		super();
	}

	/**
	 * Encripta la password y genera un hash
	 * 
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encrypt(String password) throws NoSuchAlgorithmException {
		String passwordEncripted = null;
		if (StringUtils.isNotBlank(password)) {

			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte[] byteData = md.digest();

			// convert the byte to hex format method 1
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			passwordEncripted = sb.toString();
		}
		return passwordEncripted;

	}

	/**
	 * Comnpara 2 passwords para determinar si la no encriptada genera el mismo
	 * hash de la encriptada
	 * 
	 * @param passwordNonEncripted
	 * @param passwordEncripted
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean compare(String passwordNonEncripted, String passwordEncripted)
			throws NoSuchAlgorithmException {
		if (StringUtils.isNotBlank(passwordNonEncripted) && StringUtils.isNotBlank(passwordEncripted)) {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			md.update(passwordNonEncripted.getBytes());

			byte[] byteData = md.digest();

			// convert the byte to hex format method 1
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			String passwordGenerated;

			passwordGenerated = sb.toString();

			return passwordEncripted.equals(passwordGenerated);
		}
		return false;
	}

}
