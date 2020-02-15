/**
 * 
 */
package cl.liberty.services;

import cl.liberty.response.LoginResponse;

/**
 * @author jgarrido
 *
 */
public interface LoginService {

	LoginResponse login(String userName);

}
