package lapr4.jobs4u.app.customer.console;

import lapr4.jobs4u.app.customer.console.presentation.FrontMenu;

/**
 * Customer App.
 */
@SuppressWarnings("squid:S106")
public final class CustomerApp {

    private CustomerApp() {
    }

    public static void main(final String[] args) {
        System.out.println("=====================================");
        System.out.println("Customer App");
        System.out.println("=====================================");

        new FrontMenu().show();

        System.exit(0);
    }
}
