package web.presentation.presenters;

import web.presentation.models.Model;

public class ThemeManagerPresenter {

    private String themeName;
    
    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
    
    public String process(Model model) {
        return "ThemeManagerView";
    }

    public String createTheme(Model model) {
        return "ThemeManagerView";
    }

}
