package org.openmrs.module.keaddonexample.metadata;

import org.openmrs.api.UserService;
import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.bundle.Requires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.*;

/**
 * Implementation of access control to the app.
 */
@Component
@Requires(org.openmrs.module.kenyaemr.metadata.SecurityMetadata.class)
public class ExampleSecurityMetadata extends AbstractMetadataBundle {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	public static final class _Privilege {

		public static final String SWOP_MODULE_APP = "App: kenyaemrswop.home";

	}

	public static final class _Role {

		public static final String SWOP_CLINICIAN = "Swop clinician";

		public static final String APPLICATION_SWOP_MODULE = "Swop Module";

	}

	/**
	 * @see org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {

		install(privilege(_Privilege.SWOP_MODULE_APP, "Able to access Swop module features"));

		install(role(_Role.APPLICATION_SWOP_MODULE, "Can access Swop module App",
		    idSet(org.openmrs.module.kenyaemr.metadata.SecurityMetadata._Role.API_PRIVILEGES_VIEW_AND_EDIT),
		    idSet(_Privilege.SWOP_MODULE_APP)));

		install(role(_Role.SWOP_CLINICIAN, "Can access Swop module App",
		    idSet(org.openmrs.module.kenyaemr.metadata.SecurityMetadata._Role.API_PRIVILEGES_VIEW_AND_EDIT),
		    idSet(_Privilege.SWOP_MODULE_APP)));
	}
}
