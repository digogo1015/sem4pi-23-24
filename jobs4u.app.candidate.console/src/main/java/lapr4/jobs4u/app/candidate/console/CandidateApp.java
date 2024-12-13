package lapr4.jobs4u.app.candidate.console;

import lapr4.jobs4u.app.candidate.console.presentation.FrontMenu;

/**
 * Candidate App.
 */
@SuppressWarnings("squid:S106")
public final class CandidateApp {

	private CandidateApp() {
	}

	public static void main(final String[] args) {
		System.out.println("=====================================");
		System.out.println("Candidate App");
		System.out.println("=====================================");

		new FrontMenu().show();

		System.exit(0);
	}
}
