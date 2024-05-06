package com.andyadc.dddframework.base.messaging.event;

public class BaseEventTests {

	public static void main(String[] args) {
		BaseEvent.EventMessage eventMessage = BaseEvent.EventMessage.build().id("").timestamp(null).data(null).build();

	}
}
