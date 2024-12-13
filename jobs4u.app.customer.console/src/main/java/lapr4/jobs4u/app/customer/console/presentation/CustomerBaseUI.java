package lapr4.jobs4u.app.customer.console.presentation;

import eapli.framework.presentation.console.AbstractUI;

@SuppressWarnings("squid:S106")
public abstract class CustomerBaseUI extends AbstractUI {

	@Override
	public String headline() {
		return  null;
	}

	@Override
	protected void drawFormTitle(final String title) {
		final var titleBorder = BORDER.substring(0, 2) + " " + title;
		System.out.println(titleBorder);
		drawFormBorder();
	}
}
