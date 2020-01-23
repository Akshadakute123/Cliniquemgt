package Com.Bridgelabz.Oops.Clinique;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class Patientmgt
{
	Patient patient=new Patient();
	static Scanner scan=new Scanner(System.in);
	ObjectMapper objectmapper =new ObjectMapper();
	File file2=new File("/home/admin1/Akshada/OopsProject/src/Com/Bridgelabz/Oops/Clinique/Patients.json");
	public List<Patient> addPatient(List<Patient> patientlist)
	{
		System.out.println("enter the name of patient");
		patient.setPatient_name(scan.next());
		System.out.println("enter the id of patient");
		patient.setPatient_id(scan.nextInt());
		System.out.println("enter the mobile number of patient");
		patient.setPatient_Mobileno(scan.nextLong());
		System.out.println("enter the age o f patient");
		patient.setPatient_Age(scan.nextInt());
		patientlist.add(patient);
		return patientlist;
	}

	public List<Patient> readpatientfile() throws JsonParseException, JsonMappingException, IOException {
		List<Patient> patientlist = objectmapper.readValue(file2, new TypeReference<List<Patient>>() {
		});
		return patientlist;

	}
	@SuppressWarnings("deprecation")
	public void writepatientFile(List<Patient>patientlist) throws JsonGenerationException, JsonMappingException, IOException
	{
		objectmapper.defaultPrettyPrintingWriter().writeValue(file2, patientlist);
	}
	
	public  static void SearchpatientByname(List<Patient>patientlist)
	{
		for (int i = 0; i < patientlist.size(); i++) {
			System.out.println(patientlist.get(i).getPatient_name());
		
		}
		System.out.println("enter thsee name of patient to seasrch");
		String newpatientNme=scan.next();
		for (Patient patient : patientlist) {
			if(patient.getPatient_name().equalsIgnoreCase(newpatientNme))
			{
				System.out.println(patient.getPatient_Age()+" "+patient.getPatient_id()+" "+patient.getPatient_Mobileno());
			}
		}
		//System.out.println("patient name is not found in list");
		//return patientlist;
	
		
	}
	public  static void Searchpatientid(List<Patient>patientlist)
	{
		for (int i = 0; i < patientlist.size(); i++) {
			System.out.println(patientlist.get(i).getPatient_id());
		
		}
		System.out.println("enter thsee id of patient to seasrch");
		int newpatientid=scan.nextInt();
		for (Patient patient : patientlist) {
			if(patient.patient_id==newpatientid)
			{
				System.out.println(patient.getPatient_Age()+" "+patient.getPatient_name()+" "+patient.getPatient_Mobileno());
			}
		}
		//System.out.println("patient id is not found in list");
		//return patientlist;
	
		
	}

}
