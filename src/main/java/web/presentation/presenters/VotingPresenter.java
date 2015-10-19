package web.presentation.presenters;

import web.presentation.models.Model;

public class VotingPresenter {

    private String themeName;
    
    private Integer value;
    
    public void setThemeName(String themeName) {
        this.themeName = themeName;        
    }

    public void setValue(Integer value) {
        this.value = value;        
    }
    
    public String process(Model model) {
        return "VotingView";
    }

    public String voteTheme(Model model) {
        return "VotingView";
    }

}
