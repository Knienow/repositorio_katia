package nienow.katia.uno.morintegraocomjava.utils_app;

public class UtilsApp {
    private static final String TAG = "UtilsApp";
    private static UtilsApp.DataBaseCrudOperations dataBaseCrudOperations;

    public enum DataBaseCrudOperations{
        CREATE,
        READ,
        UPDATE,
        DELETE,
        NONE
    }

}
