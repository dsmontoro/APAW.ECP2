package web.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import rest.business.models.entities.Theme;
import rest.data.models.daos.DaoFactory;
import web.presentation.models.Model;

public class ThemeManagerPresenter {

    private String themeName;
    
    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
    
    public String process(Model model) {
        List<Theme> themes = new ArrayList<>();
    	themes = DaoFactory.getFactory().getThemeDao().findAll();
    	model.put("themes", themes);
        return "ThemeManagerView";
    }

    public String createTheme(Model model) {  
        List<Theme> themes = new ArrayList<>();
        themes = DaoFactory.getFactory().getThemeDao().findAll();
    	Theme theme = new Theme(themes.size(),themeName);
    	DaoFactory.getFactory().getThemeDao().create(theme);
    	themes.add(theme);
    	model.put("themes", themes);
        return "ThemeManagerView";
    }

}
