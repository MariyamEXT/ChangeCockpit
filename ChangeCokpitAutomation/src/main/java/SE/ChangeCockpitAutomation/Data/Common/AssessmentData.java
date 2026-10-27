package SE.ChangeCockpitAutomation.Data.Common;

import java.util.Random;

public class AssessmentData {

    public static String getAssessmentName() {

        String chars =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#";

        StringBuilder name =
                new StringBuilder();

        Random random =
                new Random();

        for (int i = 0; i < 6; i++) {

            name.append(
                    chars.charAt(
                            random.nextInt(chars.length())));
        }

        return name.toString();
    }
}