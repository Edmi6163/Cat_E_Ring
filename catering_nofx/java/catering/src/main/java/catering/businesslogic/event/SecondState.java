package catering.businesslogic.event;

import catering.businesslogic.summaryDocument.SummaryDocument;
import java.util.ArrayList;

public class SecondState implements EventState {
    @Override
    public void modeEvent(Event event) {
        System.out.println("Second state: modeEvent");
        ArrayList<SummaryDocument> docs = event.getSummaryDocumentArrayList();
    }

    @Override
    public void changeMode(Event event) {
        System.out.println("Changing from SecondState to InitialState");
        event.setState(new InitialState());
    }
}