package catering.businesslogic.event;

import catering.businesslogic.summaryDocument.SummaryDocument;
import java.util.ArrayList;

public class EventRecurrent implements EventState {
    @Override
    public void modeEvent(Event event) {
        System.out.println("Event in recurrent mode");
        ArrayList<SummaryDocument> docs = event.getsummaryDocumentArrayList();
        if (docs != null && !docs.isEmpty()) {
            System.out.println("Processing summary documents in EventRecurrent");
        }
    }

    
    public void changeMode(Event event) {
        System.out.println("Changing from EventRecurrent to EventStart");
        event.setState(new EventStart());
    }

    @Override
    public Event getInfoEvent(Event event) {
        System.out.println("Getting event info in EventRecurrent");
        return event;
    }
}