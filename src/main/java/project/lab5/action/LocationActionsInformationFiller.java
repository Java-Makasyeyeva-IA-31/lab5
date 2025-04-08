package project.lab5.action;

import java.util.Calendar;
import java.util.Map;
import java.util.function.Supplier;
import javax.swing.JTextArea;

public class LocationActionsInformationFiller {

    private final JTextArea locationActionsInformationTA;
    private final Map<Integer, Supplier<String>> informationSupliers;

    public LocationActionsInformationFiller(
            Map<Integer, Supplier<String>> informationSupliers,
            JTextArea locationActionsInformationTA) {
        this.informationSupliers = informationSupliers;
        this.locationActionsInformationTA = locationActionsInformationTA;
    }

    public void fill() {
        Calendar calendar = Calendar.getInstance();
        StringBuilder builder = new StringBuilder("Time is ");
        builder.append(calendar.getTime()).append("\n");

        if (informationSupliers.isEmpty()) {
            builder.append("There are no actions now.");
        } else {
            informationSupliers.values().forEach(supplier -> {
                String info = supplier.get();
                builder.append(info).append("\n");
            });
        }

        locationActionsInformationTA.setText(builder.toString());
    }
}
