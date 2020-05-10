package com.example.hbr.idlingresource;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;

public class ElapsedTimeIdlingResource implements IdlingResource {
	private static final long WAITING_TIME = 500;
	private final long startTime;
	private final long waitingTime;
	private ResourceCallback resourceCallback;

	private ElapsedTimeIdlingResource(long waitingTime) {
		this.startTime = System.currentTimeMillis();
		this.waitingTime = waitingTime;
	}

	public static void waitFor(Listener listener) {
		IdlingResource idlingResource = new ElapsedTimeIdlingResource(WAITING_TIME);
		Espresso.registerIdlingResources(idlingResource);
		listener.inIdle();
		Espresso.unregisterIdlingResources(idlingResource);
	}

	@Override
	public String getName() {
		return ElapsedTimeIdlingResource.class.getName();
	}

	@Override
	public boolean isIdleNow() {
		long elapsed = System.currentTimeMillis() - startTime;
		boolean idle = (elapsed >= waitingTime);
		if (idle) {
			resourceCallback.onTransitionToIdle();
		}
		return idle;
	}

	@Override
	public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
		this.resourceCallback = resourceCallback;
	}

	public interface Listener {
		void inIdle();
	}
}
