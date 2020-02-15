/**
 * 
 */
package cl.liberty.dao;

import java.util.List;

import cl.liberty.model.Contractor;
import cl.liberty.request.ContractorRequest;

/**
 * @author jgarrido
 *
 */
public interface ContractorDao {

	public List<Contractor> getContractors();

	public Contractor getContractor(Integer contractorCode);

	public Contractor getContractorByCode(Integer contractorCode);

	public void addContractor(ContractorRequest contractorRequest);

	public void editContractor(ContractorRequest contractorRequest);

	public void deleteContractor(Integer contractorCode);

	public boolean validateContractorExist(Integer contractorCode);

}
