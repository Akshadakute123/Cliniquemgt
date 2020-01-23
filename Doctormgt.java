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

public class Doctormgt {
	Doctor doctor = new Doctor();
	Patient patient = new Patient();
	Appointment appointment = new Appointment();
	static Scanner scan = new Scanner(System.in);
	static ObjectMapper objectmapper = new ObjectMapper();
	File file = new File("/home/admin1/Akshada/OopsProject/src/Com/Bridgelabz/Oops/Clinique/Doctors.json");

	public List<Doctor> addDoctor(List<Doctor> doctlist) {
		System.out.println("enter the name of Doctor");
		doctor.setDoct_Name(scan.next());
		System.out.println("enter the doctor id");
		doctor.setDoct_Id(scan.nextInt());
		System.out.println("enter the doctor specialization");
		doctor.setDoct_Specialization(scan.next());
		System.out.println("enter the timming");
		doctor.setDoct_Availability(scan.next());
		doctlist.add(doctor);
		return doctlist;

	}

	public List<Doctor> readDoctfile() throws JsonParseException, JsonMappingException, IOException {
		//System.out.println("kjii");
		List<Doctor> doctlist = objectmapper.readValue(new File("/home/admin1/Akshada/OopsProject/src/Com/Bridgelabz/Oops/Clinique/Doctors.json"), new TypeReference<List<Doctor>>() {
		});
		//System.out.println("hhhjhh");
		return doctlist;

	}
	@SuppressWarnings("deprecation")
	public void writeDoctFile(List<Doctor>doctlist) throws JsonGenerationException, JsonMappingException, IOException
	{
		objectmapper.defaultPrettyPrintingWriter().writeValue(file, doctlist);
	}
	
	public  static List<Doctor>SearchByname(List<Doctor>doctlist)
	{
		for (int i = 0; i < doctlist.size(); i++) {
			System.out.println(doctlist.get(i).getDoct_Name());
		}
		System.out.println("enter thsee name of doctor");
		String newDoctNme=scan.next();
		for (Doctor doctor : doctlist)
		{
			if(doctor.getDoct_Name().equalsIgnoreCase(newDoctNme))
			{
				System.out.println("available timming  \t"+doctor.doct_Availability+"\nspecialization\t"+doctor.doct_Specialization+" \nDoctor id\t"+doctor.getDoct_Id());
			}
		}
		return doctlist;
	}
	public List<Doctor>searchById(List<Doctor>doctlist)
	{
		for (int i = 0; i < doctlist.size(); i++)
		{
		System.out.println(doctlist.get(i).getDoct_Id()+" ");	
		}
		System.out.println("enter the id of doctor which you want to search");
		int newid=scan.nextInt();
		for (Doctor doctor : doctlist) 
		{
			if(doctor.getDoct_Id()==newid) {
				System.out.println("Doctor name"+doctor.getDoct_Name()+"\n "+"specialization"+doctor.getDoct_Specialization()+" \nAvailability"+doctor.getDoct_Availability());
			}
		}
		return doctlist;
	}
	public static  boolean numberOfAppontment(List<Appointment>appointmentlist,List<Doctor>doctlist) throws JsonGenerationException, JsonMappingException, IOException
	{
		for (Doctor doctor : doctlist)
		{
			System.out.println(doctor.getDoct_Name()+" ");
			
		}
		for (int i = 0; i < appointmentlist.size(); i++) 
		{
			if(appointmentlist.get(i).getDoctor_appointment()<=5) 
			{
				int appointments=appointmentlist.get(i).getDoctor_appointment();
				appointments=appointments+1;
				appointmentlist.get(i).setDoctor_appointment(appointments);
			 // objectmapper.writeValue(New File(""), value);
				objectmapper.writeValue(
new File("/home/admin1/Akshada/OopsProject/src/Com/Bridgelabz/Oops/Clinique/Appointment.json "), appointments);
			System.out.println("appointment available");
			return true;
			}
			else
			{
				System.out.println("appoitnment not available");
				return false;
			}
		}
		return true;
	}
	public List<Appointment> takeappointmen(List<Appointment>appointmentlist,List<Doctor>doctlist) throws JsonGenerationException, JsonMappingException, IOException
	{
		System.out.println("available doctors");
		Doctormgt.SearchByname(doctlist);
		if(Doctormgt.numberOfAppontment(appointmentlist, doctlist))
		{
			System.out.println("enter patient name");
			appointment.setPatient_name(scan.next());
			System.out.println("enter doctor name");
			appointment.setDoct_name(scan.next());
			System.out.println("enter doctors specilization");
			appointment.setSpecialization(scan.next());
			System.out.println("Availability of doctor");
			appointment.setTimming(scan.next());
			appointmentlist.add(appointment);
			System.out.println("appointment done");
		}
		else
		{
			System.out.println("sorry doctor not available meet tommorow");
		}
		return appointmentlist;
	}
}
