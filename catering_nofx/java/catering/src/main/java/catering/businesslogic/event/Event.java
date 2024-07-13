package catering.businesslogic.event;

import catering.businesslogic.shiftWork.ShiftWork;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.event.*;

import java.util.ArrayList;

public class Event implements EventState {
    private ArrayList<SummaryDocument> listSummaryDocument;
    private EventState currentEvent; 
    
    public Event(){
        listSummaryDocument = new ArrayList<>();
        this.currentEvent = new EventStart(); 
    }

    /**
     * 
     * @param listSummaryDocument
     */
    public Event(ArrayList<SummaryDocument> listSummaryDocument) {
        this.listSummaryDocument = listSummaryDocument;
        this.currentState = new EventStart();  // Stato iniziale
    }

    public void setState(EventState newState ){
        this.currentEvent= newState;

    }
    public void modeEvent(Event event) {
        this.currentEvent.modeEvent(this); 
    }

    public void changeMode(Event event) {
        this.currentEvent.changeMode(this);
    }

    public Event getInfoEvent(Event event) {
        return this.currentEvent.getInfoEvent(this);
    }
    public ArrayList<SummaryDocument> getsummaryDocumentArrayList(){
        return this.listSummaryDocument;
    }
}
