package com.andyadc.marketing.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "shedlock")
public class Shedlock {

	@Id
	private String name;
	@Column(value = "lock_until")
	private LocalDateTime lockUntil;
	@Column(value = "locked_at")
	private LocalDateTime lockedAt;
	@Column(value = "locked_by")
	private String lockedBy;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLockUntil() {
		return lockUntil;
	}

	public void setLockUntil(LocalDateTime lockUntil) {
		this.lockUntil = lockUntil;
	}

	public LocalDateTime getLockedAt() {
		return lockedAt;
	}

	public void setLockedAt(LocalDateTime lockedAt) {
		this.lockedAt = lockedAt;
	}

	public String getLockedBy() {
		return lockedBy;
	}

	public void setLockedBy(String lockedBy) {
		this.lockedBy = lockedBy;
	}

	@Override
	public String toString() {
		return "Shedlock{" +
			"name=" + name +
			", lockUntil=" + lockUntil +
			", lockedAt=" + lockedAt +
			", lockedBy=" + lockedBy +
			'}';
	}
}
