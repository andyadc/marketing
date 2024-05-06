package com.andyadc.dddframework.base.messaging.event;

public class BaseEventTests {

	public static void main(String[] args) {
		BaseEvent.EventMessage<Object> eventMessage = BaseEvent.EventMessage.builder().id("").timestamp(null).data("null").build();

	}
}
