package componente;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class MapperVideosXMLtoJava {

	public static Videos cargarVideos(String fichero) {

		JAXBContext jc;
		Videos video = null;
		try {
			jc = JAXBContext.newInstance("componente");
			Unmarshaller u = jc.createUnmarshaller();
			File file = new File(fichero);
			video = (Videos) u.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
		return video;
	}
}
