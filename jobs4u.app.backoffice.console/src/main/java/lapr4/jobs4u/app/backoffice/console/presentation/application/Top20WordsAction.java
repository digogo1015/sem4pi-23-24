package lapr4.jobs4u.app.backoffice.console.presentation.application;

import eapli.framework.actions.Action;

public class Top20WordsAction implements Action {

    @Override
    public boolean execute() {
        return new Top20WordsUI().show();
    }
}
