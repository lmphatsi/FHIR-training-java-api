package ca.uhn.fhir.example;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Bundle.BundleType;
import org.hl7.fhir.r4.model.Bundle;

public class Example06_ClientCreate {
	public static void main(String[] theArgs) {
		// Obs.setStatusElement();

		// Patient resource
		Patient pat = new Patient();
		pat.setId("B-10");
		pat.addName().setFamily("Ntota").addGiven("Matsie2").addGiven("J");
		pat.addIdentifier().setSystem("http://Home affairs Lesotho").setValue("7000135BBB");
		pat.setGender(AdministrativeGender.MALE);

		// Observation resource
		Observation Obs = new Observation();
		Obs.setSubject(new Reference("Patient/B-10"));
		Obs.setId("obs-id");
		Obs.setStatus(ObservationStatus.AMENDED);
		Obs.setCode(new CodeableConcept().setText("The coding"));

		// Bundle
		Bundle bundle = new Bundle();
		bundle.setType(BundleType.TRANSACTION);
		bundle.addEntry().setResource(pat).getRequest().setUrl("Patient/B-10").setMethod(Bundle.HTTPVerb.PUT);

		bundle.addEntry().setResource(Obs).getRequest().setUrl("Observation/obs-id").setMethod(Bundle.HTTPVerb.PUT);

		// Create a context
		FhirContext ctx = FhirContext.forR4();

		// Create a client
		String serverBaseUrl = "http://18.116.237.4:8080/fhir";
		IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);

		// Use the client to store a new resource instance
		/*
		 * MethodOutcome outcome = client
		 * // .create()
		 * .update()
		 * .resource(pat)
		 * .withId("B-10")
		 * .execute();
		 */

		Bundle responce = client.transaction().withBundle(bundle).execute();
		// Print the ID of the newly created resource
		// System.out.println(outcome.getId());
		System.out.println(ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(responce));

	}
}
