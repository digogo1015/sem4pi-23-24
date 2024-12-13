package lapr4.jobs4u.app.backoffice.console.presentation.candidate;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.candidatemanagement.application.ShowCandidateInfoController;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;

import java.util.List;


@SuppressWarnings({"squid:S106"})
public class ShowCandidateInfoUI extends AbstractListUI<Candidate> {
    private final ShowCandidateInfoController controller = new ShowCandidateInfoController();

    protected boolean doShow() {
        final List<Candidate> candidates = controller.allActiveUsers();
        final CandidatePrinter printer = new CandidatePrinter();

        if (candidates.isEmpty()) {
            System.out.println("There are no Candidates registered");
        } else {
            int cont = 1;
            System.out.println("Candidates Registered\n");
            System.out.print(listHeader() + "\n");
            for (final Candidate candidate : candidates) {
                System.out.printf("%d. ", cont);
                printer.printInfoCandidate(candidate);
                cont++;
            }

            final int option = Console.readInteger("\nEnter the number for the desired Candidate: ");
            if (option == 0) {
                System.out.println("No Candidate selected");
            } else {
                try {
                    System.out.printf("#  %-25s%-20s%-20s%-20s", "Email Address", "F. NAME", "L. NAME", "Phone Number");
                    printer.printAllInfoCandidate(candidates.get(option - 1));
                } catch (Exception ex) {
                    System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
                }
            }
        }
        return true;
    }


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
