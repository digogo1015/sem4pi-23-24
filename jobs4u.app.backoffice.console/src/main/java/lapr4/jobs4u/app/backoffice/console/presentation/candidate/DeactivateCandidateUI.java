/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.app.backoffice.console.presentation.candidate;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.candidatemanagement.application.ActivateCandidateController;
import lapr4.jobs4u.candidatemanagement.application.DeactivateCandidateController;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"squid:S106"})
public class DeactivateCandidateUI extends AbstractListUI<Candidate> {
    private final DeactivateCandidateController controller = new DeactivateCandidateController();

    protected boolean doShow() {

        final List<Candidate> list = new ArrayList<>();

        final Iterable<Candidate> iterable = elements();

        final CandidatePrinter printer = new CandidatePrinter();

        if (!iterable.iterator().hasNext()) {
            System.out.println("There are no Candidates registered/Active");
        } else {
            int cont = 1;
            System.out.println("Active Candidates\n");
            System.out.print(listHeader() + "\n");
            for (final Candidate candidate : iterable) {
                list.add(candidate);
                System.out.printf("%d. ", cont);
                printer.printInfoCandidate(candidate);
                cont++;
            }
            final int option = Console.readInteger("\nEnter the number for the desired Candidate: ");
            if (option == 0) {
                System.out.println("No Candidate selected");
            } else {
                try {
                    this.controller.deactivateCandidate(list.get(option - 1).user());
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
