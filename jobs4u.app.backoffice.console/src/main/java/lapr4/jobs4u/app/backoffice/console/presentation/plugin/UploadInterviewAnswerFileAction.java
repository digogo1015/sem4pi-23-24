package lapr4.jobs4u.app.backoffice.console.presentation.plugin;

import eapli.framework.actions.Action;

public class UploadInterviewAnswerFileAction implements Action {

    @Override
    public boolean execute() {
        return new UploadInterviewAnswerFileUI().show();
    }
}