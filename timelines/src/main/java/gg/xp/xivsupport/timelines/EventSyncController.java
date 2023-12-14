package gg.xp.xivsupport.timelines;

import gg.xp.reevent.events.Event;
import gg.xp.xivsupport.timelines.intl.LanguageReplacements;

public interface EventSyncController {
	boolean shouldSync(Event event);

	Class<? extends Event> eventType();

	default boolean isEditable() {
		return false;
	};

	EventSyncController translateWith(LanguageReplacements replacements);

	String toTextFormat();
}
