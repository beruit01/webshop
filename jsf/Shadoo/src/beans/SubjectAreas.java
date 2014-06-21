package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SubjectAreas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static boolean init = false;
	
	private static List<String> areas = new ArrayList<String>();
	
	private static Comparator<String> compName = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			
			return o1.compareTo(o2);
		}
		
	};
	

	private SubjectAreas() {
		
		if( !init ) {
			
			init = true;

			areas.add("Auto");
			areas.add("Biologie");
			areas.add("Esotherik");
			areas.add("Computer");
			areas.add("Informatik");
			areas.add("Elektronik");
			areas.add("HiFi");
			areas.add("Hochzeit");
			areas.add("Filme & DVDs");
			areas.add("Musik");
			areas.add("Sport");
			areas.add("Kunst");
			areas.add("Geschichte");
			areas.add("Politik");
			areas.add("Mathematik");
			areas.add("Sprachen");
			areas.add("Garten");
			areas.add("Kochen");
			areas.add("Reisen");
			areas.add("Do-it-yourself");
			areas.add("Tanzen");
			areas.add("Fotos");
			areas.add("Poesie");
			areas.add("Abenteuer");
			areas.add("Gesundheit");
			areas.add("Medizin");
			areas.add("Apps");
			areas.add("Bücher");
			areas.add("Digitales");
			areas.add("Motorrad");
			areas.add("Kleidung");
			
			areas.add("Aeins");
			areas.add("AlleJahreWieder");
			areas.add("AbisZ");
			areas.add("AchNochWas");
			areas.add("Aenderung");
			areas.add("Aeehm");
					
		}
		
	}
	
	
	/**
	 * @return A list with all subject areas.
	 */
	public List<String> getAreas() {
		sortList( areas, compName );
		return areas;
	}
	
	/**
	 * @return A list with lists grouped by the first letter of the subject area.
	 */
	public List<Map.Entry<Character, List<String>>> getAreasGroupedByName() {
		
		Map<Character, List<String>> map = new TreeMap<Character, List<String>>();
		
		// add areas to has map grouped by first character
		for (String string : areas) {
		    
			Character firstCharacter = string.toLowerCase().charAt(0);

		    if (map.containsKey(firstCharacter)) {
		    	map.get(firstCharacter).add(string);
		    } else {
		    	List<String> newList = new ArrayList<String>();
		    	newList.add(string);
		    	map.put(firstCharacter, newList );
		    }
		}
		
		// parse hash map to list because JSF ui:repeat can't iterate over maps.
		List<Map.Entry<Character, List<String>>> list = new ArrayList<Map.Entry<Character, List<String>>>();
		list.addAll(map.entrySet());
		
		return list;
	}
	
	private static void sortList(List<String> list, Comparator<String> comp) {
		Collections.sort( list, comp );
	}

}
