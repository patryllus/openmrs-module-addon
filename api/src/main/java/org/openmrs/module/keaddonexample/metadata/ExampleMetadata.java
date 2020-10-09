/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.keaddonexample.metadata;

import org.openmrs.PatientIdentifierType;
import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.*;

/**
 * Example metadata bundle
 */
@Component
public class ExampleMetadata extends AbstractMetadataBundle {

	public static String swop_concept = "160550AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	public static class _EncounterType {
		public static final String EXAMPLE = "d69dedbd-3933-4e44-8292-bea939ce980a";
		public static final String SOCIAL_WORK = "4fc436f4-9f3c-4f69-b60f-ad79dd114c47";
		public static final String SWOP_CLIENT_ENROLLMENT = "901018b4-5763-4118-a63a-97a00e79c990";
		public static final String SWOP_CLIENT_DISCONTINUATION = "e93ba5f0-e08c-49ab-b964-fa38f1056562";

	}

	public static class _Form {
		public static final String EXAMPLE = "b694b1bc-2086-47dd-a4ad-ba48f9471e4b";
		public static final String ADULT_SCREENING = "0640058c-aa3f-47d0-867b-3025f2e5f80d";
		public static final String SWOP_ENROLLMENT = "4c620970-1364-414f-99d3-496dd120cb4b";
		public static final String SWOP_COMPLETION = "cb62b9ab-d24a-4a52-aad2-84c2c7d79e5d";
	}

	public static final class _PatientIdentifierType {

		public static final String SWOP_NUMBER = "1dee27b7-0b92-49b3-978f-065e48f13560";

	}

	public static final class _Program {

		public static final String SWOP = "43b65fda-8c25-4478-a24c-bcc90e877f55";
	}

	/**
	 * @see org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {
		install(encounterType("Example encounter", "Just an example", _EncounterType.EXAMPLE));
		install(encounterType("Social Work", "Social Work Encounter", _EncounterType.SOCIAL_WORK));
		install(encounterType("Swop Enrollment", "Swop Enollment Encounter", _EncounterType.SWOP_CLIENT_ENROLLMENT));
		install(encounterType("Swop Discontinuation", "Swop Discontinuation Encounter", _EncounterType.SWOP_CLIENT_DISCONTINUATION));

		install(form("Example form", null, _EncounterType.EXAMPLE, "1", _Form.EXAMPLE));
		install(form("Social Work Adult Screening form", null, _EncounterType.SOCIAL_WORK, "1", _Form.ADULT_SCREENING));
		install(form("Swop Enrollment form", null, _EncounterType.SWOP_CLIENT_ENROLLMENT, "1", _Form.SWOP_ENROLLMENT));
		install(form("Swop Completion form", null, _EncounterType.SWOP_CLIENT_DISCONTINUATION, "1", _Form.SWOP_COMPLETION));

		install(program("Swop program", "Program for SWOP clients", swop_concept, _Program.SWOP));

		install(patientIdentifierType("SWOP unique Number", "Unique Number assigned to SWOP client upon enrollment", null, null,
				null, PatientIdentifierType.LocationBehavior.NOT_USED, false,
				_PatientIdentifierType.SWOP_NUMBER));

	}
}