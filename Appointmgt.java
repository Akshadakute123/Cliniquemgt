package Com.Bridgelabz.Oops.Clinique;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class Appointmgt 
{
	ObjectMapper objectmapper=new ObjectMapper();
	File file1=new File("/home/admin1/Akshada/OopsProject/src/Com/Bridgelabz/Oops/Clinique/Appointment.json");
	
	public List<Appointment> readappointmentfile() throws JsonParseException, JsonMappingException, IOException {
		List<Appointment> appointmentlist = objectmapper.readValue(file1, new TypeReference<List<Doctor>>() {
		});
		return appointmentlist;
		
	}
	@SuppressWarnings("deprecation")
	public void writeappoitmentFile(List<Appointment>appointmentlist) throws JsonGenerationException, JsonMappingException, IOException
	{
		objectmapper.defaultPrettyPrintingWriter().writeValue(file1, appointmentlist);
		//objectmapper.defaultPrettyPrintingWriter().writeValue(file, appointmentlist);
	}
	
}
