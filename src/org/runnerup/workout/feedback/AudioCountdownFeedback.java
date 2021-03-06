/*
 * Copyright (C) 2013 jonas.oreland@gmail.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.runnerup.workout.feedback;

import java.util.HashMap;

import org.runnerup.util.Formatter;
import org.runnerup.workout.Dimension;
import org.runnerup.workout.Feedback;
import org.runnerup.workout.Scope;
import org.runnerup.workout.Workout;

import android.content.Context;
import android.speech.tts.TextToSpeech;

public class AudioCountdownFeedback extends Feedback {

	boolean emitScope = false;
	Scope scope = Scope.STEP;
	Dimension dimension = Dimension.TIME;
	RUTextToSpeech textToSpeech;
	Formatter formatter;
	
	public AudioCountdownFeedback(Scope s, Dimension d) {
		this.scope = s;
		this.dimension = d;
	}
	
	@Override
	public void onInit(Workout s, HashMap<String, Object> bindValues) {
		textToSpeech = (RUTextToSpeech) bindValues.get(Workout.KEY_TTS);
		formatter = (Formatter) bindValues.get(Workout.KEY_FORMATTER);
	}
	
	@Override
	public boolean equals(Feedback _other) {
		if (!(_other instanceof AudioCountdownFeedback))
			return false;

		AudioCountdownFeedback other = (AudioCountdownFeedback) _other;

		if (scope != other.scope)
			return false;
		
		if (dimension != other.dimension)
			return false;
		
		return true;
	}

	@Override
	public void emit(Workout w, Context ctx) {
		double remaining = w.getRemaining(scope, dimension); // SI
		
		if (remaining > 0) {
			String msg = formatter.formatRemaining(Formatter.CUE_SHORT, dimension, remaining);
			textToSpeech.speak(msg, TextToSpeech.QUEUE_ADD, null);
		}
	}
}
