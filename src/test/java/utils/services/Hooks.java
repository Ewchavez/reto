package utils.services;
import utils.SessionManager;

public class Hooks extends SessionManager {
    public static void setEvidence(String text) {
        SessionManager.scenario = SessionManager.obternerSesion("scenario");
        SessionManager.scenario.write(text);
    }

    }




