package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


import PlanoDeSaude.PlanoDeSaude;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GravaLerPlanoDeSaude implements Serializable{
	private static final transient long serialVersionUID = 1L;
	private static final String xmlPlanoDeSaude = "planoDeSaude.xml";
	private static XStream xstream = new XStream();
	private static XStream xstream2 = new XStream(new DomDriver());
	
	public static void gravaPlanoDeSaude(List<PlanoDeSaude> listaDePlanoDeSaude) throws IOException {
		BufferedWriter writer1 = null;
		
		try {
			writer1 = new BufferedWriter(new FileWriter(xmlPlanoDeSaude));
			String listaPlano = xstream.toXML(listaDePlanoDeSaude);
	        writer1.write(listaPlano);
	        
		} catch (IOException e1) {
			//System.err.println(e1);
		} finally {
			writer1.close();
		}
				
	}
	
	@SuppressWarnings("unchecked")
	public static List<PlanoDeSaude> lerPlanoDeSaude(List<PlanoDeSaude> listaDePlanoDeSaude) throws IOException {
		BufferedReader read1 = null; 
		List<PlanoDeSaude> listaPlano = null;
		try {
			read1 = new BufferedReader(new FileReader(xmlPlanoDeSaude));
			listaPlano = (List<PlanoDeSaude>) xstream2.fromXML(read1);
			
		} catch (IOException e1) {
			//System.err.println(e1);
		} finally {
			read1.close();
		}
		return listaPlano;
	}

}
