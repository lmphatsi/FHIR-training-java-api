package ca.uhn.fhir.example;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;

/*import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Patient;*/

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.BaseParser.EncodeContext;

public class Example01_CreateAPatient {
	public static void main(String[] theArgs) {

		FhirContext fhirContext = FhirContext.forR4();
		// Create a resource instance
		Patient pat = new Patient();
		pat.setId("test ID");
		pat.setActive(true);
		pat.setGender(AdministrativeGender.MALE);
		pat.addIdentifier().setSystem("http://identity_system_1").setValue("SYS1_00001");
		pat.addIdentifier().setSystem("http://identity_system_2").setValue("SYS2_00001");
		pat.addName().setFamily("Thakalekoala").addGiven("Thabo").addGiven("Anthony");

		// pat.addExtension().setUrl("http://politicalParty").setValue("Sefofane");

		/*
		 * // Alternative
		 * List<Identifier> ids = new ArrayList<>();
		 * Identifier id1 = new Identifier();
		 * id1.setSystem("http://system_3");
		 * id1.setValue("ID000001");
		 * Identifier id2 = new Identifier();
		 * id2.setSystem("http://system_4");
		 * id2.setValue("ID0000034");
		 * ids.add(id1);
		 * ids.add(id2);
		 * 
		 * pat.setIdentifier(ids);
		 */
		System.out.println(fhirContext.newJsonParser().setPrettyPrint(true).encodeResourceToString(pat));

		/*
		 * // Add a "name" element
		 * HumanName name = pat.addName();
		 * name.setFamily("Simpson").addGiven("Homer").addGiven("J");
		 * 
		 * // Add an "identifier" element
		 * Identifier identifier = pat.addIdentifier();
		 * identifier.setSystem("http://acme.org/MRNs").setValue("7000135");
		 * 
		 * // Model is designed to be chained
		 * pat.addIdentifier().setSystem("http://acme.org/MRNs").setValue("12345");
		 */

	}
}
