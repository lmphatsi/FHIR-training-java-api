package ca.uhn.fhir.example;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.Patient;

public class Example07_ClientReadAndUpdate {
	public static void main(String[] theArgs) {
		// Create a client
		FhirContext ctx = FhirContext.forR4();
		IGenericClient client = ctx.newRestfulGenericClient("http://hapi.fhir.org/baseR4");

		Patient pat = client.read().resource(Patient.class).withId("1555106").execute();

		System.out.println(ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(pat));

		/*
		 * Patient patient = new Patient();
		 * patient.setId("Patient/example"); // Give the patient an ID
		 * patient.addName().setFamily("Simpson").addGiven("Homer");
		 * patient.setGender(Enumerations.AdministrativeGender.MALE);
		 * 
		 * // Update the patient
		 * MethodOutcome outcome = client
		 * .update()
		 * .resource(patient)
		 * .execute();
		 * 
		 * System.out.println("Now have ID: " + outcome.getId());
		 */
	}
}
