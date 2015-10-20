package web.presentation.presenters;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import rest.business.models.entities.Theme;
import rest.business.models.entities.Vote;
import rest.data.models.daos.DaoFactory;
import web.presentation.models.Model;

public class VotingPresenter {

    private String themeName;    
    private Integer value;
    
    private SortedMap<String,Double> themeTransfers = new TreeMap<String,Double>();
    private List<Vote> votes = new ArrayList<>();
    private ArrayList<Theme> themes = (ArrayList<Theme>) DaoFactory.getFactory().getThemeDao().findAll();
    
    private void init() {
        for (int i=0; i<themes.size(); i++){
            votes = DaoFactory.getFactory().getVoteDao().findByTheme(themes.get(i));
            themeTransfers.put(themes.get(i).getName(), Double.valueOf((double)sum(votes)/votes.size()));
        }
    }
    
    public void setThemeName(String themeName) {
        this.themeName = themeName;        
    }

    public void setValue(Integer value) {
        this.value = value;        
    }
    
    private int sum (List<Vote> votes) {
        int result = 0;
        for (int i=0; i<votes.size(); i++)
            result += votes.get(i).getVote();
        return result;
    }
    
    public String process(Model model) {        
        init();
        model.put("themeTransfers", themeTransfers);
        return "VotingView";
    }

    public String voteTheme(Model model) {
        init();
        Theme theme = DaoFactory.getFactory().getThemeDao().findByName(themeName);
        int id = DaoFactory.getFactory().getVoteDao().findByTheme(theme).size();
        Vote vote = new Vote(id,value,theme);
        DaoFactory.getFactory().getVoteDao().create(vote);
        Double average;
        if (themeTransfers.get(themeName).isNaN())
            average = Double.valueOf(value);
        else
            average = Double.valueOf((themeTransfers.get(themeName) + value) / 2);
        themeTransfers.put(themeName, average);
        model.put("themeTransfers", themeTransfers);
        return "VotingView";
    }

}
