package catering.businesslogic.event;

import catering.businesslogic.summaryDocument.SummaryDocument;
import java.util.ArrayList;

public class EventEnd implements EventState {
    @Override
    public void modeEvent(Event event) {
        System.out.println("Event in end mode");
        // Esempio di utilizzo dell'ArrayList
        ArrayList<SummaryDocument> docs = event.getsummaryDocumentArrayList();
        if (docs != null && !docs.isEmpty()) {
            System.out.println("Processing summary documents in EventEnd");
            // Processa i documenti sommari

        }
    }

    public void changeMode(Event event) {
        System.out.println("Changing from EventEnd to EventRecurrent");
        event.setState(new EventRecurrent());
    }

    @Override
    public Event getInfoEvent(Event event) {
        System.out.println("Getting event info in EventEnd");
        // Puoi aggiungere la logica specifica qui
        return event;
    }
}