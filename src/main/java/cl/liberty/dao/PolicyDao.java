/**
 * 
 */
package cl.liberty.dao;

import java.util.List;

import cl.liberty.model.Policy;
import cl.liberty.model.PolicyCoverage;

/**
 * @author jgarrido
 *
 */
public interface PolicyDao {

	public Policy getPolicy(int policyNumber, int branchNumber);

	public List<Policy> getPolicys(int policyNumber, int branchNumber);

	public List<Policy> getPolicyNonMortgages(int policyNumber);

	public List<PolicyCoverage> getPolicyCoverages(int policyNumber, int branchNumber, int idPadre);

}
