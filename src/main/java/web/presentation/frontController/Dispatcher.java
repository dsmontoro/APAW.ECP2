package web.presentation.frontController;

import http.HttpRequest;
import http.HttpResponse;
import web.presentation.models.Model;
import web.presentation.presenters.ThemeManagerPresenter;
import web.presentation.presenters.VotingPresenter;
import web.presentation.views.ErrorView;
import web.presentation.views.ThemeManagerView;
import web.presentation.views.View;
import web.presentation.views.VotingView;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            nextView = votingPresenter.process(model);
            break;
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            nextView = themeManagerPresenter.process(model);
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            if ("voteTheme".equals(action)) {
                votingPresenter.setThemeName(request.getParams().get("themeName"));
                votingPresenter.setValue(Integer.valueOf(request.getParams().get("value")));
                nextView = votingPresenter.voteTheme(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            if ("createTheme".equals(action)) {
                themeManagerPresenter.setThemeName(request.getParams().get("themeName"));
                nextView = themeManagerPresenter.createTheme(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        }
        this.show(nextView, model);
    }
    
    private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case "VotingView":
            view = new VotingView();
            break;
        case "ThemeManagerView":
            view = new ThemeManagerView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }

}
