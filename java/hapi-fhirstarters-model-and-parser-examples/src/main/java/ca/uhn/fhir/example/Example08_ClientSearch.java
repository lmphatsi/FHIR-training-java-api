package ca.uhn.fhir.example;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;

import ca.uhn.fhir.context.FhirContext;

public class Example08_ClientSearch {
	public static void main(String[] theArgs) {
		FhirContext ctx = FhirContext.forR4();
		IGenericClient client = ctx.newRestfulGenericClient("http://18.116.237.4:8080/fhir");

		// Build a search and execute it
		Bundle response = client.search()
				.forResource(Patient.class)
				// .where(Patient.NAME.matches().value("Nairobi"))
				// .and(Patient.BIRTHDATE.before().day("2014-01-01"))
				// .count(100)
				.returnBundle(Bundle.class)
				.execute();

		// How many resources did we find?
		// System.out.println("Responses: " + response.getTotal());
		System.out.println(ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(response));

		// Print the ID of the first one
		// System.out.println("First response ID: " +
		// response.getEntry().get(0).getResource().getId());
	}
}
