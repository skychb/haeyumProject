package org.next.controller;

import javax.servlet.http.HttpSession;

import org.next.model.Participant;


public class UserSessionUtils {
	public static final String USER_SESSION_KEY = "user";
	
	public static Participant getUserFromSession(HttpSession session) {
		Object participant = session.getAttribute(USER_SESSION_KEY);
		if (participant == null) {
			return null;
		}
		return (Participant)participant;
	}
	
	public static boolean isLogined(HttpSession session) {
		if (getUserFromSession(session) == null) {
			return false;
		}
		return true;
	}
	
	public static boolean isSameUser(HttpSession session, Participant participant) {
		if (!isLogined(session)) {
			return false;
		}
		
		if (participant == null) {
			return false;
		}
		
		return participant.isSameUser(getUserFromSession(session));
	}
}
