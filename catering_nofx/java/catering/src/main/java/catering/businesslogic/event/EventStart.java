package catering.businesslogic.event;

import catering.businesslogic.summaryDocument.SummaryDocument;
import java.util.ArrayList;

public class EventStart implements EventState {

    public void modeEvent(Event event) {
        System.out.println("Event in start mode");
        // Esempio di utilizzo dell'ArrayList
        ArrayList<SummaryDocument> docs = event.getsummaryDocumentArrayList();
        if (docs != null && !docs.isEmpty()) {
            System.out.println("Processing summary documents in EventStart");
            // Processa i documenti sommari
        }
    }

  
    public void changeMode(Event event) {
        System.out.println("Changing from EventStart to EventEnd");
        event.setState(new EventEnd());
    }

    public Event getInfoEvent(Event event) {
        System.out.println("Getting event info in EventStart");
        // Puoi aggiungere la logica specifica qui
        return event;
    }
}