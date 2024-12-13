package lapr4.jobs4u.app.backoffice.console.presentation.jobOpening;

import eapli.framework.actions.Action;

public class EditJobOpeningAction implements Action {
    @Override
    public boolean execute() {
        return new EditJobOpeningUI().show();
    }
}
