package lapr4.jobs4u.app.backoffice.console.presentation.notifications;

import eapli.framework.actions.Action;

public class PublishResultsAction implements Action {

    @Override
    public boolean execute() {
        return new PublishResultsUI().show();
    }
}
