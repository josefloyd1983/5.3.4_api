/**
 * 
 */
package cl.liberty.services;

import cl.liberty.request.LogRequest;
import cl.liberty.response.OperationResponse;

/**
 * @author jgarrido
 *
 */
public interface LogService {

	public OperationResponse addLog(LogRequest logRequest);

}
