package SE.ChangeCockpitAutomation.Data.Common;

public class StageData {

    public static String getStageName() {
        return "Stage_" + System.currentTimeMillis();
    }

    public static int getOrder() {
        return 1;
    }

    public static String getStageType() {
        return "CoreTeam";
    }
    
    public static String getDocumentTypeName() {

        String chars =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int index = (int) (Math.random() * chars.length());
            builder.append(chars.charAt(index));
        }

        return builder.toString();
    }
}