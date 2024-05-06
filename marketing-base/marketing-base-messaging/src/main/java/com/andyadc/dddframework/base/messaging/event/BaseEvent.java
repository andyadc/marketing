package com.andyadc.dddframework.base.messaging.event;

import java.time.LocalDateTime;

public abstract class BaseEvent<T> {

	public abstract EventMessage<T> buildEventMessage(T data);

	public abstract String topic();

	public static class EventMessage<T> {

		private String id;
		private LocalDateTime timestamp;
		private T data;

		public EventMessage(Builder<T> builder) {
			this.id = builder.id;
			this.timestamp = builder.timestamp;
			this.data = builder.data;
		}

		public static Builder build() {
			return new Builder<>();
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "EventMessage{" +
				"id=" + id +
				", timestamp=" + timestamp +
				", data=" + data +
				'}';
		}

		public static class Builder<T> {

			private String id;
			private LocalDateTime timestamp;
			private T data;

			public Builder() {
			}

			public Builder id(String id) {
				this.id = id;
				return this;
			}

			public Builder timestamp(LocalDateTime timestamp) {
				this.timestamp = timestamp;
				return this;
			}

			public Builder data(T data) {
				this.data = data;
				return this;
			}

			public EventMessage<T> build() {
				return new EventMessage<>(this);
			}
		}
	}
}
