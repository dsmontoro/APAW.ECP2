package web.presentation.views;

import java.util.TreeMap;

import web.presentation.models.Model;

public class VotingView implements View {

	@SuppressWarnings("unchecked")
    @Override
	public void show(Model model) {
	    System.out.println("Voting Page");
	    System.out.print("   Temas: [");
	    TreeMap<String,Double> themeTransfers = (TreeMap<String, Double>) model.get("themeTransfers");
	    String[] themesNames = themeTransfers.keySet().toArray(new String[0]);
	    for(int i=0; i<themesNames.length; i++){
	        if (i==0)
	            System.out.print("ThemeTransfer [themeName="+themesNames[i]+", average="+themeTransfers.get(themesNames[i])+"]");
	        else
	            System.out.print(", ThemeTransfer [themeName="+themesNames[i]+", average="+themeTransfers.get(themesNames[i])+"]");
	    }
	    System.out.println("]");
	}

}
