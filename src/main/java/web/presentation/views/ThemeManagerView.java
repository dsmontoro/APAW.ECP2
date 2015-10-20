package web.presentation.views;

import java.util.ArrayList;
import java.util.List;

import rest.business.models.entities.Theme;
import web.presentation.models.Model;

public class ThemeManagerView implements View {

	@Override
	public void show(Model model) {
	    System.out.println("Theme Manager Page");
	    System.out.print("   Temas: [");
	    List<Theme> themes = (ArrayList<Theme>)model.get("themes");
	    for (int i=0 ; i<themes.size() ; i++){
	    	if (i==0)
	    		System.out.print(themes.get(i).getName());
	    	else
	    		System.out.print(", " + themes.get(i).getName());
	    }
	    System.out.println("]");
	}

}
