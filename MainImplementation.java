package Com.Bridgelabz.Oops.Clinique;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class MainImplementation {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Scanner scan = new Scanner(System.in);

		Appointmgt a1 = new Appointmgt();
		Doctormgt d1 = new Doctormgt();
		Patientmgt p1 = new Patientmgt();
		System.out.println("-------------Doctors details---------");
		List<Doctor> doctlist = d1.readDoctfile();
		//System.out.println("gghhjj");
		for (Doctor doctor : doctlist) {
			System.out.println(
					"name of doctor is=" + doctor.getDoct_Name() + "\ndoctor id=" + doctor.getDoct_Id() + " \nspecialization="
							+ doctor.getDoct_Specialization() + " \navailability=" + doctor.getDoct_Availability());
		}
		System.out.println("=--------------patient details----------------");
		List<Patient> patientlist = p1.readpatientfile();
		for (Patient patient : patientlist) {
			System.out.println("patient name=" + patient.getPatient_name() + " \npatient id=" + patient.getPatient_id()
					+ " \npatient age=" + patient.getPatient_Age() + " \npatient mobile number="
					+ patient.getPatient_Mobileno());
		}
		int ch=0;
		System.out.println("------------------Clinique information---------------------");
		do {
			System.out.println("enter your choice");
			
			
		System.out.println("1.add doctor \n2.add patient \n3.searcdoctor by name\n4.search patient by name\n5search doctor by id\n6.search patient by id\n7.take appointment");
		int choice=scan.nextInt();
		switch(choice)
		{
		case 1:
			List<Doctor>add=d1.readDoctfile();
			List<Doctor>added=d1.addDoctor(add);
			d1.writeDoctFile(added);
			break;
		case 2:
			List<Patient>addp=p1.readpatientfile();
			List<Patient>addedp=p1.addPatient(addp);
			p1.writepatientFile(addedp);
			break;
		case 3:
			List<Doctor>search1=d1.readDoctfile();
			List<Doctor>search=d1.SearchByname(search1);
			//d1.writeDoctFile(search);
			break;
		case 4:
			List<Patient>searchp=p1.readpatientfile();
	           p1.SearchpatientByname(searchp);
			
			break;
		case 5:
			List<Doctor>searchid=d1.readDoctfile();
			List<Doctor>searchedid=d1.searchById(searchid);
			break;
		case 6:
			List<Patient>searchpid=p1.readpatientfile();
			p1.Searchpatientid(searchpid);;
			break;
		case 7:
			
			List<Doctor>doctapp=d1.readDoctfile();
			List<Appointment>takeapp=a1.readappointmentfile();
			List<Appointment>getappointment=d1.takeappointmen(takeapp, doctapp);
			a1.writeappoitmentFile(getappointment);
			break;
			
			default:
				System.out.println("you have entered wrong choice");
				
		
		}
		

	}while(ch==0);
	}
}
