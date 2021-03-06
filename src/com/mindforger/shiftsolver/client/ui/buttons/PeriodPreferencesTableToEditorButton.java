package com.mindforger.shiftsolver.client.ui.buttons;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.mindforger.shiftsolver.client.RiaContext;

public class PeriodPreferencesTableToEditorButton extends Button {
	
	public PeriodPreferencesTableToEditorButton(
			final String periodPreferencesId,
			int year,
			int month,
			final String cssClass,
			final RiaContext ctx) {
		setText(year+"/"+month);
		setTitle(ctx.getI18n().year()+"/"+ctx.getI18n().month());
		setStyleName(cssClass);

		addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {								
	    		ctx.getStatusLine().showProgress(ctx.getI18n().loadingPeriodPreferences());
	      		ctx.getRia().loadPeriodPreferences(periodPreferencesId);
	      		ctx.getStatusLine().showInfo(ctx.getI18n().periodPreferencesLoaded());
			}
		});
	}
}
