/**
 * 
 */
package cl.liberty.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.liberty.constantes.Constantes;
import cl.liberty.constantes.Errores;
import cl.liberty.dao.PolicyDao;
import cl.liberty.dao.PropertyDao;
import cl.liberty.model.Coverage;
import cl.liberty.model.Policy;
import cl.liberty.model.PolicyCoverage;
import cl.liberty.model.Property;
import cl.liberty.services.PolicyService;
import cl.liberty.utils.UtilAMS;

/**
 * @author jgarrido
 *
 */

@Repository
public class PolicyServiceImpl implements PolicyService {

	private static final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

	@Autowired
	private PolicyDao policyDao;

	@Autowired
	PropertyDao propertyDao;

	@Override
	@Transactional
	public Policy getPolicy(int policyNumber, int branchNumber) {
		Policy result = new Policy();
		try {
			result = policyDao.getPolicy(policyNumber, branchNumber);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public List<Policy> policyNonMortgages(Integer policyNumber, Integer idPadre) {
		Policy policy = new Policy();
		List<Policy> result = new ArrayList<>();
		List<PolicyCoverage> policyCoverages = new ArrayList<>();
		List<Coverage> coverages = new ArrayList<>();
		try {
			result = policyDao.getPolicyNonMortgages(policyNumber);
			for (int i = 0; i < result.size(); i++) {
				policyCoverages = policyDao.getPolicyCoverages(result.get(i).getPolicyNumber(), -1, idPadre);
				result.get(i).setPolicyCoverages(policyCoverages);

				List<Property> propertys = propertyDao.getPropertys(Constantes.PROPERTY_ID_PADRE);
				for (int j = 0; j < propertys.size(); j++) {
					Coverage coverage = new Coverage();
					coverage.setCoverageCode(Integer.valueOf(propertys.get(j).getValue()));
					coverage.setCoverageName(propertys.get(j).getDescription());
					coverage.setCoverageUsing(UtilAMS.usingDescription(Integer.parseInt(propertys.get(j).getValue())));
					coverage.setCoverageCheck(policy.isPolicyCoverageCheck(policyCoverages,
							Integer.valueOf(propertys.get(j).getValue())));
					coverages.add(coverage);
				}
				result.get(i).setCoverages(coverages);
			}
		}  catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public List<Policy> policys(Integer policyNumber, Integer branchNumber, Integer idPadre) {
		Policy policy = new Policy();
		List<Policy> result = new ArrayList<>();
		List<PolicyCoverage> policyCoverages = new ArrayList<>();
		List<Coverage> coverages = new ArrayList<>();
		try {
			result = policyDao.getPolicys(policyNumber, branchNumber);
			for (int i = 0; i < result.size(); i++) {
				policyCoverages = policyDao.getPolicyCoverages(result.get(i).getPolicyNumber(), -1, idPadre);
				result.get(i).setPolicyCoverages(policyCoverages);
				result.get(0).setPolicyUsingId(UtilAMS.gettPolicyUsingId(policyCoverages));

				List<Property> propertys = propertyDao.getPropertys(Constantes.PROPERTY_ID_PADRE);
				for (int j = 0; j < propertys.size(); j++) {
					Coverage coverage = new Coverage();
					coverage.setCoverageCode(Integer.valueOf(propertys.get(j).getValue()));
					coverage.setCoverageName(propertys.get(j).getDescription());
					coverage.setCoverageUsing(UtilAMS.usingDescription(Integer.parseInt(propertys.get(j).getValue())));
					coverage.setCoverageCheck(policy.isPolicyCoverageCheck(policyCoverages,
							Integer.valueOf(propertys.get(j).getValue())));
					coverages.add(coverage);
				}
				result.get(i).setCoverages(coverages);
			}
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

}
