package com.abyat.mvp.model.impl;

import com.abyat.mvp.model.Position;

/**
 * Available handball player positions.
 *
 * @author Salman Khan
 */
public enum HandballPosition implements Position<HandballAction> {

	G("Goalkeeper") {
		@Override
		public int getRating(HandballAction action, int times) {
			switch (action) {
			case GOAL_MADE:
				return 5 * times;
			default:
				return -1 * times;
			}
		}
	},
	F("Field player") {
		@Override
		public int getRating(HandballAction action, int times) {
			switch (action) {
			case GOAL_MADE:
				return times;
			default:
				return -1 * times;
			}
		}
	};

	private String _brief;

	HandballPosition(String brief) {
		_brief = brief;
	}
}
