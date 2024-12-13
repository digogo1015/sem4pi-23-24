package lapr4.jobs4u.app.backoffice.console.presentation.plugin;

import eapli.framework.actions.Action;

public class SelectInterviewModelAction implements Action {

    @Override
    public boolean execute() {
        return new SelectInterviewModelUI().show();
    }
}
