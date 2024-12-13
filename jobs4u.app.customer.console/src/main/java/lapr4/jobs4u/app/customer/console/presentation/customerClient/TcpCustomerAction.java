package lapr4.jobs4u.app.customer.console.presentation.customerClient;

import eapli.framework.actions.Action;
import lombok.SneakyThrows;


public class TcpCustomerAction implements Action {

    @SneakyThrows
    @Override
    public boolean execute() {
        System.out.println("\n\n+==============================================================================+");
        return new TcpCustomerUI().doShow();
    }
}
