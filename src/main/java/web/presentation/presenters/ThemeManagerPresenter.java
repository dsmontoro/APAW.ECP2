package web.presentation.presenters;

import java.util.ArrayList;

import rest.business.models.entities.Theme;
import rest.data.models.daos.DaoFactory;
import web.presentation.models.Model;

public class ThemeManagerPresenter {

    private String themeName;
    
    private ArrayList<Theme> themes = (ArrayList<Theme>) DaoFactory.getFactory().getThemeDao().findAll();
    
    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
    
    public String process(Model model) {        
    	model.put("themes", themes);
        return "ThemeManagerView";
    }

    public String createTheme(Model model) {        
    	Theme theme = new Theme(themes.size(),themeName);
    	DaoFactory.getFactory().getThemeDao().create(theme);
    	themes.add(theme);
    	model.put("themes", themes);
        return "ThemeManagerView";
    }

}
