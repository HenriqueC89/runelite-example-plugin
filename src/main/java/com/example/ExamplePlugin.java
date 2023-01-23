package com.example;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.events.WidgetLoaded;

@Slf4j
@PluginDescriptor(
		name = "Runelite Example Plugin"
)
public class ExamplePlugin extends Plugin
{
	@Inject
	private Client client;

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.BANK_GROUP_ID)
		{
			final Widget bankTutorialButtonWidget = client.getWidget(WidgetInfo.BANK_TUTORIAL_BUTTON);
			log.info(String.valueOf(bankTutorialButtonWidget));

			if (bankTutorialButtonWidget != null && !bankTutorialButtonWidget.isSelfHidden())
			{
				bankTutorialButtonWidget.setHidden(true);
			}
		}
	}
}
