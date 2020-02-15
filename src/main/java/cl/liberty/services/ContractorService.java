/**
 * 
 */
package cl.liberty.services;

import java.util.List;

import cl.liberty.model.Contractor;
import cl.liberty.request.ContractorRequest;
import cl.liberty.response.OperationResponse;

/**
 * @author jgarrido
 *
 */
public interface ContractorService {

	public List<Contractor> getContractors();

	public OperationResponse addContractor(ContractorRequest contractorAddRequest);

	public OperationResponse deleteContractor(Integer contractorCode);

	public boolean validateContractorExist(Integer contractorCode);

}
