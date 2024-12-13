package lapr4.jobs4u.app.backoffice.console.presentation.application;

import eapli.framework.actions.Action;

public class RankCandidatesAction implements Action {

    @Override
    public boolean execute() {
        return new RankCandidatesUI().show();
    }
}
