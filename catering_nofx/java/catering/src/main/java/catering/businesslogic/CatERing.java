package catering.businesslogic;

import catering.businesslogic.billBoard.BillBoard;
import catering.businesslogic.event.EventManager;
import catering.businesslogic.menu.MenuManager;
import catering.businesslogic.recipe.RecipeManager;
import catering.businesslogic.shiftWorkKitchen.ShiftWorkManager;
import catering.businesslogic.summaryDocument.SummaryDocumentManager;
import catering.businesslogic.task.TaskManager;
import catering.businesslogic.user.UserManager;
import catering.persistence.MenuPersistence;

public class CatERing {
    private static CatERing singleInstance;

    public static CatERing getInstance() {
        if (singleInstance == null) {
            singleInstance = new CatERing();
        }
        return singleInstance;
    }

    private MenuManager menuMgr;
    private RecipeManager recipeMgr;
    private UserManager userMgr;
    private EventManager eventMgr;
    private TaskManager taskManager;
    private MenuPersistence menuPersistence;
    private SummaryDocumentManager summaryDocumentManager;
    private BillBoard billBoardManager;
    private ShiftWorkManager shiftWorkManager;
    private CatERing() {
        menuMgr = new MenuManager();
        recipeMgr = new RecipeManager();
        userMgr = new UserManager();
        eventMgr = new EventManager();
        menuPersistence = new MenuPersistence();
        menuMgr.addEventReceiver(menuPersistence);
        summaryDocumentManager = new SummaryDocumentManager();
        taskManager = TaskManager.getTaskManager();  // Properly initializing TaskManager
        billBoardManager = getBillBoardManager().getInstance();
        shiftWorkManager = getShiftWorkManager();
    }

    public ShiftWorkManager getShiftWorkManager() {
        return shiftWorkManager;
    }
    public MenuManager getMenuManager() {
        return menuMgr;
    }

    public RecipeManager getRecipeManager() {
        return recipeMgr;
    }

    public UserManager getUserManager() {
        return userMgr;
    }

    public EventManager getEventManager() {
        return eventMgr;
    }


    public SummaryDocumentManager getSummaryDocumentManager() {
        return summaryDocumentManager;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public  BillBoard getBillBoardManager() {
        return billBoardManager;
    }
}