/**
 * 
 */
package cl.liberty.services;

import java.util.List;

import cl.liberty.model.Policy;

/**
 * @author jgarrido
 *
 */
public interface PolicyService {

	public Policy getPolicy(int policyNumber, int branchNumber);

	public List<Policy> policyNonMortgages(Integer policyNumber, Integer idPadre);

	public List<Policy> policys(Integer policyNumber, Integer branchNumber, Integer idPadre);

}
