/**
 * 
 */
package cl.liberty.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.liberty.constantes.Constantes;
import cl.liberty.dao.LogDao;
import cl.liberty.model.Wallet;
import cl.liberty.request.LogRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.services.LogService;
import cl.liberty.services.WalletService;

/**
 * @author jgarrido
 *
 */

@Repository
public class LogServiceImpl implements LogService {

	private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

	@Autowired
	private LogDao logDao;
	
	@Autowired
	private WalletService walletService;

	@Override
	@Transactional(readOnly = false)
	public OperationResponse addLog(LogRequest logRequest) {
		OperationResponse result = new OperationResponse();
		try {
			
			if(logRequest.getPolicyNumber() != -1) {
				Wallet wallet = walletService.getWallet(logRequest.getPolicyNumber(), -1, -1, "-1");
				if(wallet != null) {
					logRequest.setWalletId(wallet.getWalletId());
				} 
			}  else {
				logRequest.setWalletId(-1);
			}
			
			logDao.addLog(logRequest);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Log registrado exitosamente");
		} catch (Exception e) {
			logger.error("Error inesperado", e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al registrar log");
		}
		return result;
	}

}
