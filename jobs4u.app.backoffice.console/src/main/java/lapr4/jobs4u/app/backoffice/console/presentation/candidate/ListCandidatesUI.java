package lapr4.jobs4u.app.backoffice.console.presentation.candidate;

import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.candidatemanagement.application.ListCandidatesController;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;


@SuppressWarnings({"squid:S106"})
public class ListCandidatesUI extends AbstractListUI<Candidate> {
    private final ListCandidatesController controller = new ListCandidatesController();

    @Override
    public String headline() {
        return "List Users";
    }

    @Override
    protected String emptyMessage() {
        return "No Candidates to be Shown";
    }

    @Override
    protected Iterable<Candidate> elements() {
        return controller.allActiveUsers();
    }

    @Override
    protected Visitor<Candidate> elementPrinter() {
        return new CandidatePrinter();
    }

    @Override
    protected String elementName() {
        return "Candidate";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-25s%-20s%-20s", "Email Address", "F. NAME", "L. NAME");
    }
}
