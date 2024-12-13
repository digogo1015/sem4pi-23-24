package lapr4.jobs4u.app.candidate.console.presentation.candidateClient;

import eapli.framework.actions.Action;
import lombok.SneakyThrows;


public class TcpCandidateAction implements Action {

    @SneakyThrows
    @Override
    public boolean execute() {
        System.out.println("\n\n+==============================================================================+");
        return new TcpCandidateUI().doShow();
    }
}
